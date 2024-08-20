package com.yupi.project.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusFormInfoVO {
    private String external;
    private String formJson;
    private String editForm;
}
