package com.yunqing.cloud.feignservice.service.impl;

import com.yunqing.cloud.empservice.entity.Emp;
import com.yunqing.cloud.feignservice.service.EmpService;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public String create(Emp emp) {
        return "500_create服务降级处理";
    }

    @Override
    public String delete(Long id) {
        return "500_delete服务降级处理";
    }

    @Override
    public String update(Emp emp) {
        return "500_update服务降级处理";
    }

    @Override
    public String get(Long id) {
        return "500_get服务降级处理";
    }
}
