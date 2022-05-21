package com.management.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * FinancialDataVo
 *
 * @author 严虹钱
 * @since 2022/3/25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialDataVo {
    // 开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    // 结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    // 累计收入
    private Double totalRevenue;

    // 累计支出
    private Double totalSpend;

    // 累计利润
    private Double totalProfits;

    // 因公支出
    private Double businessSpend;

    // 任务支出
    private Double taskSpend;

    // 审批未通过
    private Double approvalFail;

    // 类型-收入/支出
    private String type;
}
