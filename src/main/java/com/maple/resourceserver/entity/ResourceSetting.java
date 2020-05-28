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

    private String uploadPath;
    @TableId(value = "setting_id")
    private Integer settingId;


}
