package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zjx
 * @create 2020-05-22-15:39
 */


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class,args);
    }
}
