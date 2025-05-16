package com.ibe6.webmvc.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class NoticeDto {
    private int no;
    private String title;
    private String content;
}
