package com.maple.resourceserver.controller;

import com.maple.resourceserver.service.IResourceSettingService;
import com.maple.resourceserver.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class ImageController {

    @Autowired
    private IResourceSettingService resourceSettingService;

    @GetMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] image(@RequestParam(name = "path")String path) throws Exception {

        InputStream inputStream = FileUtils.getFileByPath(resourceSettingService.realPath(path));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }

    @GetMapping(value = "/test",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] test() throws Exception {

        File file = new File("E:\\ce\\1.jpg");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }
}
