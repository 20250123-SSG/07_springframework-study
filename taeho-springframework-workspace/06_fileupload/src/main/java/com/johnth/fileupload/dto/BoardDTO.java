package com.johnth.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDTO {
    private int boardNo;
    private String boardTitle;
    private String boardContent;
}
