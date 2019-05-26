package com.xuecheng.manager.course.dao;


import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: houyong
 * @Date: 2019/3/23 22:21
 * @describe
 */
@Mapper
public interface CategroyMapper {
    CategoryNode findCategoryNodeList();
}
