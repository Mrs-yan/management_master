package com.management.client.vo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * 用于分页存储参数
 */
public class PageVo {
    // 第几页
    private Integer pageNum;

    // 每页的数量
    private Integer pageSize;
}
