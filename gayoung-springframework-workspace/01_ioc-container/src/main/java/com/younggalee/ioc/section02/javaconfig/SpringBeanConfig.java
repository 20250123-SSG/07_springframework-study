package com.younggalee.ioc.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {
    @Bean
    public Music music1(){
        Music m = new Music();
        m.setTitle("Love wins all");
        m.setGenre("발라드");
        return m;
    }
}
