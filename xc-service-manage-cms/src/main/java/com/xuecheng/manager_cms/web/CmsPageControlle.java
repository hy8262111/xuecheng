package com.xuecheng.manager_cms.web;

import com.xuecheng.api.cms.CmsPageApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manager_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/3/3 12:16
 * @describe
 */
@RestController
public class CmsPageControlle implements CmsPageApi {
    @Autowired
    CmsPageService cmsService;

    @Override
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsService.add(cmsPage);
    }

    @Override
    public QueryResponseResult findList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, QueryPageRequest queryPageRequest) {
        return cmsService.findAll(pageNum, pageSize, queryPageRequest);
    }

    
}
