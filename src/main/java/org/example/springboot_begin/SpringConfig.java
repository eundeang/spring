package org.example.springboot_begin;

import org.example.springboot_begin.aop.TimeTraceAop;
import org.springframework.context.annotation.Bean;

public class SpringConfig {
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
}
