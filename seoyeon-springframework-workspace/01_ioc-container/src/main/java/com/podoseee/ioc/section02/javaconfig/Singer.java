package com.podoseee.ioc.section02.javaconfig;
import lombok.*;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Singer {
    private String name;
    private Music music;
}
