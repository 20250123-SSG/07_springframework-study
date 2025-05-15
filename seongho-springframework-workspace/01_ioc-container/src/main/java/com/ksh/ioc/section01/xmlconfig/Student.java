package com.ksh.ioc.section01.xmlconfig;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private String aca;
    private int classNo;
    private Calculator calc;
}
