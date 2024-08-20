package com.yupi.project.common.pojo.dto;


import com.yupi.project.common.pojo.vo.A1DeModelDetailVO;
import com.yupi.project.common.pojo.vo.FormDetailVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProcessDetailDTO {
    private A1DeModelDetailVO a1DeModelDetailVO;
    private FormDetailVO formDetailVO;
}
