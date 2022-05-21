package com.management.client.service;

import com.management.client.vo.BulletinVo;

import java.util.List;

/**
 * BulletinService
 *
 * @author 严虹钱
 * @since 2022/4/18
 */

public interface BulletinService {
    /**
     * insert
     * 插入公告
     *
     * @param bulletin bulletin
     */
    void insert(BulletinVo bulletin);

    /**
     * delete
     * 删除公告
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * update
     * 修改公告
     *
     * @param bulletin bulletin
     */
    void update(BulletinVo bulletin);


    /**
     * getBulletinById
     * 查询单个公告
     *
     * @param id id
     * @return BulletinVo
     */
    BulletinVo getBulletinById(Integer id);

    /**
     * 查询公告列表
     * getBulletinList
     *
     * @return BulletinVo
     */
    List<BulletinVo> getBulletinList();

}
