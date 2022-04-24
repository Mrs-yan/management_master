package com.management.client.vo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    // 姓名
    private String name;

    // 电话号码
    private String telephoneNumber;

    // 性别
    private String sex;

    // 工种
    private String workType;

    // 身份证号码
    private String idCardNumber;

    // 账号
    private String account;

    // 密码
    private String password;

    // 权限 1是管理员 2 是普通用户
    private Integer role;

    // 头像地址
    private String img;

    // 工号
    private String workNumber;

    // 入职时间
    private Date createTime;

    // 上传头像时需要
    private MultipartFile file;
}
