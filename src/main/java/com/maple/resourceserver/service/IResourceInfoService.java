package com.maple.resourceserver.service;

import com.maple.resourceserver.entity.ResourceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-08-22
 */
public interface IResourceInfoService extends IService<ResourceInfo> {

    //获取资源upload
    String getResUpload(String resourceId);
}
