package com.younggalee.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int boardNo;
    private String boardTitle;
    private String boardContent;
}
