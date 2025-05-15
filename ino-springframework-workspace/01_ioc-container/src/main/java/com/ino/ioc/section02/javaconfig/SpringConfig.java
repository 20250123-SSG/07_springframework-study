package com.ino.ioc.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Music music1(){
        Music music = new Music();
        music.setTitle("love wins all");
        music.setGenre("balad");
        return music;
    }

    @Bean
    public Singer singer1(){
        Singer s = new Singer();
        s.setName("IU");
        s.setMusic(music1());
        return s;
    }

    @Bean(name="music2") // name prop 작성시 bean id 가 메소드명이 아닌 name 속성값으로 지정
    public Music abcd(){
        return new Music("EASY", "K-POP");
    }

    @Bean(name="singer2")
    public Singer asdf(){
        return new Singer("lesserafim", abcd());
    }

}
