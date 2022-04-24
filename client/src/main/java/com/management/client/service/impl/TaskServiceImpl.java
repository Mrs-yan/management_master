package com.management.client.service.impl;

import com.management.client.dao.TaskDao;
import com.management.client.service.TaskService;
import com.management.client.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;

    @Override
    public void insert(TaskVo task) {
        List<TaskVo> taskVos = taskDao.getTaskList();
        if (taskVos.stream().anyMatch(VO -> VO.getName().equals(task.getName()))) {
            throw new IllegalArgumentException("该任务名已经存在!");
        }
        task.setCreateTime(new Date());
        taskDao.insert(task);
    }

    @Override
    public void delete(Integer id) {
        taskDao.delete(id);
    }

    @Override
    public void update(TaskVo task) {
        TaskVo old = taskDao.getTaskById(task.getId());
        List<TaskVo> taskVos = taskDao.getTaskList();
        if (taskVos.stream().anyMatch(VO -> VO.getName().equals(task.getName())) && !old.getName().equals(task.getName())) {
            throw new IllegalArgumentException("该任务名已经存在!");
        }
        if (task.getStatus() == 1) {
            task.setActualStartTime(new Date());
        } else if (task.getStatus() == 3) {
            task.setEndTime(new Date());
        }
        taskDao.update(task);
    }

    @Override
    public TaskVo getTaskById(Integer id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public List<TaskVo> getTaskList() {
        return taskDao.getTaskList();
    }
}
