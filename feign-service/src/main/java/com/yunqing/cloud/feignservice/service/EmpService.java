package com.yunqing.cloud.feignservice.service;

import com.yunqing.cloud.empservice.entity.Emp;
import com.yunqing.cloud.feignservice.service.impl.EmpServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "emp-service", fallback = EmpServiceImpl.class)
public interface EmpService {

    /**
     * 增加员工
     * @param emp
     * @return
     */
    @PostMapping("/emp/create")
    String create(@RequestBody Emp emp);

    /**
     * 删除员工
     * @param id
     * @return
     */
    @PostMapping("/emp/delete/{id}")
    String delete(@PathVariable Long id);

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PostMapping("/emp/update")
    String update(@RequestBody Emp emp);

    /**
     * 查询员工
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    String get(@PathVariable Long id);

}
