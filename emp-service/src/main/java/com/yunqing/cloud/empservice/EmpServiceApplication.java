package com.yunqing.cloud.empservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class EmpServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpServiceApplication.class, args);
    }

}
