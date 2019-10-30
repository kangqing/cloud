package com.yunqing.cloud.feignservice.controller;

import com.yunqing.cloud.empservice.entity.Emp;
import com.yunqing.cloud.feignservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class FeignController {


    @Autowired
    private EmpService empService;

    /**
     * 增加员工
     * @param emp
     * @return
     */
    @PostMapping("/create")
    public String create(@RequestBody Emp emp) {
        return empService.create(emp);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return empService.delete(id);
    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody Emp emp) {
        return empService.update(emp);
    }

    /**
     * 查询员工
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        return empService.get(id);
    }
}
