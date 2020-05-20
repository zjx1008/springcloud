package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjx
 * @create 2020-05-19-16:06
 */

@RestController
public class PaymentController {


    public String serviceNacosProviderURL="http://cloudalibaba-provider-payment";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {

        return restTemplate.getForObject(serviceNacosProviderURL + "/payment/nacos/" + id, String.class);

    }


}
