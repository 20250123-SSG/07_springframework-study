package com.podoseee.ioc.section02.javaconfig;

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

    @Bean(name="music2") // name속성 작성시 빈의 id가 메소드명이 아닌 name 속성값으로 지정
    public Music abcd(){
        Music m2 = new Music();
        m2.setTitle("Run Run");
        m2.setGenre("락");
        return m2;
    }

    @Bean
    public Singer singer2(){
        Singer s = new Singer();
        s.setName("이클립스");
        s.setMusic(abcd());
        return s;
    }

}
