package com.maple.resourceserver.controller;

import com.maple.resourceserver.entity.ResourceInfo;
import com.maple.resourceserver.service.IResourceInfoService;
import com.maple.resourceserver.utils.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class ResourceController {
    private final static Logger LOGGER= LoggerFactory.getLogger(ResourceController.class);
    @Autowired
    private IResourceInfoService resourceInfoService;

    /**
     * 图片访问接口
     * @param resourceId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/image/{resourceId}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] image(@PathVariable String resourceId) throws Exception {
        LOGGER.info("resourceId:{}",resourceId);
        InputStream inputStream = FileUtils.getFileByPath(resourceInfoService.getResUpload(resourceId));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;

    }

    /**
     * 公共资源访问接口
     * @param resourceId
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/res/{resourceId}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public void res(@PathVariable String resourceId, HttpServletResponse response) throws Exception {
        LOGGER.info("resourceId:{}",resourceId);
        ResourceInfo resourceInfo = resourceInfoService.getById(resourceId);
        if(null==resourceInfo){
            throw new RuntimeException("找不到资源文件");
        }
        LOGGER.info("查询到的对象:{}",resourceInfo.toString());

        try {
            //判断类型
            //图片
            if("1".equals(resourceInfo.getResourceType())){
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            }else if("2".equals(resourceInfo.getResourceType())){
                response.setContentType("video/mp4");
            }else{
                response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            }

            InputStream iStream = FileUtils.getFileByPath(resourceInfoService.getResUpload(resourceId));
            IOUtils.copy(iStream, response.getOutputStream());
            response.flushBuffer();
        } catch (java.nio.file.NoSuchFileException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

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
