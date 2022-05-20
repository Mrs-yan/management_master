package com.management.client.service.impl;

import com.management.client.dao.EquipmentDao;
import com.management.client.dao.TaskDao;
import com.management.client.service.TaskService;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import com.management.client.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;

    @Autowired
    EquipmentDao equipmentDao;

    @Override
    public void insert(TaskVo task) {
        this.chekEmpty(task);
        if (task.getEquipmentId() != null){
            EquipmentVo equipment = equipmentDao.getEquipmentById(task.getEquipmentId());
            if (equipment.getUseStatus() == 1){
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
        if (task.getEquipmentId() != null){
            equipmentDao.updateUseStatus(0, task.getEquipmentId());
        }
        taskDao.delete(id);
    }

    @Override
    public void update(TaskVo task) {
        this.chekEmpty(task);
        TaskVo old = taskDao.getTaskById(task.getId());
        if (task.getEquipmentId() != old.getEquipmentId()){
            EquipmentVo equipment = equipmentDao.getEquipmentById(task.getEquipmentId());
            if (equipment.getUseStatus() == 1){
                throw new IllegalArgumentException("该设备以及在使用！请选择其他设备");
            }
        }
        List<TaskVo> taskVos = taskDao.getTaskList(new TaskVo());
        if (taskVos.stream().anyMatch(VO -> VO.getName().equals(task.getName())) && !old.getName().equals(task.getName())) {
            throw new IllegalArgumentException("该任务名已经存在!");
        }
        if (task.getStatus() == 1) {
            task.setActualStartTime(new Date());
        } else if (task.getStatus() == 3) {
            task.setEndTime(new Date());
        }
        taskDao.update(task);
        if (task.getStatus() == 3){
            EquipmentVo equipment = equipmentDao.getEquipmentById(task.getEquipmentId());
            equipmentDao.updateUseStatus(0,equipment.getId());
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

    void chekEmpty(TaskVo task){
        if (task.getName() == null){
            throw new IllegalArgumentException("任务名称不能为空！");
        }
        if (task.getEquipmentId() == null){
            throw new IllegalArgumentException("请选择设备！");
        }
        if (task.getCustomerId() == null){
            throw new IllegalArgumentException("请选择客户！");
        }
        if (task.getStatus() == null){
            throw new IllegalArgumentException("任务状态不能为空！");
        }
    }
}