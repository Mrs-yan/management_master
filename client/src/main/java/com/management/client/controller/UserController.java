package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.dao.UserDao;
import com.management.client.service.UserService;
import com.management.client.vo.common.Result;
import com.management.client.vo.common.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
@Controller
@ResponseBody
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @GetMapping("/test")
    public Result test() {
        Map map = new HashMap();
        map.put("2022-01-02","请假");
        map.put("2022-01-03","上班");
        map.put("2022-01-04","请假");
        map.put("2022-01-05","上班");
        map.put("2022-01-06","请假");
        map.put("2022-01-07","上班");
        return new Result().success(map);
        //return userDao.test();
    }


    /**
     * login
     * 登录接口
     *
     * @param user user
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        try {
            User result = userService.login(user);
            return new Result<>().success(result);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 增加新用户
     *
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) {
        try {
            userService.insert(user);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 删除用户
     * deleteUser
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteUser/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新个人信息（id不能为空）
     * updateUser
     *
     * @param user user
     * @return
     */
    @RequestMapping(path = "/updateUser/{id}", method = RequestMethod.PATCH)
    public Result updateUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            user.setId(id);
            userService.update(user);
            User newUser = userService.getUserById(id);
            return new Result<>().success(newUser);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 获取所有用户
     * getAllUser
     *
     * @return
     */
    @GetMapping("/getAllUser/{pageNum}/{pageSize}")
    public Result<PageInfo<User>> getAllUser(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> users = userService.getAllUser();
            return new Result<>().success(new PageInfo<>(users));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新图片接口
     * updateImg
     *
     * @return
     */
    @GetMapping("/updateImg/{id}/{img}")
    public Result updateImg(@PathVariable Integer id, @PathVariable String img) {
        try {
            userService.updateImg(img, id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 查看个人信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public Result getUserById(@PathVariable Integer id) {
        try {
            User user = userService.getUserById(id);
            return new Result<>().success(user);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("get fail" + e.getMessage());
        }
    }
}
