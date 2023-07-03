package com.umc.demo2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class PictureController {

    @PostMapping("/upload")
    public List<String> upload(@RequestPart List<MultipartFile> files) throws Exception {
        String filepath = "ubuntu@43.202.79.30:~/GreenQuest-BE/src/main/images/";
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalfileName = file.getOriginalFilename();
            File dest = new File(filepath + originalfileName);
            file.transferTo(dest);
        }
        return list;
    }
}

