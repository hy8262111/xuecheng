package com.xuecheng.manager_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: houyong
 * @Date: 2019/3/3 11:02
 * @describe
 */
@EnableDiscoveryClient
@SpringBootApplication//扫描所在包及子包的bean，注入到ioc中
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.xuecheng.api"})//扫描接口
@ComponentScan(basePackages = {"com.xuecheng.manager_cms"})//扫描本项目下的所有类
@ComponentScan(basePackages = {"com.xuecheng.framework"})//扫描本项目下的所有类
public class ManagerCmsMain {
    public static void main(String[] args) {
        SpringApplication.run(ManagerCmsMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
