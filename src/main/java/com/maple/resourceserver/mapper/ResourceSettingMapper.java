package com.maple.resourceserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maple.resourceserver.entity.ResourceSetting;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
@Component
public interface ResourceSettingMapper extends BaseMapper<ResourceSetting> {

    @Select("select 1 from resource_setting")
    int test();

    @Select("select upload_path from resource_setting where setting_id=1")
    String getUpload();

}
