package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zjx
 * @create 2020-04-27-18:49
 */


@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info("********插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,port:" + port, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }


    @GetMapping("/payment/get/{Id}")
    public CommonResult getById(@PathVariable("Id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("********查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,port:" + port, payment);
        } else {
            return new CommonResult(444, "没有对应记录Id为" + id + "的数据,port:" + port, null);
        }
    }



    @GetMapping("/payment/lb")
    public String getPort(){
        return port;
    }

    @GetMapping("/payment/discovery")
    public Object getDisCoveryInfo() {
        List<String> services = discoveryClient.getServices();
        for (String element:services){
            log.info("***********************"+element);

        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance  instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getInstanceId()+"\t" +instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

    return discoveryClient;

    }


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return port;
    }
}
