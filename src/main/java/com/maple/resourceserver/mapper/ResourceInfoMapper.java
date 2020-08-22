package com.maple.resourceserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maple.resourceserver.entity.ResourceInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-08-22
 */
@Component
public interface ResourceInfoMapper extends BaseMapper<ResourceInfo> {
    @Select("select resource_upload from resource_info where resource_id=#{resourceId}")
    String getResUpload(String resourceId);
}
