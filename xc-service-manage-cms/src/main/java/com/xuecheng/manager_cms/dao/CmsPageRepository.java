package com.xuecheng.manager_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: houyong
 * @Date: 2019/3/3 11:09
 * @describe
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    CmsPage findBySiteIdAndPageNameAndPageWebPath(String siteId, String pageName, String pageWebPath);
}
