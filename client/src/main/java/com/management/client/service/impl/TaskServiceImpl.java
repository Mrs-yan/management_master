package com.management.client.service.impl;

import com.management.client.dao.EquipmentDao;
import com.management.client.dao.TaskDao;
import com.management.client.service.TaskService;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * TaskServiceImpl
 *
 * @author 严虹钱
 * @since 2022/4/7
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;

    @Autowired
    EquipmentDao equipmentDao;

    @Override
    public void insert(TaskVo task) {
        this.chekEmpty(task);
        if (task.getEquipmentId() != null) {
            EquipmentVo equipment = equipmentDao.getEquipmentById(task.getEquipmentId());
            if (equipment.getStatus() == 1) {
                throw new IllegalArgumentException("该设备已经在使用！请选择其他设备");
            }
        }

        List<TaskVo> taskVos = taskDao.getTaskList(new TaskVo());
        if (taskVos.stream().anyMatch(VO -> VO.getName().equals(task.getName()))) {
            throw new IllegalArgumentException("该任务名已经存在!");
        }
        task.setCreateTime(new Date());
        taskDao.insert(task);
        equipmentDao.updateUseStatus(1, task.getEquipmentId());
    }

    @Override
    public void delete(Integer id) {
        TaskVo task = taskDao.getTaskById(id);
        if (task.getEquipmentId() != null) {
            equipmentDao.updateUseStatus(4, task.getEquipmentId());
        }
        taskDao.delete(id);
    }

    @Override
    public void update(TaskVo task) {
        this.chekEmpty(task);
        TaskVo old = taskDao.getTaskById(task.getId());
        List<TaskVo> taskVos = taskDao.getTaskList(new TaskVo());
        if (taskVos.stream().anyMatch(VO -> VO.getName().equals(task.getName())) && !old.getName().equals(task.getName())) {
            throw new IllegalArgumentException("该任务名已经存在!");
        }

        if (task.getEquipmentId() != old.getEquipmentId()) {
            EquipmentVo equipment = equipmentDao.getEquipmentById(task.getEquipmentId());
            if (equipment.getStatus() == 1) {
                throw new IllegalArgumentException("该设备以及在使用！请选择其他设备");
            } else {
                if (task.getStatus() == 1) {
                    task.setActualStartTime(new Date());
                } else if (task.getStatus() == 3) {
                    task.setEndTime(new Date());
                }
                taskDao.update(task);
                equipmentDao.updateUseStatus(4, old.getEquipmentId());
                if (task.getStatus() != 3) {
                    equipmentDao.updateUseStatus(1, task.getEquipmentId());
                }
            }
        } else {
            if (task.getStatus() == 1) {
                task.setActualStartTime(new Date());
            } else if (task.getStatus() == 3) {
                task.setEndTime(new Date());
            }
            taskDao.update(task);
            if (task.getStatus() == 3) {
                equipmentDao.updateUseStatus(4, task.getEquipmentId());
            }

        }
    }

    @Override
    public TaskVo getTaskById(Integer id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public List<TaskVo> getTaskList(TaskVo task) {
        return taskDao.getTaskList(task);
    }

    void chekEmpty(TaskVo task) {
        if (task.getName() == null || task.getName().equals("")) {
            throw new IllegalArgumentException("任务名称不能为空！");
        }
        if (task.getEquipmentId() == null || task.getEquipmentId().equals("")) {
            throw new IllegalArgumentException("请选择设备！");
        }
        if (task.getCustomerId() == null || task.getCustomerId().equals("")) {
            throw new IllegalArgumentException("请选择客户！");
        }
        if (task.getStatus() == null || task.getStatus().equals("")) {
            throw new IllegalArgumentException("任务状态不能为空！");
        }
    }
}
