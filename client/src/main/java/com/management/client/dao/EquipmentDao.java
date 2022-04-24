package com.management.client.dao;

import com.management.client.vo.EquipmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipmentDao {
    /**
     * 添加新设备
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
     * @return EquipmentVo
     */
    List<EquipmentVo> getAll();

    /**
     * 单独更新图片
     *
     * @param img img
     * @param id  id
     * @return {@link}
     */
    void updateImg(@Param("img") String img, @Param("id") Integer id);

}
