package com.atguigu.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zjx
 * @create 2020-05-08-15:07
 */
@Service
public class PaymentService {


    public String Payment_OK(Integer id) {

        return "当前线程" + Thread.currentThread().getName() + "Payment_OK,id\t" + id + "启动成功 哈哈";
    }


    /***
     * @HystrixCommand 注解可以设置服务降级，
     *              fallbackMethod 属性表示 如果需要服务降级兜底的方法是那个
     *              commandProperties 属性可是设置多个属性
     *              @HystrixProperty注解表示可以设置哪些属性
     *                  execution.isolation.thread.timeoutInMilliseconds   表示设置超时时间
     *
     *
     */
    @HystrixCommand(fallbackMethod = "Payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String Payment_TimeOut(Integer id) {
//        int a =10/0;
        int time = 0;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程" + Thread.currentThread().getName() + "Payment_TimeOut启动成功, \t" + id + "哈哈 耗时（秒）：" + time;

    }

    public String Payment_TimeOutHandler(Integer id) {
        return "当前线程" + Thread.currentThread().getName() + "Payment_TimeOut方法异常，请稍后再试,id=" + id + "\t ( ▼-▼ )";
    }


    //---------------------------------服务熔断操作--------------------------------------



    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",
    commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启熔断器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//访问次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
           throw  new RuntimeException("id 不能是负数");

        }
        String serNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功 id:" + id + "流水号是" + serNum;
    }

    public String paymentCircuitBreaker_fallBack(Integer id) {
        return "id 不能是负数 ( ▼-▼ )  id"+id;

    }
}
