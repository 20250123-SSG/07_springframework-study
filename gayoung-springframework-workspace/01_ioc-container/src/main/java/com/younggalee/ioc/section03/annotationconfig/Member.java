package com.younggalee.ioc.section03.annotationconfig;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Component // bean id == member (클래스명으로 됨)
public class Member {
    private String name;
    private int age;
}
