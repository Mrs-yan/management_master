package com.management.client.service;

import com.management.client.vo.CustomerVo;

import java.util.List;

public interface CustomerService {
    /**
     * 插入客户数据
     * insert
     *
     * @param customerVo
     */
    void insert(CustomerVo customer);

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
