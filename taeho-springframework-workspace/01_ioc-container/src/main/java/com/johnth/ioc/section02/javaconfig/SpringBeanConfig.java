package com.johnth.ioc.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    public Music music(){
        Music music = new Music();
        music.setTitle("킹쿤타");
        music.setGenre("랩");
        return music;
    }

    @Bean
    public Singer singer(){
        Singer singer = new Singer();
        singer.setName("켄드릭");
        return singer;
    }
    
    // name속성 작성시 Bean의 ID가 메서드명이 아닌 name속성값으로 지정
    @Bean(name="music2")
    public Music nameMusic(){
        return new Music("EASY", "J-POP");
    }

    @Bean(name="singer2")
    public Singer singer2(){
        return new Singer("켄드릭", nameMusic());
    }



    
}
