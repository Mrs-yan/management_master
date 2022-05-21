package com.management.client.service;

import com.management.client.vo.ClockInVo;

import java.util.List;
import java.util.Map;

/**
 *
 * EmployeeService
 *
 * @author 严虹钱
 * @since  2022/4/15
 *
 */

public interface EmployeeService {
    /**
     * 打卡
     * clockIn
     *
     * @param clockIn clockIn
     */
    void clockIn(ClockInVo clockIn);

    /**
     * clockStatus
     * 判断打卡状态
     *
     * @param clock clock
     * @return Boolean
     */
    Boolean clockStatus(ClockInVo clock);

    /**
     * getClockDetail
     * 获取打卡详细
     *
     * @param clock clock
     * @return ClockInVo
     */
    ClockInVo getClockDetail(ClockInVo clock);

    /**
     * getAllClock
     * 获取全部打卡数据
     *
     * @param userId userId
     * @return ClockInVo
     */
    Map getAllClock(Integer userId);

    /**
     * 获取出工列表
     * getWorkList
     *
     * @param userId userId
     * @return ClockInVo
     */
    List<ClockInVo> getWorkList(Integer userId);
}
