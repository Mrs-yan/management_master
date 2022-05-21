package com.management.client.service.impl;

import com.management.client.dao.FinancialDao;
import com.management.client.service.FinancialService;
import com.management.client.vo.FinancialDataVo;
import com.management.client.vo.FinancialVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * FinancialServiceImpl
 *
 * @author 严虹钱
 * @since 2022/4/26
 */
@Service
public class FinancialServiceImpl implements FinancialService {
    @Autowired
    FinancialDao financialDao;

    @Override
    public void addFinancial(FinancialVo financialVo) {
        financialVo.setCreateTime(new Date());
        String result = financialVo.getMoney();
        if (isNumber(result)) {
            financialDao.addFinancial(financialVo);
        } else {
            throw new IllegalArgumentException("金额必须为数字！请重新输入");
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

    @Override
    public List<FinancialVo> getFinancialList(FinancialVo financial) {
        return financialDao.getFinancialList(financial);
    }

    @Override
    public void deleteFinancial(Integer id) {
        financialDao.deleteFinancial(id);
    }

    @Override
    public FinancialDataVo getFinancialData(FinancialDataVo financial) {
        //累计收入
        Double totalRevenue = 0.0;
        financial.setType("收入");
        totalRevenue = financialDao.getFinancialTotal(financial);
        // 因公支出
        Double businessSpend = 0.0;
        financial.setType("因公支出");
        businessSpend = financialDao.getEmployeeSpend(financial);

        // 任务支出
        Double taskSpend = 0.0;
        financial.setType("任务支出");
        taskSpend = financialDao.getEmployeeSpend(financial);
        // 审批未通过
        Double approvalFail = 0.0;
        approvalFail = financialDao.getNotPassSpend(financial);

        // 累计支出
        Double totalSpend = businessSpend + taskSpend;
        financial.setType("支出");
        totalSpend += financialDao.getFinancialTotal(financial);

        // 累计利润
        Double totalProfits = totalRevenue - totalSpend;

        return FinancialDataVo.builder()
                .totalSpend(totalSpend)
                .approvalFail(approvalFail)
                .businessSpend(businessSpend)
                .taskSpend(taskSpend)
                .totalProfits(totalProfits)
                .totalRevenue(totalRevenue)
                .build();
    }

    @Override
    public FinancialVo getFinancialById(Integer id) {
        return financialDao.getFinancialById(id);
    }
}
