package com.yupi.project.common.pojo.dto;


import lombok.Data;


@Data
public class CommuReveiverQueryDTO {
    private String name;
    private String title;
    private String status;
    private Integer page;
    private Integer limit;
    private Integer pageSize;
    private String whereSql;
    private String typeKey;
}
