package com.maple.resourceserver.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static File getFile(String resID){
        String path="";
        return new File(path);
    }

    public static InputStream getFileByPath(String path) throws IOException {
        if("image404".equals(path)){
            System.out.println("11");
            ClassPathResource classPathResource = new ClassPathResource("static/img/image404.jpg");
            return classPathResource.getInputStream();
        }
        return new FileInputStream(path);
    }
}
