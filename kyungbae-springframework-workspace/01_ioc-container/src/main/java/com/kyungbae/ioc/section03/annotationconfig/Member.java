package com.kyungbae.ioc.section03.annotationconfig;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Component
public class Member {
    private String name;
    private int age;
}
