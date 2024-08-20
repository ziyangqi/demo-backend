package com.yupi.project.common.pojo.vo;


import lombok.Data;

import java.util.Map;

@Data
public class CommReceiverEntityVO {

    // 目前只接收data格式 后续再做修改
    private Map<String,Object> data ;

}
