package com.management.client.dao;

import com.management.client.vo.FinancialDataVo;
import com.management.client.vo.FinancialVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * FinancialDao
 *
 * @author 严虹钱
 * @since 2022/4/26
 */


@Mapper
public interface FinancialDao {
    /**
     * addFinancial
     * 添加收入/支出
     *
     * @param financialVo financialVo
     */
    void addFinancial(FinancialVo financialVo);

    /**
     * getFinancialList
     * 获取财务列表
     *
     * @return
     */
    List<FinancialVo> getFinancialList(FinancialVo financial);

    /**
     * deleteFinancial
     * 删除财务列表数据
     *
     * @param id id
     */
    void deleteFinancial(Integer id);

    /**
     * getFinancialTotal
     * 获取累计收入/支出
     *
     * @param financial
     * @return
     */
    Double getFinancialTotal(FinancialDataVo financial);

    /**
     * getEmployeeSpend
     * 获取员工申请的支出
     *
     * @param financial financial
     * @return Integer
     */
    Double getEmployeeSpend(FinancialDataVo financial);

    /**
     * getNotPassSpend
     * 获取审批未通过金额
     *
     * @param financial financial
     * @return Integer
     */
    Double getNotPassSpend(FinancialDataVo financial);

    /**
     * 查询财务数据详细
     * getFinancialById
     *
     * @param id
     * @return FinancialVo
     */
    FinancialVo getFinancialById(Integer id);
}