package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.atguigu.springcloud.Dao"})
public class MyBatisConfig {

}

