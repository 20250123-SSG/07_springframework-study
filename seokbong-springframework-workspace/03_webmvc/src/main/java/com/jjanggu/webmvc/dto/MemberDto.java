package com.jjanggu.webmvc.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDto {
    private String name;
    private int age;
    private String addr;
}
