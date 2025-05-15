package com.johnth.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AttachmentDTO {
    private int fileNo;
    private String filePath;
    private String filesystemName;
    private String originalName;
    private int refBoardNo;
}
