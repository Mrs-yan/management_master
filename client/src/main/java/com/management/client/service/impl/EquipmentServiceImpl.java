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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (isNumber(equipment.getPrice())){
            equipment.setCreateTime(new Date());
            chek(equipment);
            equipmentDao.insert(equipment);
        }else {
            throw new IllegalArgumentException("价格只能为数字类型！");
        }

    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
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
        if (isNumber(equipment.getPrice())){
            EquipmentVo old = equipmentDao.getEquipmentById(equipment.getId());
            List<EquipmentVo> equipments = equipmentDao.getAll();
            if (equipments.stream().anyMatch(VO -> VO.getName().equals(equipment.getName())) && !old.getName().equals(equipment.getName())) {
                throw new IllegalArgumentException("该设备名称已经存在，请重新输入！");
            }
            equipmentDao.update(equipment);
        }else {
            throw new IllegalArgumentException("价格只能为数字类型！");
        }

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
        if (equipment.getName() == null || equipment.getName().equals("")) {
            throw new IllegalArgumentException("设备名称不能为空！");
        }
        if (equipment.getType() == null || equipment.getType().equals("")) {
            throw new IllegalArgumentException("设备类型不能为空！");
        }
        if (equipment.getModel() == null || equipment.getModel().equals("")) {
            throw new IllegalArgumentException("设备型号不能为空！");
        }
    }
}
