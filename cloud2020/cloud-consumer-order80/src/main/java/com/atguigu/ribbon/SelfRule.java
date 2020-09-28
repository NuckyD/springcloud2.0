package com.atguigu.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelfRule {

    /**
     * 随机
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
