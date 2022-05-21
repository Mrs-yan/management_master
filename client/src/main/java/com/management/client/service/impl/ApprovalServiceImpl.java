package com.management.client.service.impl;

import com.management.client.dao.ApprovalDao;
import com.management.client.service.ApprovalService;
import com.management.client.vo.EconomicApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * ApprovalServiceImpl
 *
 * @author 严虹钱
 * @since  2022/4/26
 *
 */


@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    ApprovalDao approvalDao;

    @Override
    public void submitApplication(EconomicApplyVo economicApply) {
        if (economicApply.getSpendType() == null || economicApply.getSpendType().equals("")) {
            throw new IllegalArgumentException("花费类型不能为空");
        }
        if (economicApply.getMoney() == null || economicApply.getMoney().equals("")) {
            throw new IllegalArgumentException("金额不能为空");
        }
        if (isNumber(economicApply.getMoney())) {
            economicApply.setCreateTime(new Date());
            approvalDao.submitApplication(economicApply);
        } else {
            throw new IllegalArgumentException("金额不能为字符串哦");
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
    public List<EconomicApplyVo> getApplyListByUser(EconomicApplyVo economicApplyVo) {
        return approvalDao.getApplyListByUser(economicApplyVo);
    }

    @Override
    public void operationApply(EconomicApplyVo economicApply) {
        approvalDao.operationApply(economicApply);
    }

    @Override
    public List<EconomicApplyVo> getPendList(Integer status) {
        return approvalDao.getPendList(status);
    }

    @Override
    public List<EconomicApplyVo> getALLApplyList(EconomicApplyVo economicApply) {
        return approvalDao.getALLApplyList(economicApply);
    }
}
