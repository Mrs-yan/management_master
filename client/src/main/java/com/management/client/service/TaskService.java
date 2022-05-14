package com.management.client.service;

import com.management.client.vo.TaskVo;

import java.util.List;

public interface TaskService {

    /**
     * 新增任务
     * insert
     *
     * @param task task
     */
    void insert(TaskVo task);

    /**
     * 删除任务(伪删除)
     * delete
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * 更新任务信息
     * update
     *
     * @param task task
     */
    void update(TaskVo task);


    /**
     * getTaskById
     * 获取单个任务信息
     *
     * @param id id
     * @return
     */
    TaskVo getTaskById(Integer id);

    /**
     * getTaskList
     * 获取所有任务
     *
     * @return TaskVo
     */
    List<TaskVo> getTaskList(TaskVo task);
}
