package com.management.client.dao;

import com.management.client.vo.common.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    // 测试接口
    String test();

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
    void updateImg(@Param("img") String img, @Param("id") Integer id);

    /**
     * 查询个人信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
