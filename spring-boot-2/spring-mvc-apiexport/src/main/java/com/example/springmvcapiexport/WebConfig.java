package com.example.springmvcapiexport;

import com.example.springmvcapiexport.api.ApiExporter;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean(name = "/api.do")
    public ApiExporter apiExporter() {
        ApiExporter apiExporter = new ApiExporter();
        return apiExporter;
    }

    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new JsonHandlerExceptionResolver());
    }

}
