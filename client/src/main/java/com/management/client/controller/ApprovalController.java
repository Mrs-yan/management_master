package com.management.client.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.ApprovalService;

import com.management.client.vo.EconomicApplyVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author 严虹钱
 * @since 2022/04/10
 *
 */

@Slf4j
@Controller
@ResponseBody
@RequestMapping("approval")
public class ApprovalController {
    @Autowired
    ApprovalService approvalService;

    /**
     * submitApplication
     * 提交申请
     *
     * @param economicApply economicApply
     * @return
     */
    @PostMapping("/submitApplication")
    public Result submitApplication(@RequestBody EconomicApplyVo economicApply) {
        try {
            approvalService.submitApplication(economicApply);
            return new Result().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getApplyListByUser
     * 查询当前用户申请列表
     *
     * @param proposerId proposerId
     * @param pageNum    pageNum
     * @param pageSize   pageSize
     * @return
     */
    @GetMapping("/getApplyListByUser/{proposerId}/{pageNum}/{pageSize}")
    public Result<PageInfo<EconomicApplyVo>> getApplyListByUser(@PathVariable Integer proposerId, @PathVariable Integer pageNum, @PathVariable Integer pageSize, EconomicApplyVo economicApply) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            economicApply.setId(proposerId);
            List<EconomicApplyVo> list = approvalService.getApplyListByUser(economicApply);
            return new Result().success(new PageInfo<>(list));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * operationApply
     * 审批申请
     *
     * @param id     id
     * @param status status
     * @return
     */
    @GetMapping("/operationApply/{id}/{status}/{approverId}")
    public Result operationApply(@PathVariable Integer id, @PathVariable Integer status, @PathVariable Integer approverId) {
        try {
            EconomicApplyVo economicApply = new EconomicApplyVo();
            economicApply.setId(id);
            economicApply.setStatus(status);
            economicApply.setApproverId(approverId);
            approvalService.operationApply(economicApply);
            return new Result().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 获取待审批列表
     * getPendList
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    @GetMapping("/getPendList/{pageNum}/{pageSize}")
    public Result<PageInfo<EconomicApplyVo>> getPendList(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<EconomicApplyVo> list = approvalService.getPendList(0);
            return new Result().success(new PageInfo<>(list));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getALLApplyList
     * 获取全部审批列表
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    @GetMapping("/getALLApplyList/{pageNum}/{pageSize}")
    public Result<List<EconomicApplyVo>> getALLApplyList(@PathVariable Integer pageNum, @PathVariable Integer pageSize, EconomicApplyVo economicApply) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<EconomicApplyVo> list = approvalService.getALLApplyList(economicApply);
            return new Result().success(new PageInfo<>(list));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}
