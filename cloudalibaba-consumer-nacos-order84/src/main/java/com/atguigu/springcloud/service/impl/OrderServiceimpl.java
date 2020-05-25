package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.stereotype.Component;

/**
 * @author zjx
 * @create 2020-05-22-16:25
 */

@Component
public class OrderServiceimpl  implements OrderService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444444,"openfeign服务降级，参数无效" ,new Payment(id,"bagabaga"));
    }
}
