package com.maple.resourceserver.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

public class FileUtils {

    private final static Logger LOGGER= LoggerFactory.getLogger(FileUtils.class);


    public static File getFile(String resID){
        String path="";
        return new File(path);
    }

    public static InputStream getFileByPath(String path) {
        InputStream inputErrorStream=null;
        InputStream inputStream=null;
        try {
            ClassPathResource classPathResource = new ClassPathResource("static/img/image404.jpg");
            inputErrorStream= classPathResource.getInputStream();
            if(!"image404".equals(path)){
                inputStream= new FileInputStream(path);
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            LOGGER.info("文件没有找到：{}",path);
            inputStream= inputErrorStream;
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            return inputStream;
        }
    }

    //路径是否存在
    public static boolean existPath(String path){
        File f=new File(path);
        if(f.exists()&&f.isDirectory()){
            return true;
        }
        return false;
    }
}
