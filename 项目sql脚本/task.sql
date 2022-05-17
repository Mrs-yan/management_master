/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:43:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT '' COMMENT '任务名称',
  `customer_id` int(11) DEFAULT NULL COMMENT '所属客户ID',
  `equipment_id` int(11) DEFAULT NULL COMMENT '设备id',
  `address` varchar(600) DEFAULT NULL COMMENT '地址',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `status` int(11) DEFAULT NULL COMMENT '状态/1进行中/2未开始/0已完成',
  `remark` text COMMENT '备注',
  `scheduled_start_time` datetime DEFAULT NULL COMMENT '预定开始时间',
  `actual_start_time` datetime DEFAULT NULL COMMENT '实际开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delete_is` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '任务名称', '1', '1', '地址', '类型', '2', '备注', null, null, null, '创建人', null, '1');
INSERT INTO `task` VALUES ('2', '红塔大道建设', '2', '1', '地址', '类型', '3', '备注', '2022-04-10 15:12:13', '2022-04-18 14:55:35', '2022-04-08 20:23:59', '创建人', null, '0');
INSERT INTO `task` VALUES ('14', '马井红绿灯施工111', '15', '1', '马井', '道路摊铺', '2', null, '2022-05-05 16:00:00', null, null, '严虹钱', '2022-05-04 01:33:06', '0');
INSERT INTO `task` VALUES ('15', '111', '15', '1', '111', '11', '1', null, null, null, null, '严虹钱', '2022-05-04 02:26:44', '0');
