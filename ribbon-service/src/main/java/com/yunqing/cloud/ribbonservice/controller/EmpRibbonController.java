package com.yunqing.cloud.ribbonservice.controller;

import com.yunqing.cloud.empservice.entity.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpRibbonController {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.emp-service}")
    private String empServiceUrl;

    /**
     * 通过RestTemplate调用
     * @param id
     * @return
     */
   /* @GetMapping("/{id}")
    public String getEmpByRestTemplate(@PathVariable Long id) {
        log.info(empServiceUrl);
        return restTemplate.getForObject(empServiceUrl + "/emp/{1}", String.class, id);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return restTemplate.postForObject(empServiceUrl + "/emp/delete/{1}", null, String.class, id);
    }

    @PostMapping("/create")
    public String create(@RequestBody Emp emp) {
        return restTemplate.postForObject(empServiceUrl + "/emp/create", emp, String.class);
    }

    @PostMapping("/update")
    public String update(@RequestBody Emp emp) {
        return restTemplate.postForObject(empServiceUrl + "/emp/update", emp, String.class);
    }*/

    /**
     * 查询
     * 通过WebClient调用Get方法
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<String> getEmpByWebClient(@PathVariable Long id) {
        log.info(empServiceUrl);
        return webClient.build()
                .get()
                .uri(empServiceUrl + "/emp/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * 删除
     * 通过WebClient调用Post方法
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public Mono<String> delete(@PathVariable Long id) {
        return webClient.build()
                .post()
                .uri(empServiceUrl + "/emp/delete/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * 修改
     * 通过WebClient调用Post方法，方法被@RequestBody修饰，也就是说参数要传递json格式的
     * @param emp
     * @return
     */
    @PostMapping("/update")
    public Mono<String> update(@RequestBody Emp emp) {
        log.info("emp = {}", emp.toString());
        return webClient.build()
                .post()
                .uri(empServiceUrl + "/emp/update")
                .syncBody(emp)
                .retrieve()
                .bodyToMono(String.class);
    }

    /**
     * 增加
     * 通过WebClient调用Post方法，方法被@RequestBody修饰，也就是说参数要传递json格式的
     * @param emp
     * @return
     */
    @PostMapping("/create")
    public Mono<String> create(@RequestBody Emp emp) {
        log.info("emp = {}", emp.toString());
        return webClient.build()
                .post()
                .uri(empServiceUrl + "/emp/create")
                .syncBody(emp)
                .retrieve()
                .bodyToMono(String.class);
    }
}
