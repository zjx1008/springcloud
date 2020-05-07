package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjx
 * @create 2020-05-07-17:31
 */

@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level getLogger() {
        return Logger.Level.FULL;
    }
}
