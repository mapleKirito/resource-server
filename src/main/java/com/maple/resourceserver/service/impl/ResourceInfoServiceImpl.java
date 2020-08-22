package com.maple.resourceserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.resourceserver.entity.ResourceInfo;
import com.maple.resourceserver.mapper.ResourceInfoMapper;
import com.maple.resourceserver.service.IResourceInfoService;
import com.maple.resourceserver.service.IResourceSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-08-22
 */
@Service
public class ResourceInfoServiceImpl extends ServiceImpl<ResourceInfoMapper, ResourceInfo> implements IResourceInfoService {

    private final static Logger LOGGER= LoggerFactory.getLogger(ResourceInfoServiceImpl.class);


    @Autowired
    private ResourceInfoMapper resourceInfoMapper;
    @Autowired
    private IResourceSettingService resourceSettingService;

    @Override
    public String getResUpload(String resourceId) {
        String resUpload = resourceInfoMapper.getResUpload(resourceId);
        String result="image404";
        //resPath去掉upload前缀
        if(resUpload.contains("upload")){
            resUpload=resUpload.substring(6);
        }else{
            LOGGER.info("资源路径异常，不包含'upload'");
            return result;
        }

        if(resourceSettingService.getUploadState()){
            result=resourceSettingService.getUpload()+resUpload;
        }
        return result;
    }
}
