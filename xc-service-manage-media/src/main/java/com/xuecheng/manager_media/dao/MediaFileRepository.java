package com.xuecheng.manager_media.dao;

import com.xuecheng.framework.domain.media.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: houyong
 * @Date: 2019/5/4 11:02
 * @describe
 */
public interface MediaFileRepository extends MongoRepository<MediaFile,String> {
}
