package com.management.client.service;

import com.management.client.vo.FinancialDataVo;
import com.management.client.vo.FinancialVo;

import java.util.List;

public interface FinancialService {
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
     * getFinancialData
     * 获取财务报表
     *
     * @param financial financial
     * @return FinancialDataVo
     */
    FinancialDataVo getFinancialData(FinancialDataVo financial);

    /**
     * 查询财务数据详细
     * getFinancialById
     *
     * @param id
     * @return FinancialVo
     */
    FinancialVo getFinancialById(Integer id);
}
