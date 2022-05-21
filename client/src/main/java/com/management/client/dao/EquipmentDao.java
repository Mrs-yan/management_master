package com.management.client.dao;

import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * EquipmentDao
 *
 * @author 严虹钱
 * @since  2022/3/27
 *
 */


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
     * updateImg
     *
     * @param img img
     * @param id  id
     * @return {@link}
     */
    void updateImg(@Param("img") String img, @Param("id") Integer id);

    /**
     * getTotalRevenue
     * 获取设备累计收入
     *
     * @param id
     * @return
     */
    Double getTotalRevenue(Integer id);

    /**
     * 查询设备相关全部设备
     * getEquipmentWithTask
     *
     * @param id id
     * @return
     */
    List<TaskVo> getEquipmentWithTask(Integer id);

    /**
     * 修改设备设用状态
     * updateUseStatus
     *
     * @param status
     */
    void updateUseStatus(@Param("status") Integer status,@Param("id") Integer id);
}
