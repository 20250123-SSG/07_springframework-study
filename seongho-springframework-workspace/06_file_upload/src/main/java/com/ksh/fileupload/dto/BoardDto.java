package com.ksh.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int boardNum;
    private String boardTitle;
    private String boardContent;
}
