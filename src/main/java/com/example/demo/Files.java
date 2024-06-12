package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Component
public class Files {
    private MultipartFile files;
    private RedirectAttributes redirectAttributes;

    public MultipartFile getFiles() {
        return files;
    }
    public void setFiles(MultipartFile files) {
        this.files = files;
    }
    public RedirectAttributes getRedirectAttributes() {
        return redirectAttributes;
    }
    public void setRedirectAttributes(RedirectAttributes redirectAttributes) {
        this.redirectAttributes = redirectAttributes;
    }
    public String redirectAttributestoString(){
        return redirectAttributes.toString();
    }
}
