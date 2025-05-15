package com.sotogito.ioc.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //어떻게 동작할지에 대한 정보를 담고 있는 파일
public class SpringBeanConfig {

    @Bean
    public Music music1() { /// 메서드명 == id //<bean id="music1" class="Music"/>
        Music music = new Music();
        music.setTitle("Love wins all");
        music.setGenre("발라드");

        return music;
    }

    @Bean
    public Singer singer1() {
        Singer singer = new Singer();
        singer.setName("아이유");
        singer.setMusic(music1());

        return singer;
    }

    /// name 속성은 같은 타입의 빈을 여러 개 등록할 때, 구분을 명확하게 하기 위해 사용 -> 보통 사용 잘 안함
    @Bean(name = "music2") /// name속성을 추가하면 id값이 메서드명이 아니라 name속성으로 설정
    public Music abcd() {
        return new Music("Easy","k-pop");
    }

    @Bean(name = "singer2")
    public Singer qwe() {
        return new Singer("르세라핌", abcd());
    }

}
