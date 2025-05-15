package com.inyong.ioc.section03.annotationconfig;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Component // bean id == member
public class Member {
    private String name;
    private int age;
}
