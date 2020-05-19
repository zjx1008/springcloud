package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjx
 * @create 2020-05-19-10:29
 */

@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendmessage")
    public String sendMessage(){
        return messageProvider.Send();
    }
}
