package com.xuecheng.api.course;

import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: houyong
 * @Date: 2019/3/17 8:52
 * @describe
 */
public interface CourseApi {
    final String coursePre = "/course";

    @GetMapping(coursePre + "/list/{pageNum}/{pageSize}")
    public QueryResponseResult<CourseInfo> findList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, CourseListRequest courseListRequest);

}
