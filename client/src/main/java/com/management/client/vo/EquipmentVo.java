package com.management.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 设备VO
 */
public class EquipmentVo {

    // id
    private Integer id;

    // 设备名
    private String name;

    // 类型
    private String type;

    // 型号
    private String model;

    // 价格
    private String price;

    // 创建时间
    private Date createTime;

    // 责任人
    private String responsible;

    // 图片
    private String img;

    // 创建人
    private String createBy;

    // 累计收入
    private String totalRevenue;

    // 删除状态
    private String deleteIs;

    // 工作时间
    private String workTime;

    // 使用状态
    private Integer status;

}
