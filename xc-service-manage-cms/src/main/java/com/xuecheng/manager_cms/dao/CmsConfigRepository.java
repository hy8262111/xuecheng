package com.xuecheng.manager_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: houyong
 * @Date: 2019/3/3 11:09
 * @describe
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {

}
