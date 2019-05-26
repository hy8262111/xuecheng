package com.xuecheng.manager.course.web;

import com.xuecheng.api.course.CourseApi;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manager.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/3/7 12:24
 * @describe
 */
@RestController
public class CourseController implements CourseApi {
    @Autowired
    private CourseService courseService;

    @Override
    public QueryResponseResult<CourseInfo> findList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize, CourseListRequest courseListRequest) {
        return courseService.findList(pageNum, pageSize, courseListRequest);
    }
}
