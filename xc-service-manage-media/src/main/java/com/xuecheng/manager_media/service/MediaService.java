package com.xuecheng.manager_media.service;

import com.xuecheng.framework.domain.media.MediaFile;
import com.xuecheng.framework.domain.media.response.CheckChunkResult;
import com.xuecheng.framework.domain.media.response.MediaCode;
import com.xuecheng.framework.exception.CustomException;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manager_media.dao.MediaFileRepository;
import org.apache.commons.io.IOUtils;
import org.hibernate.result.Outputs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.Objects;

/**
 * @Author: houyong
 * @Date: 2019/5/4 11:03
 * @describe
 */
@Service
public class MediaService {
    @Resource
    MediaFileRepository mediaFileRepository;

    @Value("${xc-service-manage-media.upload-location}")
    private String filePath;

    //文件上传前的检测，是否存在该文件，检查文件上传的目录是否存在
    public ResponseResult register(String fileMd5, String fileName, String fileSize, String mimetype, String fileExt) {
        //检查文件是否存在 ：1.物理磁盘是否存在  2.数据库是否存在，都存在则表示已经长传
        //目录规则：1.md5的第一个字符  2.MD5的第二个字符
        String filePath = getFilePath(fileMd5, fileExt);
        File file = new File(filePath);
        boolean exists = file.exists();

        MediaFile one =
                mediaFileRepository.findOne(fileMd5);
        if (exists && Objects.nonNull(one)) {
            throw new CustomException(MediaCode.UPLOAD_FILE_REGISTER_EXIST);
        }

        String folderPath = getFolderPath(fileMd5);
        File file1 = new File(folderPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        return new ResponseResult(CommonCode.SUCCESS);
    }

    private String getFilePath(String fileMd5, String fileExt) {
        return filePath + "/" + fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 1) + "/" + fileMd5 + "/" + fileMd5 + "." + fileExt;

    }

    private String getFolderPath(String fileMd5) {
        return filePath + "/" + fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 1) + "/" + fileMd5 + "/";

    }

    private String getChunkFolderPath(String fileMd5) {

        return filePath + "/" + fileMd5.substring(0, 1) + "/" + fileMd5.substring(1, 1) + "/" + fileMd5 + "/" + "chunk" + "/";

    }


    //检查分块文件是否存在
    public CheckChunkResult checkchunk(String fileMd5, String chunk, String chunkSize) {
        String chunkFolderPath = getChunkFolderPath(fileMd5);
        File file = new File(chunkFolderPath + chunk);
        if (file.exists()) {
            return new CheckChunkResult(MediaCode.CHUNK_FILE_EXIST_CHECK, true);
        }
        return new CheckChunkResult(MediaCode.CHUNK_FILE_NOTEXIST_CHECK, false);
    }

    //上传分块文件
    public ResponseResult uploadchunk(MultipartFile file, String fileMd5, String chunk) {
        String chunkFolderPath = getChunkFolderPath(fileMd5);
        File file1 = new File(chunkFolderPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(chunkFolderPath + chunk);
            inputStream = file.getInputStream();
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
        return null;
    }

    public ResponseResult mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        return null;
    }
}
