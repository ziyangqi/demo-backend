package com.yupi.project.common.pojo.dto;


import com.yupi.project.common.pojo.vo.BusFormInfoVO;
import com.yupi.project.common.pojo.vo.NextNodeInfoVO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProcessCurrentDetailDTO {
    private BusFormInfoVO busFormInfo;
    private List<NextNodeInfoVO> nextNodeInfoVOs;
}
