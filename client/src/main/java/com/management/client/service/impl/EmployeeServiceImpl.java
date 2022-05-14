package com.management.client.service.impl;

import com.management.client.dao.EmployeeDao;
import com.management.client.service.EmployeeService;
import com.management.client.vo.ClockInVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<ClockInVo> getWorkList(Integer userId) {
        return employeeDao.getWorkList(userId);
    }

    @Override
    public void clockIn(ClockInVo clockIn) {
        clockIn.setCreateTime(new Date());
        employeeDao.clockIn(clockIn);
    }

    @Override
    public Boolean clockStatus(ClockInVo clock) {
        Boolean temp = false;
        clock.setCreateTime(new Date());
        if (employeeDao.clockStatus(clock) == null) {
            temp = true;
        }
        return temp;
    }

    @Override
    public ClockInVo getClockDetail(ClockInVo clock) {
        return employeeDao.clockStatus(clock);
    }

    @Override
    public Map getAllClock(Integer userId) {
        // 设置时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<ClockInVo> clockInList = employeeDao.getAllClock(userId);
        //    Map<Date, String> maps = clockInList.stream().collect(Collectors.toMap(ClockInVo::getCreateTime,ClockInVo::getStatus));
        Map<String, String> maps = new HashMap<>();
        clockInList.forEach(vo -> {
            maps.put(dateFormat.format(vo.getCreateTime()), vo.getStatus());
        });
        return maps;
    }
}
