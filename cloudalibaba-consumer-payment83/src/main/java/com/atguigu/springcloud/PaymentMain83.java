package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zjx
 * @create 2020-05-19-16:05
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain83 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain83.class, args);
    }
}
