package com.maple.resourceserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    //资源路径
    private String uploadPath;
    //是否解密:0不解密、1解密
    private Integer isDecrypt;

    @TableId(value = "setting_id")
    private Integer settingId=1;


}
