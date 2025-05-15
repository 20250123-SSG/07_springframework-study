package com.inyong.ioc.section02.javaconfig;

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
        /*
            * setter 주입
            <bean id="music1" class="Music">
              <property name="title" value="Love wins all" />
              <property name="genre" value="발라드" />
            </bean>
         */
    }

    @Bean
    public Singer singer1(){
        Singer s = new Singer();
        s.setName("아이유");
        s.setMusic(music1());
        return s;
        /*
            * setter 주입
            <bean id="singer1" class="Singer">
              <property name="name" value="아이유"/>
              <property name="music" ref="music1" />
            </bean>
         */
    }

    @Bean(name="music2") // name속성 작성시 빈의 id가 메소드명이 아닌 name속성값으로 지정
    public Music abcd(){
        return new Music("EASY", "K-POP");
        /*
            * 생성자 주입
            <bean id="music2" class="Music">
              <constructor-arg value="EASY" />
              <constructor-arg value="K-POP" />
            </bean>
         */
    }

    @Bean(name="singer2")
    public Singer defg(){
        return new Singer("르세라핌", abcd());
        /*
            * 생성자 주입
            <bean id="singer2" class="Singer">
              <constructor-arg value="르세라핌"/>
              <constructor-arg ref="music2" />
            </bean>
         */
    }




}
