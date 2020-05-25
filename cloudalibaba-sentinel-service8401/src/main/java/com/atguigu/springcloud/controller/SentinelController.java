package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author zjx
 * @create 2020-05-21-14:50
 */


@RestController
public class SentinelController {

    @GetMapping("/testa")
    public String testA(){
        return " -------------->testA";
    }

    @GetMapping("/testb")
    public String testB(){
        return " -------------->testB";
    }





    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "dealTestEBlockHandler" ,fallback = "testEFallBack")

    public String testE(@RequestParam(value = "p1" ,required = false)String p1, @RequestParam(value="p2" ,required = false)String p2){
        int a =10/0;
        return "--------------> hotkey";
    }
 public String testEFallBack(String p1,String p2){
        return "------------------------->TestE Fall Back";

 }
    public String dealTestEBlockHandler (String p1, String p2, BlockException execption){
        return "------------->dealTestEBlockHandler";
    }
}
