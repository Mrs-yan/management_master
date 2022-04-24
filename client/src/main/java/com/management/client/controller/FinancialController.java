package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.FinancialService;
import com.management.client.vo.FinancialDataVo;
import com.management.client.vo.FinancialVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("financial")
public class FinancialController {
    @Autowired
    FinancialService financialService;

    /**
     * addFinancial
     * 添加收入/支出数据
     *
     * @param financial financial
     * @return
     */
    @PostMapping("/addFinancial")
    public Result addFinancial(@RequestBody FinancialVo financial) {
        try {
            financialService.addFinancial(financial);
            return new Result().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 获取财务列表
     * getFinancialList
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return
     */
    @GetMapping("/getFinancialList/{pageNum}/{pageSize}")
    public Result<List<FinancialVo>> getFinancialList(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<FinancialVo> result = financialService.getFinancialList();
            return new Result().success(new PageInfo<>(result));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * deleteFinancial
     * 删除财务列表
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteFinancial/{id}")
    public Result deleteFinancial(@PathVariable Integer id) {
        try {
            financialService.deleteFinancial(id);
            return new Result().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * getFinancialData
     * 获取财务报表数据
     *
     * @param financial
     * @return
     */
    @PostMapping("/getFinancialData")
    public Result getFinancialData(@RequestBody FinancialDataVo financial) {
        try {
            FinancialDataVo result = financialService.getFinancialData(financial);
            return new Result().success(result);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}
