package com.sotogito.ajax.dto;

import lombok.*;
import org.aspectj.lang.annotation.Aspect;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {

    private String id;
    private String pwd;
    private String name;
    private int age;

}
