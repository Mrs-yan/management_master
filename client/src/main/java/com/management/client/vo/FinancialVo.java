package com.management.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * FinancialVo
 *
 * @author 严虹钱
 * @since 2022/4/26
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialVo {
    private Integer id;

    // 金额
    private String money;

    // 类型 收入/支出
    private String type;

    // 性质 任务（收入/支出）/其他
    private String describe;

    // 任务id
    private Integer taskId;

    // 任务名称
    private String taskName;

    // 备注
    private String remark;

    // 创建人
    private String createBy;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
