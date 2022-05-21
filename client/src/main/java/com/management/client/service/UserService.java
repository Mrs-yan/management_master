package com.management.client.service;

import com.management.client.vo.common.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 *
 * @author 严虹钱
 * @since 2022/3/25
 */

public interface UserService {
    /**
     * 登录接口，返回User对象数据
     *
     * @param user user
     * @return User
     */
    User login(User user);

    /**
     * 添加新用户接口
     * insert
     *
     * @param user user
     */
    void insert(User user);

    /**
     * 删除用户
     * delete
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改用户信息
     * update
     *
     * @param user user
     */
    void update(User user);

    /**
     * 获取用户列表
     * getAllUser
     *
     * @return
     */
    List<User> getAllUser(User user);

    /**
     * 单独更新图片
     *
     * @param img img
     * @param id  id
     */
    void updateImg(String img, Integer id);

    /**
     * 查询个人信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
