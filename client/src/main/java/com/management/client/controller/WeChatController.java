package com.management.client.controller;

import com.management.client.dao.WeChatDao;
import com.management.client.service.impl.WeChatImpl;
import com.management.client.unit.CaiHongPiUtils;
import com.management.client.unit.JiNianRiUtils;
import com.management.client.unit.WeatherTypeEnum;
import com.management.client.unit.WeatherUtils;
import com.management.client.vo.Weather;
import com.management.client.vo.common.Result;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
         try{
             WeChatImpl weChat = new WeChatImpl();
             List<String> list = weChatDao.getTemplateId();
             System.out.println(list.size());
             for (String uid : list){
                 weChat.push(uid);
             }
             return new Result<>().success("success");
         }catch (Exception e){
             return new Result<>().fail("fail");
         }
    }
}
