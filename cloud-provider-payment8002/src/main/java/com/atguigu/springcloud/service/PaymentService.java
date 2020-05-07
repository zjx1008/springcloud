package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author zjx
 * @create 2020-04-27-18:40
 */
public interface PaymentService {
    public int createPayment(Payment payment);

    public Payment getById(Long id);
}
