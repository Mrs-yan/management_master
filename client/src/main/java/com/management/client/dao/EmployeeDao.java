package com.management.client.dao;

import com.management.client.vo.ClockInVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDao {
    /**
     * 打卡
     * clockIn
     *
     * @param clockIn clockIn
     */
    void clockIn(ClockInVo clockIn);

    /**
     * clockStatus
     * 查询单日打卡数据/判断打卡状态
     *
     * @param clock clock
     * @return ClockInVo
     */
    ClockInVo clockStatus(ClockInVo clock);

    /**
     * getAllClock
     * 获取全部打卡数据
     *
     * @param userId userId
     * @return ClockInVo
     */
    List<ClockInVo> getAllClock(Integer userId);

    /**
     * 获取出工列表
     * getWorkList
     *
     * @param userId userId
     * @return ClockInVo
     */
    List<ClockInVo> getWorkList(Integer userId);
}
