package com.management.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 *
 * CustomerVo
 *
 * @author 严虹钱
 * @since  2022/3/30
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVo {
    private Integer id;

    // 客户名称
    private String name;

    // 公司类型
    private String type;

    // 电话号码
    private String telephoneNumber;

    // 公司地址
    private String address;

    // 负责人
    private String superintendent;

    // 备注
    private String remark;

    // 创建人
    private String createBy;

    // 创建时间
    private Date createTime;
}
