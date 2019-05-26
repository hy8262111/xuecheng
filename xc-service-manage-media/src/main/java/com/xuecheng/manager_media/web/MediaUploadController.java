package com.xuecheng.manager_media.web;

import com.netflix.discovery.converters.Auto;
import com.xuecheng.api.media.MediaUploadApi;
import com.xuecheng.framework.domain.media.response.CheckChunkResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manager_media.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: houyong
 * @Date: 2019/5/4 11:01
 * @describe
 */
@RestController
public class MediaUploadController implements MediaUploadApi {
    @Autowired
    MediaService mediaService;

    @Override
    public ResponseResult register(String fileMd5, String fileName, String fileSize, String mimetype, String fileExt) {
        return mediaService.register(fileMd5,fileName,fileSize,mimetype,fileExt);
    }

    @Override
    public CheckChunkResult checkchunk(String fileMd5, String chunk, String chunkSize) {
        return mediaService.checkchunk(fileMd5,chunk,chunkSize);
    }

    @Override
    public ResponseResult uploadchunk(MultipartFile file, String fileMd5, String chunk) {
        return mediaService.uploadchunk(file,fileMd5,chunk);
    }

    @Override
    public ResponseResult mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        return mediaService.mergechunks(fileMd5,fileName,fileSize,mimetype,fileExt);
    }
}
