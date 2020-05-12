package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjx
 * @create 2020-05-07-14:21
 */

/***
 * 设置Ribbon 的负载均衡，修改默认轮询方式 ，返回IRule， 随机方式
 * 注意： 该类不能再主启动类的同级或子目录下，只能另外开一个新不能被它扫描到的目录，要不然 会设置为所有微服务全局使用
 * 再启动类上添加@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
 * name表示 需要使用的微服务名称 configuration 表示 使用该负载均衡
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
