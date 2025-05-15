package com.johnth.fileupload.util;

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
    public Map<String, String> fileupload(MultipartFile uploadFile) {
        String filePath = "/upload/board" + DateTimeFormatter.ofPattern("/yyyyMMdd").format(LocalDate.now());

        File filePathDir = new File("C:" + filePath);

        if (!filePathDir.exists()) {
            filePathDir.mkdirs();
        }

        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filesystemName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            uploadFile.transferTo(new File(filePathDir, filesystemName));
        } catch (
                IOException e) {
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
