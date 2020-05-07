package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-07-16:14
 */


@RestController
public class OpenFeignController {


    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{Id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("Id") Long id) {
        CommonResult result = paymentService.getById(id);
        return result;

    }


    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentService.paymentFeignTimeOut();
    }




}
