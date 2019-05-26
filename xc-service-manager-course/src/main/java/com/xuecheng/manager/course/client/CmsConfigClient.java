package com.xuecheng.manager.course.client;

import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import io.swagger.annotations.Api;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: houyong
 * @Date: 2019/3/2 20:24
 * @describe
 */
@Api(value="cms配置管理的接口",description="cms配置管理的接口，提供轮播图信息的配置、精品课程的配置及查询操作")
@FeignClient("xc-service-manage-cms")
public interface CmsConfigClient {
    //不要在类上直接使用requestmapping,figen对其支持不太好
    final String cmsPre = "/cms/config";

    @GetMapping(cmsPre + "/getModel/{id}")
    public CmsConfigResult findById(@PathVariable("id") String id);


}
