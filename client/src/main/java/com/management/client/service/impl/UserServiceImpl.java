package com.management.client.service.impl;

import com.management.client.dao.UserDao;
import com.management.client.service.UserService;
import com.management.client.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User login(User user) {
        User result = userDao.login(user);
        if (result == null) {
            throw new IllegalArgumentException("账号或密码错误！");
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void insert(User user) {
        check(user);
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
        User OldUser = userDao.getUserById(user.getId());
        List<User> users = userDao.getAllUser(new User());
        if (users.stream().anyMatch(User -> User.getAccount().equals(user.getAccount())) && !user.getAccount().equals(OldUser.getAccount())) {
            throw new IllegalArgumentException("该账号已经存在请重新输入");
        }
        userDao.update(user);
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
