package com.maple.resourceserver;

import com.maple.resourceserver.mapper.ResourceSettingMapper;
import com.maple.resourceserver.service.IResourceSettingService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=ResourceServerApplication.class)
class ResourceServerApplicationTests {
    private final static Logger LOGGER= LoggerFactory.getLogger(ResourceServerApplicationTests.class);


    @Autowired
    private ResourceSettingMapper resourceSettingMapper;

    @Autowired
    private IResourceSettingService resourceSettingService;

    @Test
    void contextLoads() {
        System.out.println(resourceSettingMapper.getUpload());
    }

    @Test
    void test1(){
        LOGGER.info("资源路径状态:"+resourceSettingService.getUploadState());
        LOGGER.info("资源路径:"+resourceSettingService.getUpload());
    }

}
