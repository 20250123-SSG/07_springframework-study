package com.jjanggu.ioc.section01.xmlconfig;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String name;
    private String academy;
    private int ClassNo;
    private Calculator calc;
}
