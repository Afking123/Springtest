package com.example.demo.FileUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Component
public class FileUploadDao {
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private Files files;
    private String message;
    private static String UPLOAD_DIR = "uploads/";

    public String fileupload() {
        if (files.getFiles().isEmpty()) {
            message = "請選擇一個文件來上傳";
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!java.nio.file.Files.exists(uploadPath)) {
                java.nio.file.Files.createDirectories(uploadPath);
            }

            Path path = uploadPath.resolve(files.getFiles().getOriginalFilename());
            java.nio.file.Files.copy(files.getFiles().getInputStream(), path);

            message = ("message" + "成功上傳 " + files.getFiles().getOriginalFilename() + "!");
        } catch (IOException e) {
            e.printStackTrace();
            message = ("message" + "文件上傳失敗: " + files.getFiles().getOriginalFilename() + "!");
        }
        return message;
    }
}
