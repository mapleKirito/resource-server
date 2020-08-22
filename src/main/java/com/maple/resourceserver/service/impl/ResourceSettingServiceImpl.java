package com.maple.resourceserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maple.resourceserver.controller.ResourceSettingController;
import com.maple.resourceserver.entity.ResourceSetting;
import com.maple.resourceserver.mapper.ResourceSettingMapper;
import com.maple.resourceserver.service.IResourceSettingService;
import com.maple.resourceserver.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
@Service
public class ResourceSettingServiceImpl extends ServiceImpl<ResourceSettingMapper, ResourceSetting> implements IResourceSettingService {

    private final static Logger log= LoggerFactory.getLogger(ResourceSettingController.class);

    @Autowired
    private ResourceSettingMapper resourceSettingMapper;

    @Override
    public String getUpload() {
        String result=resourceSettingMapper.getUpload();
        if(StringUtils.isEmpty(result)){
            result="";
        }
        return result;
    }

    @Override
    public ResourceSetting getResourceSetting() {
        ResourceSetting resourceSetting = resourceSettingMapper.selectById(1);
        return resourceSetting;
    }

    @Override
    public boolean getUploadState() {
        boolean result=false;
        String path=resourceSettingMapper.getUpload();
        return FileUtils.existPath(path);
    }

    @Override
    public String realPath(String resPath) {
        String result="image404";
        //resPath去掉upload前缀
        if(resPath.contains("upload")){
            resPath=resPath.substring(6);
        }else{
            log.info("资源路径异常，不包含'upload'");
            return result;
        }

        if(getUploadState()){
            result=getUpload()+resPath;
        }
        return result;
    }
}
