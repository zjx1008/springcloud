package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjx
 * @create 2020-04-28-17:44
 */
@RestController
@Slf4j
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";



    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{Id}")
    public CommonResult<Payment> getById(@PathVariable("Id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/"+ id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{Id}")
    public CommonResult<Payment> getById2(@PathVariable("Id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        log.info(entity.toString());
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(4444,"查询失败");
        }
      //  return restTemplate.getForObject(PAYMENT_URL + "/payment/"+ id, CommonResult.class);
    }
}
