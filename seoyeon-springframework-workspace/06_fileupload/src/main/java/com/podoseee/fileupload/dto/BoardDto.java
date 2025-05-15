package com.podoseee.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int boardID;
    private String boardName;
    private String boardText;
}
