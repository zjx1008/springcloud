package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zjx
 * @create 2020-05-08-15:55
 */


@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHyxtrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHyxtrixMain80.class, args);
    }
}
