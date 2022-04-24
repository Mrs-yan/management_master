package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.EquipmentService;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    /**
     * 增加新设备
     *
     * @param equipment
     * @return
     */
    @PostMapping("/addEquipment")
    public Result addEquipment(@RequestBody EquipmentVo equipment) {
        try {
            equipmentService.insert(equipment);
            return new Result<>().success("add success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("add fail" + e.getMessage());
        }
    }

    /**
     * 删除设备
     * deleteEquipment
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteEquipment/{id}")
    public Result deleteEquipment(@PathVariable Integer id) {
        try {
            equipmentService.delete(id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新设备
     * updateEquipment
     *
     * @param equipment equipment
     * @return
     */
    @RequestMapping(path = "/updateEquipment/{id}", method = RequestMethod.PATCH)
    public Result updateEquipment(@RequestBody EquipmentVo equipment, @PathVariable Integer id) {
        try {
            equipment.setId(id);
            equipmentService.update(equipment);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    @GetMapping("getEquipmentById/{id}")
    public Result getEquipmentById(@PathVariable Integer id) {
        try {
            EquipmentVo equipment = equipmentService.getEquipmentById(id);
            return new Result<>().success(equipment);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("get fail" + e.getMessage());
        }
    }


    /**
     * 获取所有设备
     * getAllEquipment
     *
     * @return
     */
    @GetMapping("/getAllEquipment/{pageNum}/{pageSize}")
    public Result<PageInfo<EquipmentVo>> getAllUser(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<EquipmentVo> equipments = equipmentService.getAll();
            return new Result<>().success(new PageInfo<>(equipments));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新图片接口
     * updateImg
     *
     * @return
     */
    @GetMapping("/updateImg/{id}/{img}")
    public Result updateImg(@PathVariable Integer id, @PathVariable String img) {
        try {
            equipmentService.updateImg(img, id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}
