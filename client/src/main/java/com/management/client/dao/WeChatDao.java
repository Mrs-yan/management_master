package com.management.client.dao;

import com.management.client.vo.WeChatVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface WeChatDao {
    List<String> getTemplateId();

    String getInformation(Date date);

    List<WeChatVO> getWeChatList();

    void addInformation(@Param("date") String date,@Param("detailed") String detailed);
}
