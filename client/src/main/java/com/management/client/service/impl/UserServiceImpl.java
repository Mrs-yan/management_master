package com.management.client.service.impl;

import com.management.client.dao.UserDao;
import com.management.client.service.UserService;
import com.management.client.unit.MD5;
import com.management.client.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author 严虹钱
 * @since 2022/3/25
 */

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
        String passWord = MD5.encrypt2ToMD5(user.getPassword());
        user.setPassword(passWord);
        User result = userDao.login(user);
        if (result == null) {
            throw new IllegalArgumentException("账号或密码错误！");
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        if (id == 1) {
            throw new IllegalArgumentException("此为系统初始管理员无法删除！");
        }
        userDao.delete(id);
    }

    @Override
    public void insert(User user) {
        this.chekEmpty(user);
        check(user);
        String passWord = MD5.encrypt2ToMD5(user.getPassword());
        user.setPassword(passWord);
        user.setCreateTime(new Date());
        String workNumber = System.currentTimeMillis() + "";
        user.setWorkNumber(workNumber);
        userDao.insert(user);
    }

    private void check(User user) {
        User us = new User();
        List<User> users = userDao.getAllUser(us);
        if (users.stream().anyMatch(User -> User.getAccount().equals(user.getAccount()))) {
            throw new IllegalArgumentException("该账号已经存在请重新输入");
        }
    }

    @Override
    public void update(User user) {
        if (user.getId() == 1) {
            throw new IllegalArgumentException("此为系统初始管理员无法修改！");
        }
        User old = userDao.getUserById(user.getId());
        if (!old.getPassword().equals(user.getPassword())) {
            String passWord = MD5.encrypt2ToMD5(user.getPassword());
            user.setPassword(passWord);
        }
        this.chekEmpty(user);
        List<User> users = userDao.getAllUser(new User());
        if (users.stream().anyMatch(User -> User.getAccount().equals(user.getAccount())) && !user.getAccount().equals(old.getAccount())) {
            throw new IllegalArgumentException("该账号已经存在请重新输入");
        }
        userDao.update(user);
    }

    void chekEmpty(User user) {
        if (user.getRole() == null || user.getRole().equals("")) {
            throw new IllegalArgumentException("角色不能为空");
        }
        if (user.getAccount() == null || user.getAccount().equals("")) {
            throw new IllegalArgumentException("账号不能为空");
        }
        if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new IllegalArgumentException("密码不能为空");
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateImg(String img, Integer id) {
        userDao.updateImg(img, id);
    }

    @Override
    public List<User> getAllUser(User user) {
        return userDao.getAllUser(user);
    }
}
