package com.podoseee.fileupload.util;

import com.podoseee.fileupload.dto.AttachmentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class FileUtil {

    public void fileupload(MultipartFile uploadFile){
        // 1) 저장경로 (/upload/board/yyyyMMdd)
        String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
        File filePathDir = new File("C:" + filePath);
        if (!filePathDir.exists()) {      // 해당 경로의 폴더가 존재하지 않을 경우
            filePathDir.mkdirs();        // 해당 폴더 만들기
        }

        // 2) 파일명 수정 작업
        String originalFilename = uploadFile.getOriginalFilename(); // "abc.def.jpg"

        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")); // ".jpg"
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext; // 확장자 포함

        // 3) 업로드 (지정한 폴더에 파일을 저장)
        try {
            uploadFile.transferTo(new File(filePathDir, filesystemName)); //중복되지않은파일 이름으로 저장하겠다.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
