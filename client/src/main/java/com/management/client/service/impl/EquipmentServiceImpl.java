package com.management.client.service.impl;

import com.management.client.dao.EquipmentDao;
import com.management.client.service.EquipmentService;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import com.management.client.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentDao equipmentDao;

    @Override
    public void delete(Integer id) {
        equipmentDao.delete(id);
    }

    @Override
    public void insert(EquipmentVo equipment) {
        this.chekEmpty(equipment);
        equipment.setCreateTime(new Date());
        chek(equipment);
        equipmentDao.insert(equipment);
    }

    private void chek(EquipmentVo equipment) {
        List<EquipmentVo> equipments = equipmentDao.getAll();
        if (equipments.stream().anyMatch(VO -> VO.getName().equals(equipment.getName()))) {
            throw new IllegalArgumentException("该设备名称已经存在，请重新输入！");
        }
    }

    @Override
    public void updateImg(String img, Integer id) {
        equipmentDao.updateImg(img, id);
    }

    @Override
    public void update(EquipmentVo equipment) {
        this.chekEmpty(equipment);
        EquipmentVo old = equipmentDao.getEquipmentById(equipment.getId());
        List<EquipmentVo> equipments = equipmentDao.getAll();
        if (equipments.stream().anyMatch(VO -> VO.getName().equals(equipment.getName())) && !old.getName().equals(equipment.getName())) {
            throw new IllegalArgumentException("该设备名称已经存在，请重新输入！");
        }
        equipmentDao.update(equipment);
    }

    @Override
    public EquipmentVo getEquipmentById(Integer id) {
        long hour = 1000 * 60 * 60;
        long timeVariance = 0;
        Double totalRevenue = equipmentDao.getTotalRevenue(id);
        String result = totalRevenue + "元";
        EquipmentVo equipment = equipmentDao.getEquipmentById(id);
        equipment.setTotalRevenue(result);
        List<TaskVo> list = equipmentDao.getEquipmentWithTask(id);
        if (list.size() > 0) {
            timeVariance = list.stream().filter(Vo -> Vo.getActualStartTime() != null && Vo.getEndTime() != null).mapToLong(Vo -> (Vo.getEndTime().getTime() - Vo.getActualStartTime().getTime()) / hour).sum();
        }
        equipment.setWorkTime(timeVariance + "小时");
        return equipment;
    }

    @Override
    public List<EquipmentVo> getAll() {
        return equipmentDao.getAll();
    }

    void chekEmpty(EquipmentVo equipment) {
        if (equipment.getName() == null) {
            throw new IllegalArgumentException("设备名称不能为空！");
        }
        if (equipment.getType() == null) {
            throw new IllegalArgumentException("设备类型不能为空！");
        }
        if (equipment.getModel() == null) {
            throw new IllegalArgumentException("设备型号不能为空！");
        }
    }
}
