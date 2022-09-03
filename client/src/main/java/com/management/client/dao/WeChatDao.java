package com.management.client.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeChatDao {
    List<String> getTemplateId();
}
