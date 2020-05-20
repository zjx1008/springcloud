package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjx
 * @create 2020-05-19-16:08
 */
@Configuration
public class RestTemplateConfig {


    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
