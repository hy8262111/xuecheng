package com.xuecheng.manager_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manager_cms.dao.CmsConfigRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: houyong
 * @Date: 2019/3/4 12:30
 * @describe
 */
@Service
public class CmsConfigService {
    @Resource
    CmsConfigRepository cmsConfigRepository;

    public CmsConfig findById(String id) {
        return cmsConfigRepository.findOne(id);
    }
}
