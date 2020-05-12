package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

/**
 * @author zjx
 * @create 2020-05-12-15:34
 */

@Configuration
public class MyConfig {

    @Bean
    public RouteLocator consumRouteLocator(RouteLocatorBuilder  builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("baiduguonei", c -> c.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
