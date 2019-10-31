package com.yunqing.cloud.zuulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @EnableZuulProxy 开启spring cloud内置的嵌入式zuul反向代理，api网关功能
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ZuulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiApplication.class, args);
    }

}
