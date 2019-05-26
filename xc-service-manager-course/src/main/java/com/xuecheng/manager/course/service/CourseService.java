package com.xuecheng.manager.course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manager.course.dao.CourseBaseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: houyong
 * @Date: 2019/3/17 8:54
 * @describe
 */
@Service
public class CourseService {
    @Resource
    private CourseBaseMapper courseBaseMapper;

    public QueryResponseResult<CourseInfo> findList(Integer pageNum, Integer pageSize, CourseListRequest courseListRequest) {
        if (pageNum < 0) {
            pageNum = 0;
        }
        if (pageSize <= 0) {
            pageSize = 20;
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<CourseInfo> courseInfos = courseBaseMapper.findCourseListPage(courseListRequest);
        QueryResult<CourseInfo> queryResult = new QueryResult();
        List<CourseInfo> result =
                courseInfos.getResult();
        long total = courseInfos.getTotal();
        queryResult.setList(result);
        queryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
