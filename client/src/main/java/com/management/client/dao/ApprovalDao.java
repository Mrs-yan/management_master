package com.management.client.dao;

import com.management.client.vo.EconomicApplyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalDao {
    /**
     * 提交申请
     * submitApplication
     *
     * @param economicApply
     */
    void submitApplication(EconomicApplyVo economicApply);

    /**
     * 获取个人支出列表
     *
     * @param id id
     * @return
     */
    List<EconomicApplyVo> getApplyListByUser(EconomicApplyVo economicApply);

    /**
     * 操作申请
     * operationApply
     *
     * @param economicApply
     */
    void operationApply(EconomicApplyVo economicApply);


    /**
     * getPendList
     * 获取待审批列表
     *
     * @param status status
     * @return
     */
    List<EconomicApplyVo> getPendList(Integer status);

    /**
     * getALLApplyList
     * 获取全部申请列表
     *
     * @return EconomicApplyVo
     */
    List<EconomicApplyVo> getALLApplyList(EconomicApplyVo economicApply);
}
