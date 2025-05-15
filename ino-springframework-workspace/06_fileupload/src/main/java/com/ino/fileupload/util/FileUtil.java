package com.ino.fileupload.util;

import com.ino.fileupload.dto.AttachmentDto;
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

    public Map<String, String> fileupload(MultipartFile mpf){
        String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());
        File filePathDir = new File("C:" +filePath);
        if(!filePathDir.exists()) { // if not exists
            filePathDir.mkdirs(); // make directory
        }
        // 1-2) change file name
        String orgFileName = mpf.getOriginalFilename();
        String ext = orgFileName.substring(orgFileName.lastIndexOf("."));
        String randUUID = UUID.randomUUID().toString().replace("-", "");  // UUID.randomUUID() : generate rand Val(32, four hypen)


        // 1-3. upload
        try {
            mpf.transferTo(new File(filePathDir, randUUID));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = Map.of("filePath", filePath, "orgFileName", orgFileName, "randUUID", randUUID);
        return map;
    }
}
