package com.management.client.task;

import com.management.client.controller.WeChatController;
import com.management.client.dao.WeChatDao;
import com.management.client.service.impl.WeChatImpl;
import com.management.client.vo.WeChatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class WeChatTask {
    @Autowired
    private WeChatDao weChatDao;

    /**
     * 每天8点定时推送
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void push(){
        WeChatController.sss(weChatDao);
    }
}
