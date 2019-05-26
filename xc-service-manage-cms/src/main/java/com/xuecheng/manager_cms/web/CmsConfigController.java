package com.xuecheng.manager_cms.web;

import com.xuecheng.api.cms.CmsConfigApi;
import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.manager_cms.service.CmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/3/3 12:16
 * @describe
 */
@RestController
public class CmsConfigController implements CmsConfigApi {

    @Autowired
    CmsConfigService cmsConfigService;




    @Override
    public CmsConfigResult findById(@PathVariable("id") String id) {
        CmsConfig cmsConfig = cmsConfigService.findById(id);
        return new CmsConfigResult(CommonCode.SUCCESS, cmsConfig);
    }
}
