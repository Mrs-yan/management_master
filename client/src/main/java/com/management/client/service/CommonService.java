package com.management.client.service;

import com.management.client.vo.CustomerVo;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 公共组件服务
 */
public interface CommonService {

    /**
     * 上传图片服务，返回图片名称
     *
     * @param file
     * @return String
     */
    String uploadPicture(MultipartFile file) throws IOException;

    /**
     * 获取所有设备
     * getEquipmentList
     *
     * @return
     */
    List<EquipmentVo> getEquipmentList();

    /**
     * 获取所有客户
     * getCustomerList
     *
     * @return CustomerVo
     */
    List<CustomerVo> getCustomerList();

    /**
     * getTaskList
     * 获取所有的任务
     *
     * @return TaskVo
     */
    List<TaskVo> getTaskList();
}
