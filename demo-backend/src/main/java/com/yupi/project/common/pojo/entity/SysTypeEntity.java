package com.yupi.project.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;
@Data
public class SysTypeEntity{
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String typeKey;
    private Long parentId = -1L;
    private String updateTime;
    private String createTime;
    private Boolean leaf;
    private String status = "1";
    private String scopeId = "BPMN";
    private List<SysTypeEntity> children;
    private Boolean expand;
    private Boolean contextmenu;
    private Integer orderId;
    private String tenantId;
}
