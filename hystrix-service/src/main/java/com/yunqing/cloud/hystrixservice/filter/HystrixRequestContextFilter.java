package com.yunqing.cloud.hystrixservice.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(filterName = "hystrixRequestContextFilter", urlPatterns = "/*", asyncSupported = true)
public class HystrixRequestContextFilter implements Filter{
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //初始化Hystrix请求上下文
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            //请求正常通过
            chain.doFilter(request, response);
        } finally {
            //关闭Hystrix请求上下文
            context.shutdown();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
