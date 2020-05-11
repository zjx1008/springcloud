package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-08-15:58
 */

@RestController
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderHystrixController {


    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String Payment_OK(@PathVariable("id") Integer id){


        return paymentHystrixService.Payment_OK(id);
    }


    @GetMapping("consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "PaymentTimeOutFallBackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
//    })

    @HystrixCommand
    public String Payment_TimeOut(@PathVariable("id") Integer id){

        return paymentHystrixService.Payment_TimeOut(id);
    }


    public String PaymentTimeOutFallBackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙请稍后再试，Id："+id;

    }

    public String globalFallBack (){


        return "globalfallBack ";
    }

}
