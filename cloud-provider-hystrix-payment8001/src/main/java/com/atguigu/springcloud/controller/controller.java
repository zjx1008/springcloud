package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-08-15:12
 */


@RestController
@Slf4j
public class controller {
    @Autowired
    private PaymentService paymentService;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String Payment_OK(@PathVariable("id") Integer id) {
        String paymentOk = paymentService.Payment_OK(id);
        log.info(paymentOk);
        return paymentOk;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String Payment_TimeOut(@PathVariable("id") Integer id) {
        String paymentTimeOut = paymentService.Payment_TimeOut(id);
        log.info(paymentTimeOut);
        return paymentTimeOut;
    }


    @GetMapping("/payment/circuitbreak/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String paymentCircuitBreaker = paymentService.paymentCircuitBreaker(id);
        return paymentCircuitBreaker;


    }

}
