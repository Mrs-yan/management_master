package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.CustomerService;
import com.management.client.vo.CustomerVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * CustomerController
 *
 * @author 严虹钱
 * @since  2022/3/30
 *
 */


@Slf4j
@Controller
@ResponseBody
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    /**
     * 增加新客户
     * addCustomer
     *
     * @param customer customer
     * @return
     */
    @PostMapping("/addCustomer")
    public Result addCustomer(@RequestBody CustomerVo customer) {
        try {
            customerService.insert(customer);
            return new Result<>().success("add success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("add fail" + e.getMessage());
        }
    }

    /**
     * 删除客户
     * deleteCustomer
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteCustomer/{id}")
    public Result deleteCustomer(@PathVariable Integer id) {
        try {
            customerService.delete(id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新客户
     * updateCustomer
     *
     * @param customer customer
     * @return
     */
    @RequestMapping(path = "/updateCustomer/{id}", method = RequestMethod.PATCH)
    public Result updateCustomer(@RequestBody CustomerVo customer, @PathVariable Integer id) {
        try {
            customer.setId(id);
            customerService.update(customer);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 查看某个客户
     * getCustomerById
     *
     * @param id
     * @return
     */
    @GetMapping("getCustomerById/{id}")
    public Result getCustomerById(@PathVariable Integer id) {
        try {
            CustomerVo customer = customerService.getCustomerById(id);
            return new Result<>().success(customer);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("get fail" + e.getMessage());
        }
    }


    /**
     * 获取所有客户
     * getAllCustomer
     *
     * @return
     */
    @GetMapping("/getAllCustomer/{pageNum}/{pageSize}")
    public Result<PageInfo<CustomerVo>> getAllCustomer(@PathVariable Integer pageNum, @PathVariable Integer pageSize,CustomerVo customer) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<CustomerVo> customers = customerService.getAllCustomer(customer);
            return new Result<>().success(new PageInfo<>(customers));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}
