package com.sotogito.ioc.section03.annotationconfig;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

//보통 DTO나 Entity에는 빈등록 안하긴함
@Component /// 어노테이션으로 빈을 등록 /// id === member
public class Member {

    private String name;
    private int age;

}
