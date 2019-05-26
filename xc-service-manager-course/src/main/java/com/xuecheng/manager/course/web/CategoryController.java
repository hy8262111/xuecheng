package com.xuecheng.manager.course.web;

import com.xuecheng.api.category.CategoryApi;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.manager.course.dao.CategroyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/3/23 22:19
 * @describe
 */
@RestController
public class CategoryController implements CategoryApi {
    @Autowired
    private CategroyMapper categroyMapper;
    @Override
    public CategoryNode findCategoryNodeList() {
        return categroyMapper.findCategoryNodeList();
    }
}
