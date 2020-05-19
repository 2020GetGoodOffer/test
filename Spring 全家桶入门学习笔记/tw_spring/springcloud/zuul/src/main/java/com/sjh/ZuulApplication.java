package com.sjh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy//包含了@EnableZuulServer，设置该类为网关的启动类
@EnableAutoConfiguration//可以帮助 SpringBoot 应用将所有符合条件的 @Configuration 加载到当前 SpringBoot 创建并使用的 IoC 容器中。
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
