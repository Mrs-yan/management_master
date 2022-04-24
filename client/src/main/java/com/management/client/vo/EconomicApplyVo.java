package com.management.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 申请vo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EconomicApplyVo {
    private Integer id;

    // 花费类型----任务支出/设备维修/工资预支/其他
    private String spendType;

    // 金额
    private Integer money;

    // 任务id
    private Integer taskId;

    // 任务名称
    private String taskName;

    // 备注
    private String remark;

    // 申请人id
    private Integer proposerId;

    // 申请人
    private String proposerName;

    // 审批人id
    private Integer approverId;

    // 审批人
    private String approverName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 操作状态 0审批中/1已通过/2拒绝
    private Integer status;

}
