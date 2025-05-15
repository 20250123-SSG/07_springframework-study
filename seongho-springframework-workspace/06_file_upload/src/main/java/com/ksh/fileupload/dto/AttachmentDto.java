package com.ksh.fileupload.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AttachmentDto {
    private int fileNum;
    private String filePath;
    private String filesystemName;
    private String originalName;
    private int refBoardNum;

}
