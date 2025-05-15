package com.minkook.ioc.section02.javaconfig;

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
    @Bean
    public Singer singer(){
        Singer s = new Singer();
        s.setName("아이유");
        s.setMusic(music1());

        return s;
    }

    @Bean
    public Music abcd(){
        return new  Music("EASY","K-POP");
    }

    @Bean(name = "singer2")
    public Singer defg(){
        return new Singer("르세라핌",abcd());
    }
}
