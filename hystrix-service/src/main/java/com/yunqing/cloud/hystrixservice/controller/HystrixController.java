package com.yunqing.cloud.hystrixservice.controller;

import com.yunqing.cloud.hystrixservice.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/emp")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/{id}")
    public String getEmpById(@PathVariable Long id){

        hystrixService.getEmpById(id);
        hystrixService.getEmpById(id);
        hystrixService.getEmpById(id);
        return "200";

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        hystrixService.getEmpById(id);
        hystrixService.delete(id);
        hystrixService.getEmpById(id);

        return "0";

    }






}
