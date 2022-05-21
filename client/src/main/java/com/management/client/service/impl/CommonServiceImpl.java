package com.management.client.service.impl;

import com.management.client.dao.CustomerDao;
import com.management.client.dao.EquipmentDao;
import com.management.client.dao.TaskDao;
import com.management.client.service.CommonService;
import com.management.client.service.EquipmentService;
import com.management.client.vo.CustomerVo;
import com.management.client.vo.EquipmentVo;
import com.management.client.vo.TaskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * CommonServiceImpl
 *
 * @author 严虹钱
 * @since 2022/4/28
 */

@Service
public class CommonServiceImpl implements CommonService {
    @Value("${upload.url}")
    String path;

    @Value("${upload.ip}")
    String ip;

    @Autowired
    EquipmentDao equipmentDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    TaskDao taskDao;

    @Override
    public String uploadPicture(MultipartFile file) throws IOException {
        String[] picture = {"jpg", "JPG", "PNG", "png", "JPEG", "jpeg"};
        String filename = file.getOriginalFilename();
        String newFilename = "" + System.currentTimeMillis() + UUID.randomUUID().toString().trim().replaceAll("-", "");
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        if (Arrays.asList(picture).contains(suffix)) {
            String filepath = path + newFilename + "." + suffix;
            String resultName = newFilename + "." + suffix;
            File f = new File(filepath);
            Files.copy(file.getInputStream(), f.toPath());
            // 次为能访问图片的url地址
            return ip + resultName;
        } else {
            throw new IllegalArgumentException("只能上传,PNG.JPG,JPEG格式的图片！");
        }
    }

    @Override
    public List<TaskVo> getTaskList() {
        return taskDao.getTaskList(new TaskVo());
    }

    @Override
    public List<EquipmentVo> getEquipmentList() {
        return equipmentDao.getAll();
    }

    @Override
    public List<CustomerVo> getCustomerList() {
        return customerDao.getAllCustomer(new CustomerVo());
    }
}
