package com.sotogito.fileupload.util;

import com.sotogito.fileupload.dto.AttachmentDto;
import lombok.experimental.UtilityClass;
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

    public Map<String, String> fileUpload(MultipartFile uploadFile){
        String filePath = "/upload/board/"+ DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
        File filePathDir = new File("C:"+filePath);

        if(!filePathDir.exists()) { // 저장할 경로에 폴더가 없다면
            filePathDir.mkdirs();   //폴더를 생성
        }
        /// 파일명 수정
        String originalFileName = uploadFile.getOriginalFilename(); //abc.def.jpg
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); //.jpg
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;// uuid를 사용하여 절대 겹치지않은 파일명으로 설정

        /// 업로드(지정한 폴더에 파일을 저장)
        try {
            uploadFile.transferTo(new File(filePathDir, filesystemName)); //중복되지않은파일 이름으로 저장하겠다.
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Map.of(
                "filePath", filePath,
                "originalName", originalFileName,
                "filesystemName", filesystemName
        );
    }

}
