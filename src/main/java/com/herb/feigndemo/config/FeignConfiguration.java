package com.herb.feigndemo.config;

import com.herb.feigndemo.handler.FeignErrorDecoder;
import com.herb.feigndemo.util.FeignServiceUtil;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder cashbackFeignErrorDecoder() {
        return new FeignErrorDecoder();
    }
}
