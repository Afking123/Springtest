package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class FileUploadService {
    @Autowired
    private Files files;
    public void in(MultipartFile file , RedirectAttributes redirectAttributes) {
        files.setFiles(file);
        files.setRedirectAttributes(redirectAttributes);
    }

}
