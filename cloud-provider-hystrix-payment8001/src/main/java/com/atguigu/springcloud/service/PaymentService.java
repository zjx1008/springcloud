package com.atguigu.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zjx
 * @create 2020-05-08-15:07
 */
@Service
public class PaymentService {


    public String Payment_OK(Integer id) {

        return "当前线程" + Thread.currentThread().getName() + "Payment_OK,id\t"+id+"启动成功 哈哈";
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
    @HystrixCommand(fallbackMethod = "Payment_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000" )
    })
    public String Payment_TimeOut(Integer id) {
        int result =10/0;
        int time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程" + Thread.currentThread().getName() + "Payment_TimeOut启动成功, \t" + id + "哈哈 耗时（秒）：" + time;

    }

    public String Payment_TimeOutHandler(Integer id){


        return  "当前线程"+Thread.currentThread().getName()+"Payment_TimeOut方法异常，请稍后再试,id="+id+"\t ( ▼-▼ )";
    }
}
