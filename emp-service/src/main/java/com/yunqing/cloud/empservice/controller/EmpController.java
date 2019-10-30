package com.yunqing.cloud.empservice.controller;

import com.yunqing.cloud.empservice.entity.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * emp-service提供的服务，供 Ribbon 调用
 */
@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    /**
     * 增加员工
     * @param emp
     * @return
     */
    @PostMapping("/create")
    public String create(@RequestBody Emp emp) {
        log.info("增加员工 = {}", emp);
        return "200";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        log.info("删除员工 = {}", id);
        return "200";
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody Emp emp) {
        log.info("修改员工 = {}", emp.toString());
        return "200";
    }

    /**
     * 查询员工
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        log.info("查询员工 = {}", id);
        //int i = 1/0;
        return "200";
    }


}
