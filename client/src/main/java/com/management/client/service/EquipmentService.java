package com.management.client.service;

import com.management.client.vo.EquipmentVo;

import java.util.List;

/**
 *
 * EquipmentService
 *
 * @author 严虹钱
 * @since  2022/3/27
 *
 */

public interface EquipmentService {
    /**
     * 添加新用户
     *
     * @param equipment
     */
    void insert(EquipmentVo equipment);

    /**
     * delete
     * 删除设备，伪删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新
     * update
     *
     * @param equipment
     */
    void update(EquipmentVo equipment);

    /**
     * 查看设备
     *
     * @param id id
     * @return EquipmentVo
     */
    EquipmentVo getEquipmentById(Integer id);

    /**
     * 获取所有设备
     * getAll
     *
     * @return
     */
    List<EquipmentVo> getAll();

    /**
     * 单独更新图片
     *
     * @param img img
     * @param id  id
     */
    void updateImg(String img, Integer id);
}
