package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjx
 * @create 2020-05-07-16:12
 */

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {
    @GetMapping("/payment/{Id}")
    CommonResult<Payment> getById(@PathVariable("Id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();

}
