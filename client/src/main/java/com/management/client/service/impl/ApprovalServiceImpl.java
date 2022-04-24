package com.management.client.service.impl;

import com.management.client.dao.ApprovalDao;
import com.management.client.service.ApprovalService;
import com.management.client.vo.EconomicApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    ApprovalDao approvalDao;
    @Override
    public void submitApplication(EconomicApplyVo economicApply) {
         economicApply.setCreateTime(new Date());
         approvalDao.submitApplication(economicApply);
    }

    @Override
    public List<EconomicApplyVo> getApplyListByUser(Integer id) {
        return approvalDao.getApplyListByUser(id);
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
    public List<EconomicApplyVo> getALLApplyList() {
        return approvalDao.getALLApplyList();
    }
}
