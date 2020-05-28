package com.maple.resourceserver.service;

import com.maple.resourceserver.entity.ResourceSetting;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
public interface IResourceSettingService extends IService<ResourceSetting> {

    //获取资源路径
    public String getUpload();

    //校验资源路径状态
    public boolean getUploadState();

    //资源实际路径
    public String realPath(String resPath);
}
