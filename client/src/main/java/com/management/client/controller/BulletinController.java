package com.management.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.client.service.BulletinService;
import com.management.client.vo.BulletinVo;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("bulletin")
public class BulletinController {
    @Autowired
    BulletinService bulletinService;

    /**
     * 增加新公告
     * addBulletin
     *
     * @param bulletin bulletin
     * @return
     */
    @PostMapping("/addBulletin")
    public Result addBulletin(@RequestBody BulletinVo bulletin) {
        try {
            bulletinService.insert(bulletin);
            return new Result<>().success("add success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("add fail" + e.getMessage());
        }
    }

    /**
     * 删除公告
     * deleteBulletin
     *
     * @param id id
     * @return
     */
    @DeleteMapping("/deleteBulletin/{id}")
    public Result deleteBulletin(@PathVariable Integer id) {
        try {
            bulletinService.delete(id);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 更新公告
     * updateBulletin
     *
     * @param bulletin bulletin
     * @return
     */
    @RequestMapping(path = "/updateBulletin/{id}", method = RequestMethod.PATCH)
    public Result updateBulletin(@RequestBody BulletinVo bulletin, @PathVariable Integer id) {
        try {
            bulletin.setId(id);
            bulletinService.update(bulletin);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }

    /**
     * 查看某个公告
     * getBulletinById
     *
     * @param id
     * @return BulletinVo
     */
    @GetMapping("getBulletinById/{id}")
    public Result getBulletinById(@PathVariable Integer id) {
        try {
            BulletinVo bulletin = bulletinService.getBulletinById(id);
            return new Result<>().success(bulletin);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("get fail" + e.getMessage());
        }
    }


    /**
     * 获取所有公告
     * getAllBulletin
     *
     * @return BulletinVo
     */
    @GetMapping("/getAllBulletin/{pageNum}/{pageSize}")
    public Result<PageInfo<BulletinVo>> getAllBulletin(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<BulletinVo> bulletins = bulletinService.getBulletinList();
            return new Result<>().success(new PageInfo<>(bulletins));
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail" + e.getMessage());
        }
    }
}
