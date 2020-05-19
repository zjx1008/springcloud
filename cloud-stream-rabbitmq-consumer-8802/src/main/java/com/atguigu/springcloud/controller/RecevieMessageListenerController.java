package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author zjx
 * @create 2020-05-19-10:49
 */

@Component
@EnableBinding(Sink.class)
public class RecevieMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("*******************接受到的message是"+message.getPayload()+",\t端口号是："+serverPort);

    }


}
