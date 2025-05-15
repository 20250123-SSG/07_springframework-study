package com.ino.ajax.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserDto {
    private String id;
    private String pwd;
    private String name;
    private int age;
}
