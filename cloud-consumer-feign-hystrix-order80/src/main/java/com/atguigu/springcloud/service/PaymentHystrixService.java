package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zjx
 * @create 2020-05-08-15:56
 */


@FeignClient(name="cloud-provider-hystrix-payment" )
@Component
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String Payment_OK(@PathVariable("id") Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public String Payment_TimeOut(@PathVariable("id") Integer id);


}
