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
// 打卡Vo
public class ClockInVo {
    // id
    private Integer id;

    // 用户id
    private Integer userId;

    // 任务id
    private Integer taskId;

    // 任务名称
    private String taskName;

    // 打卡状态 正常/请假/调休
    private String status;

    // 备注
    private String remark;


    // 打卡时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date clockTime;

}
