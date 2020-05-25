package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.CommonResult;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zjx
 * @create 2020-05-25-12:07
 */


@RestController
public class OrderController {

    @Resource
    private OrderService orderService;




    @GetMapping(value = "/order/create")
    public CommonResult  create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功；");
    }
}
