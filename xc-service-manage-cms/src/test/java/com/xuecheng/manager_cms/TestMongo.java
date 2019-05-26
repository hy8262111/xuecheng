package com.xuecheng.manager_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manager_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: houyong
 * @Date: 2019/3/3 11:12
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMongo {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll() {
//         <S extends T> Page<S> findAll(Example<S> var1, Pageable var2);
        Pageable pageabl = new PageRequest(0, 2);
        ExampleMatcher matcher = ExampleMatcher.matching();
        CmsPage cmsPage = new CmsPage();
        Example example = Example.of(cmsPage, matcher);
        cmsPageRepository.findAll();
    }
}
