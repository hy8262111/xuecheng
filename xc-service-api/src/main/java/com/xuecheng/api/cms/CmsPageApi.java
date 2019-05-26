package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: houyong
 * @Date: 2019/3/2 20:24
 * @describe
 */
@Api(value="cms页面管理的接口",description="cms页面管理的接口，提供页面添加、删除、修改、查询操作")
public interface CmsPageApi {
    //不要在类上直接使用requestmapping,figen对其支持不太好
    final String cmsPre = "/cms/page";
    @ApiOperation(value="分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="页码",paramType="path"),
            @ApiImplicitParam(name="pageSize",value="每页记录数",paramType="path")
    })
    @GetMapping(cmsPre + "/list/{pageNum}/{pageSize}")
    public QueryResponseResult findList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, @RequestBody QueryPageRequest queryPageRequest);

    @PostMapping(cmsPre + "/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage);

}
