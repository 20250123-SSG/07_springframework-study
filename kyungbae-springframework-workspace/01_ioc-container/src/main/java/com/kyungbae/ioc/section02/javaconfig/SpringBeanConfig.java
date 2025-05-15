package com.kyungbae.ioc.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBeanConfig {

    @Bean
    public Music music1() {
        Music m = new Music();
        m.setTitle("title song");
        m.setGenre("발라드");
        return m;
    }

    @Bean
    public Singer singer1() {
        Singer s = new Singer();
        s.setName("김가수");
        s.setMusic(music1());
        return s;
    }

    @Bean(name = "music2")
    public Music aaa() {
        return new Music("Dont look back in anger", "rock");
    }

    @Bean(name = "singer2")
    public Singer bbb() {
        return new Singer("oasis", aaa());
    }

}
