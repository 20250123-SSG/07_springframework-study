package com.ino.ioc.section01.xmlconfing;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Student {
    private String name;
    private int age;
    private Calculator calc;
}
