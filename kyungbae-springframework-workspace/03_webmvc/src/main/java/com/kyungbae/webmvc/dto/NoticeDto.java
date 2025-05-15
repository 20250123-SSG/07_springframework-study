package com.kyungbae.webmvc.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class NoticeDto {

    private int no;
    private String title;
    private String content;

}
