package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zjx
 * @create 2020-05-11-15:26
 */

@Component
public class PaymentHystrixFallBackService implements  PaymentHystrixService {
    @Override
    public String Payment_OK(Integer id) {
        return "================Payment_Ok,FallBack ================";
    }

    @Override
    public String Payment_TimeOut(Integer id) {
        return "================Payment_TimeOut,FallBack ================";
    }
}
