package com.management.client.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class WeChatVO {
    private String appId;
    private String secret;
    private String userId;
    private String templateId;
    private String ak;
    private String districtId;
    private String remark;
}
