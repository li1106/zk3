package com.liqingrui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/file")
@CrossOrigin
@RestController
public class UploadController {
//    @Value("${file.domain}")
    private String fileDomain="http://127.0.0.1:8083/";
//    @Value("${file.path}")
    private String filePath="F:\\local\\image";

    @PostMapping("/upload")
    public Object upload(@RequestParam(name = "file")MultipartFile file){
        System.out.println(file.getOriginalFilename()+":是文件名称");
        Map<String,Object> map = new HashMap<>();
        map.put("result",true);
//        文件名
        String fileName = UUID.randomUUID()+".jpg";
//        文件保存地址
        File destPath = new File(filePath + fileName);
//        文件上传
        try {
            file.transferTo(destPath);
            map.put("result",true);
            map.put("fileName",fileName);
            map.put("imgUrl",fileDomain+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return map;
        }
        return map;
    }
}
