package com.management.client.service.impl;

import com.management.client.dao.EquipmentDao;
import com.management.client.service.EquipmentService;
import com.management.client.vo.EquipmentVo;
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
        EquipmentVo old = equipmentDao.getEquipmentById(equipment.getId());
        List<EquipmentVo> equipments = equipmentDao.getAll();
        if (equipments.stream().anyMatch(VO -> VO.getName().equals(equipment.getName())) && !old.getName().equals(equipment.getName())) {
            throw new IllegalArgumentException("该设备名称已经存在，请重新输入！");
        }
        equipmentDao.update(equipment);


    }

    @Override
    public EquipmentVo getEquipmentById(Integer id) {
        return equipmentDao.getEquipmentById(id);
    }

    @Override
    public List<EquipmentVo> getAll() {
        return equipmentDao.getAll();
    }
}
