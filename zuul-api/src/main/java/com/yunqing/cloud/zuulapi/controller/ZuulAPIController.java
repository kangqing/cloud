package com.yunqing.cloud.zuulapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abc")
public class ZuulAPIController {


    @GetMapping("/emp/{id}")
    public String get(@PathVariable Long id) {

        return "扼杀旧服务，重定向到本地";
    }
}
