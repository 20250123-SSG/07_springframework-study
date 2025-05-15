package com.jjanggu.ioc.section02.javaconfig;

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
    public Singer singer1(){
        Singer s = new Singer();
        s.setName("아이유");
        s.setMusic(music1());
        return s;
    }

    @Bean(name = "music2") // name속성 작성시 빈의 id가 메소드명이 아닌 name 속성값으로 지정
    public Music abcd(){
        return new Music("EASY", "K-POP");
    }

    @Bean(name="singer2")
    public Singer sfas(){
        return new Singer("르세라핌", abcd());
    }

}
