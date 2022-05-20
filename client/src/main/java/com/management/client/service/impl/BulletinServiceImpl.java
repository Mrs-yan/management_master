package com.management.client.service.impl;

import com.management.client.dao.BulletinDao;
import com.management.client.service.BulletinService;
import com.management.client.vo.BulletinVo;
import com.management.client.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BulletinServiceImpl implements BulletinService {
    @Autowired
    BulletinDao bulletinDao;

    @Override
    public void insert(BulletinVo bulletin) {
        chekEmpty(bulletin);
        List<BulletinVo> bulletinVos = bulletinDao.getBulletinList();
        if (bulletinVos.stream().anyMatch(Vo -> Vo.getName().equals(bulletin.getName()))) {
            throw new IllegalArgumentException("该公告名称已经存在");
        }
        bulletin.setCreateTime(new Date());
        bulletinDao.insert(bulletin);
    }


    @Override
    public void delete(Integer id) {
        bulletinDao.delete(id);
    }

    @Override
    public void update(BulletinVo bulletin) {
        chekEmpty(bulletin);
        List<BulletinVo> bulletinVos = bulletinDao.getBulletinList();
        BulletinVo old = bulletinDao.getBulletinById(bulletin.getId());
        if (bulletinVos.stream().anyMatch(Vo -> Vo.getName().equals(bulletin.getName())) && !old.getName().equals(bulletin.getName())) {
            throw new IllegalArgumentException("该公告名称已经存在");
        }
        bulletinDao.update(bulletin);
    }

    @Override
    public BulletinVo getBulletinById(Integer id) {
        return bulletinDao.getBulletinById(id);
    }

    @Override
    public List<BulletinVo> getBulletinList() {
        return bulletinDao.getBulletinList();
    }

    void chekEmpty(BulletinVo bulletin) {
        if (bulletin.getName() == null) {
            throw new IllegalArgumentException("公告名称不能为空");
        }
        if (bulletin.getContent() == null) {
            throw new IllegalArgumentException("公告内容不能为空！");
        }
    }
}