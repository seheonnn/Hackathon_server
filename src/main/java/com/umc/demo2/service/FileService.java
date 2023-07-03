package com.umc.demo2.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static String fileUpload(List<MultipartFile> files) throws IOException {
        String filepath = "/Users/hoseheon/Desktop/Hackathon_server/src/main/images";
//        String filepath = "/home/ubuntu/GreenQuest-BE/src/main/images/";
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            File dest = new File(filepath + originalfileName);
            file.transferTo(dest);
            list.add(dest.getPath());
        }
        return String.join(",", list);
    }
}
