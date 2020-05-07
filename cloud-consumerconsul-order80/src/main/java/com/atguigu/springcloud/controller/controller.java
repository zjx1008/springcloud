package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjx
 * @create 2020-05-06-16:27
 */

@RestController
public class controller {
    private static final String INVOKE_URL="http://cloud-provider-payment-8006";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String getInvokeUrl(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
                return result;

    }

}
