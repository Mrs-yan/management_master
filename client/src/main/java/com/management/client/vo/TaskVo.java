package com.management.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 任务Vo
public class TaskVo {
    // id
    private Integer id;

    // 任务名称
    private String name;

    // 客户id
    private Integer customerId;

    // 客户名称
    private String customerName;

    // 设备id
    private Integer equipmentId;

    // 设备名称
    private String equipmentName;

    // 工作地址
    private String address;

    // 类型
    private String type;

    //工作状态 3已完成/1进行中/2未开始
    private Integer status;

    // 备注
    private String remark;

    // 预定开始时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date scheduledStartTime;

    // 实际开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actualStartTime;

    // 结束时间
    private Date endTime;

    // 创建时间
    private Date createTime;

    // 创建人
    private String createBy;

    // 删除状态
    private Integer deleteIs;
}
