package com.kyungbae.ioc.section01.xmlconfig;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {
    private String name;
    private String academy;
    private int classNo;
    private Calculator calc;
}
