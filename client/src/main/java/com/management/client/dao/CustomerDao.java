package com.management.client.dao;

import com.management.client.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {

    /**
     * 插入客户数据
     * insert
     *
     * @param customerVo
     */
    void insert(CustomerVo customerVo);

    /**
     * 删除客户数据
     * delete
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 修改客户数据
     * update
     *
     * @param customer
     */
    void update(CustomerVo customer);

    /**
     * 查看客户信息
     * getCustomerById
     *
     * @param id
     * @return
     */
    CustomerVo getCustomerById(Integer id);

    /**
     * 查看所有客户
     * getAllCustomer
     *
     * @return
     */
    List<CustomerVo> getAllCustomer(CustomerVo customer);
}
