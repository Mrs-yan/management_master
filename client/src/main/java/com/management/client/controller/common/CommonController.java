package com.management.client.controller.common;

import com.management.client.service.CommonService;
import com.management.client.vo.CustomerVo;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("common")
public class CommonController {

    @Autowired
    CommonService commonService;

    /**
     * 上传文件接口
     *
     * @param file
     * @return
     */
    @PostMapping("/uploadPicture")
    public Result uploadPicture(@RequestParam MultipartFile file) {
        try {
            String pictureUrl = commonService.uploadPicture(file);
            return new Result().success(pictureUrl);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("upload fail" + e.getMessage());
        }
    }

    /**
     * 获取所有客户
     * getAllCustomer
     *
     * @return
     */
    @GetMapping("/getAllCustomer")
    public Result<List<CustomerVo>> getAllCustomer() {
        try {
            List<CustomerVo> customers = commonService.getCustomerList();
            return new Result<>().success(customers);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 获取所有设备信息
     * getEquipmentList
     *
     * @return
     */
    @GetMapping("/getEquipmentList")
    public Result<List<EquipmentVo>> getEquipmentList() {
        try {
            List<EquipmentVo> equipments = commonService.getEquipmentList();
            return new Result<>().success(equipments);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 获取所有任务
     * getTaskList
     *
     * @return
     */
    @GetMapping("/getTaskList")
    public Result<List<TaskVo>> getTaskList() {
        try {
            List<TaskVo> tasks = commonService.getTaskList();
            return new Result<>().success(tasks);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}

