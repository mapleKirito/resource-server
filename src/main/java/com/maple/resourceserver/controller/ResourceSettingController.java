package com.maple.resourceserver.controller;


import com.maple.resourceserver.service.IResourceSettingService;
import com.maple.resourceserver.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
@RestController
@RequestMapping("/resource")
public class ResourceSettingController {
    private final static Logger log= LoggerFactory.getLogger(ResourceSettingController.class);


    @Autowired
    private IResourceSettingService resourceSettingService;

    @RequestMapping("/uploadStatus")
    public String getUploadStatus(){
        String result="";
        if(resourceSettingService.getUploadState()){
            result=resourceSettingService.getUpload();
        }
        return result;
    }

    @RequestMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImages(@RequestParam(name = "path")String path) throws IOException {

        return ImageIO.read(FileUtils.getFileByPath(resourceSettingService.realPath(path)));
    }


}
