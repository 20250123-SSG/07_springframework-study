package com.podoseee.webmvc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDto {
    private int no;
    private String title;
    private String content;
}
