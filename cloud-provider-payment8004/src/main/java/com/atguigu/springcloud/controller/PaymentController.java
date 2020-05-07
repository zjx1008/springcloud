package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zjx
 * @create 2020-05-06-13:54
 */



@RestController
@Slf4j
public class PaymentController {

@Value("${server.port}")
    private String serverPort;

@GetMapping("/payment/zk")
    public String paymentzk(){

    return "spring cloud zookeeper port:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
