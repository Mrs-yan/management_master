package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.EmployeeService;
import com.management.client.vo.ClockInVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * EmployeeController
 *
 * @author 严虹钱
 * @since 2022/4/15
 */


@Slf4j
@Controller
@ResponseBody
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    /**
     * clockIn
     * 打卡
     *
     * @param clock clock
     * @return
     */
    @PostMapping("/clockIn")
    public Result clockIn(@RequestBody ClockInVo clock) {
        try {
            employeeService.clockIn(clock);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * clockStatus
     * 打卡状态
     *
     * @param userId userId
     * @return Boolean
     */
    @GetMapping("/clockStatus/{userId}")
    public Result clockStatus(@PathVariable Integer userId) {
        try {
            ClockInVo clock = new ClockInVo();
            clock.setUserId(userId);
            Boolean temp = employeeService.clockStatus(clock);
            return new Result<>().success(temp);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getClockDetail
     * 查看打卡详细
     *
     * @param userId     userId
     * @param createTime createTime
     * @return ClockInVo
     */
    @GetMapping("/getClockDetail/{userId}/{createTime}")
    public Result getClockDetail(@PathVariable Integer userId, @PathVariable Date createTime) {
        try {
            ClockInVo clock = ClockInVo.builder()
                    .userId(userId)
                    .createTime(createTime)
                    .build();
            System.out.println(createTime);
            ClockInVo result = employeeService.getClockDetail(clock);
            result.setClockTime(result.getCreateTime());
            return new Result<>().success(result);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getAllClock
     * 获取全部打卡记录
     *
     * @param userId userId
     * @return Map
     */
    @GetMapping("/getAllClock/{userId}")
    public Result getAllClock(@PathVariable Integer userId) {
        try {
            Map map = employeeService.getAllClock(userId);
            return new Result<>().success(map);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getWorkList
     * 获取工作打卡记录
     *
     * @param userId userId
     * @return ClockInVo
     */
    @GetMapping("/getWorkList/{userId}/{pageNum}/{pageSize}")
    public Result<PageInfo<ClockInVo>> getWorkList(@PathVariable Integer userId, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ClockInVo> list = employeeService.getWorkList(userId);
            return new Result<>().success(new PageInfo<>(list));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }


    // 解析前台字符时间
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
