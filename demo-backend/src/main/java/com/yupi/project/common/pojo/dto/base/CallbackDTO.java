package com.yupi.project.common.pojo.dto.base;
import com.yupi.project.common.pojo.enums.CallbackType;
import lombok.Data;

@Data
public class CallbackDTO {
    private CallbackType type;
    private String url;
}
