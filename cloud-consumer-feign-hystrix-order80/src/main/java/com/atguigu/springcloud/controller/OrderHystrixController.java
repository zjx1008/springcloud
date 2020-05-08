package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-08-15:58
 */

@RestController
public class OrderHystrixController {


    @Autowired
    private PaymentHystrixService orderService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String Payment_OK(@PathVariable("id") Integer id){
        return orderService.Payment_OK(id);
    }


    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String Payment_TimeOut(@PathVariable("id") Integer id){
        return orderService.Payment_TimeOut(id);
    }



}
