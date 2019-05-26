package com.xuecheng.manager.course.dao;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: houyong
 * @Date: 2019/3/9 12:52
 * @describe
 */
@Mapper
public interface CourseBaseMapper {
    CourseBase findCourseBaseById(String id);

    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
