package com.xuecheng.api.category;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: houyong
 * @Date: 2019/3/23 22:18
 * @describe
 */
public interface CategoryApi {
    @RequestMapping("/categoryList")
    public CategoryNode findCategoryNodeList();
}
