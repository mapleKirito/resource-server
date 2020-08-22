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
 * @since 2020-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源编号，唯一索引
     */
    @TableId(value = "resource_id")
    private String resourceId;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源相对路径
     */
    private String resourceUpload;

    /**
     * 资源类型
     * 1.图片 2.视频
     */
    private String resourceType;


}
