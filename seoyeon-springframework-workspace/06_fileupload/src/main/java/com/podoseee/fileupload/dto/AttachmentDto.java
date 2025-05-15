package com.podoseee.fileupload.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AttachmentDto {
    private int fileID;
    private String filePath;
    private String filesystemName;
    private String originalName;
    private int refBoardNo;
}
