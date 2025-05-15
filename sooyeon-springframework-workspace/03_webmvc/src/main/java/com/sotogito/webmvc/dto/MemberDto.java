package com.sotogito.webmvc.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {

    private String name;
    private int age;
    private String address;

}
