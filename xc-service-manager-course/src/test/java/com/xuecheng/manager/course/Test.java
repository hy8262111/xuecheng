package com.xuecheng.manager.course;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import com.xuecheng.framework.domain.cms.response.CmsConfigResult;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.manager.course.client.CmsConfigClient;
import com.xuecheng.manager.course.dao.CourseBaseMapper;
import com.xuecheng.manager.course.dao.CourseBaseRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.xuecheng.api.cms.CmsPageApi.cmsPre;

/**
 * @Author: houyong
 * @Date: 2019/3/9 12:47
 * @describe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    CourseBaseRepository courseBaseRepository;

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    com.xuecheng.manager.course.client.CmsConfigClient CmsConfigClient;

    @org.junit.Test
    public void test() {
        CourseBase one = courseBaseRepository.findOne("297e7c7c62b888f00162b8a7dec20000");
        System.out.println(one);
    }

    @org.junit.Test
    public void test3() {
        CourseBase courseBaseById = courseBaseMapper.findCourseBaseById("297e7c7c62b888f00162b8a7dec20000");
        System.out.println(courseBaseById);
    }

    @org.junit.Test
    public void testribbon() {
        String url = "http://localhost:31001/cms/config/getModel/5a791725dd573c3574ee333f";
        String url2 = "http://xc-service-manage-cms/cms/config/getModel/5a791725dd573c3574ee333f";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
        Map body = forEntity.getBody();
        System.out.println(JSON.toJSONString(body));
    }

    @org.junit.Test
    public void testrfeign() {
        CmsConfigResult byId = CmsConfigClient.findById("5a795d82dd573c3574ee3360");
        System.out.println(byId);
    }
}
