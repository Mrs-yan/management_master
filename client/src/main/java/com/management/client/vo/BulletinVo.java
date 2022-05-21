package com.management.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 *
 * BulletinVo
 *
 * @author 严虹钱
 * @since  2022/4/18
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BulletinVo {
    // id
    private Integer id;

    // 公告名称/标题
    private String name;

    // 公告类型
    private String type;

    // 所属任务id
    private Integer taskId;

    // 所属任务名称
    private String taskName;

    // 创建人
    private String createBy;

    // 公告内容
    private String content;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
