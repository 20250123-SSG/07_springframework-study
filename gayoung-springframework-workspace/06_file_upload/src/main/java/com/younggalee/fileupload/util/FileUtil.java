package com.younggalee.fileupload.util;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

@Component
public class FileUtil {

    public Map<String, String> fileupload(MultipartFile uploadFile){
        // 1) 저장경로 (/upload/board/yyyyMMdd)
        String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
        File filePathDir = new File("C:" + filePath);
        if(!filePathDir.exists()){   // 해당 경로의 폴더가 존재하지 않을 경우
            filePathDir.mkdirs();    // 해당 폴더 만들기
        }

        // 2) 파일명 수정 작업
        String originalFilename = uploadFile.getOriginalFilename(); // "abc.def.jpg"
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")); // ".jpg"
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext; // UUID.randomUUID() : 랜덤값발생 (32자리 + - 4개)

        // 3) 업로드 (지정한 폴더에 파일을 저장)
        try {
            uploadFile.transferTo(new File(filePathDir, filesystemName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> map = Map.of(
                "filePath", filePath,
                "originalFilename", originalFilename,
                "filesystemName", filesystemName
        );

        return map;
    }

}