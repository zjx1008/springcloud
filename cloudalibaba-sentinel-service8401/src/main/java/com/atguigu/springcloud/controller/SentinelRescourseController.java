package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.MyHanlder.ConsumerHanlder;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author zjx
 * @create 2020-05-22-12:04
 */

@RestController
public class SentinelRescourseController {


    /***
     * @SentinelResource 注解的blockhandler 只会对 sentinel  配置中心的降级 熔断配置起作用， 如果项目本身除了问题，则不会被降级 熔断
     * @return
     */
    @GetMapping("/byrescourse")
    @SentinelResource(value = "byrescourse", blockHandler = "dealRescourse")
    public CommonResult testRescourse() {
        return new CommonResult(200, "访问成功", new Payment(1111L, "test"));
    }

    public CommonResult dealRescourse(BlockException exception) {
        return new CommonResult(4444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }


    @GetMapping("/byrul")
    @SentinelResource(value = "byrul")
    public CommonResult testRescourse2() {
        return new CommonResult(200, "访问成功", new Payment(1111L, "test"));
    }


    @GetMapping("/consumerHanlder")
    @SentinelResource(value = "consumerHanlder", blockHandlerClass = ConsumerHanlder.class, blockHandler = "consummerHanlder2")
    public CommonResult consumerHanlder() {
        return new CommonResult(200, "按照客户自定义", new Payment(100L, "test"));
    }


}
