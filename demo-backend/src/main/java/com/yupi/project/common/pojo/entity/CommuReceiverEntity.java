package com.yupi.project.common.pojo.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class CommuReceiverEntity {
    private String id;
    private String commuId;
    private String commu;
    private String batchId;
    private String title;
    private String receiverId;
    private String receiver;
    private Boolean isRead;
    private String opinion;
    private String status;
    private String bizStatus;
    private Date receiveTime;
    private Date readTime;
    private Date commuTime;
    private String procDefId;
    private String procId;
    private String taskId;
    private String typeKey;
    private String typeTitle;
    protected String bizKey;
    //OA 版本的通知
    protected String notice;
    protected String photo="https://i.gtimg.cn/club/item/face/img/2/15922_100.gif";
    //private A1FlowInstanceEntity flowInstanceEntity;

    // 重写
    public String getBizStatus() {
        if (StringUtils.isNotBlank(bizStatus)){
            switch (bizStatus){
                case "running":
                    bizStatus="运行";
                    break;
                case "completed":
                    bizStatus="完成";
                    break;
                case "invalid":
                    bizStatus="作废";
                    break;
                default:
                    break;
            }
        }else{
            bizStatus="未知流程";
        }

        return bizStatus;
    }

    public void setBizStatus(String bizStatus) {
        this.bizStatus = bizStatus;
    }
}
