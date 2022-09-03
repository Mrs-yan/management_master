package com.management.client.task;

import com.management.client.dao.WeChatDao;
import com.management.client.service.impl.WeChatImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class WeChatTask {
    @Autowired
    private WeChatDao weChatDao;

    @Scheduled(cron = "0 0 8 * * ?")
    public void push(){
        WeChatImpl weChat = new WeChatImpl();
        List<String> list = weChatDao.getTemplateId();
        for (String uid : list){
            weChat.push(uid);
        }
    }
}
