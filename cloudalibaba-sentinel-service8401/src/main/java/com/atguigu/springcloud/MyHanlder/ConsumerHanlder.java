package com.atguigu.springcloud.MyHanlder;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author zjx
 * @create 2020-05-22-15:20
 */
public class ConsumerHanlder {

    public static CommonResult  consummerHanlder1(BlockException exception){
        return  new CommonResult(1111,"按照客户自定义1consummerHanlder1");
    }

    public static CommonResult  consummerHanlder2(BlockException exception){
        return  new CommonResult(1111,"按照客户自定义2consummerHanlder2");
    }
}
