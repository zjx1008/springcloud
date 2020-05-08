package com.atguigu.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
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


    public String Payment_TimeOut(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程" + Thread.currentThread().getName() + "Payment_TimeOut启动成功, \t" + id + "哈哈 耗时（秒）：" + time;

    }
}
