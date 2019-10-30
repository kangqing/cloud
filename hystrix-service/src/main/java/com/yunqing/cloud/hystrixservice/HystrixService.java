package com.yunqing.cloud.hystrixservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * 业务逻辑
 */
@Service
public class HystrixService {

    /**
     * 注入RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取application.yml中声明的emp-service的服务调用路径
     */
    @Value("${service-url.emp-service}")
    private String empServiceUrl;


    /**
     * @HystrixCommand 可以声明该方法需要使用断路器保护
     * fallbackMethod = "fallback" 指定当服务出现问题，做降级处理，走fallback方法
     * 注意这里的fallback必须和当前方法拥有相同的返回值，参数
     * @param id
     * @return
     */
    @CacheResult(cacheKeyMethod = "method")
    @HystrixCommand(fallbackMethod = "fallback", commandKey = "findById" , threadPoolKey = "getEmpThreadPool")
    public String getEmpById(Long id){

        return restTemplate.getForObject(empServiceUrl + "/emp/{1}", String.class, id);
    }

    public String fallback(@PathVariable Long id) {
        return "服务降级处理";
    }

    public String method(Long id) {
        return String.valueOf(id);
    }


    @CacheRemove(commandKey = "findById", cacheKeyMethod = "method")
    @HystrixCommand(commandKey = "deleteById")
    public String delete(@CacheKey Long id) {
        return restTemplate.postForObject(empServiceUrl + "/emp/delete/{1}", null, String.class, id);
    }

}
