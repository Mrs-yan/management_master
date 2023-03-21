package com.management.client.controller;

import com.management.client.dao.WeChatDao;
import com.management.client.service.impl.WeChatImpl;
import com.management.client.vo.WeChatVO;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * WeChatController
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping("wechat")
public class WeChatController {
    @Autowired
    private WeChatDao weChatDao;

    @GetMapping("push")
    public Result<String> pushMessage() {
        try {
            sss(weChatDao);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail");
        }
    }

    public static void sss(WeChatDao weChatDao) {
        WeChatImpl weChat = new WeChatImpl();
        String remark = weChatDao.getInformation(new Date());
        if (remark == null){
            remark = "我爱你！";
        }
        List<WeChatVO> weChatVOList = weChatDao.getWeChatList();
        for (WeChatVO we : weChatVOList) {
            we.setRemark(remark);
            weChat.push(we);
        }
    }

    @GetMapping("add/{date}/{detailed}")
    public Result<String> add(@PathVariable String date, @PathVariable String detailed) {
        try {
            System.out.println(new Date());
            weChatDao.addInformation(date,detailed);
            return new Result<>().success("success");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new Result<>().fail("fail");
        }

    }

    // 解析前台字符时间
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}

