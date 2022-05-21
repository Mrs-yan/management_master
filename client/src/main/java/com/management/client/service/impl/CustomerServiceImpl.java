package com.management.client.service.impl;

import com.management.client.dao.CustomerDao;
import com.management.client.service.CustomerService;
import com.management.client.vo.CustomerVo;
import com.management.client.vo.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * CustomerServiceImpl
 *
 * @author 严虹钱
 * @since 2022/3/30
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public void insert(CustomerVo customer) {
        chekEmpty(customer);
        List<CustomerVo> customers = customerDao.getAllCustomer(new CustomerVo());
        if (customers.stream().anyMatch(VO -> VO.getName().equals(customer.getName()))) {
            throw new IllegalArgumentException("该客户已经存在！请重新核对");
        }
        customer.setCreateTime(new Date());
        customerDao.insert(customer);
    }

    @Override
    public void delete(Integer id) {
        customerDao.delete(id);
    }

    @Override
    public void update(CustomerVo customer) {
        chekEmpty(customer);
        CustomerVo old = customerDao.getCustomerById(customer.getId());
        List<CustomerVo> customers = customerDao.getAllCustomer(new CustomerVo());
        if (customers.stream().anyMatch(VO -> VO.getName().equals(customer.getName())) && !old.getName().equals(customer.getName())) {
            throw new IllegalArgumentException("该客户已经存在！请重新更换名称");
        }
        customerDao.update(customer);
    }

    @Override
    public CustomerVo getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public List<CustomerVo> getAllCustomer(CustomerVo customer) {
        return customerDao.getAllCustomer(customer);
    }

    void chekEmpty(CustomerVo customer) {
        if (customer.getName() == null || customer.getName().equals("")) {
            throw new IllegalArgumentException("客户名称不能为空");
        }
        if (customer.getSuperintendent() == null || customer.getSuperintendent().equals("")) {
            throw new IllegalArgumentException("负责人不能为空！");
        }
    }
}
