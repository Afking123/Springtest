package com.example.demo.BCryptPassword;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "bobspassword";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}