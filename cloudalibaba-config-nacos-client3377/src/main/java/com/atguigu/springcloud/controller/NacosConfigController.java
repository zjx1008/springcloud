package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-20-14:40
 */

@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configinfo")
    public String getConfigInfo() {
        return configInfo;
    }


}
