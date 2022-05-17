/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:43:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `spend_data`
-- ----------------------------
DROP TABLE IF EXISTS `spend_data`;
CREATE TABLE `spend_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spend_type` varchar(255) NOT NULL COMMENT '支出类型  因公支出/个人预支',
  `money` double(255,0) DEFAULT NULL,
  `task_id` int(11) NOT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `proposer_id` int(11) NOT NULL COMMENT '申请人id',
  `create_time` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '审批状态 0申请中/1已通过/2拒绝',
  `approver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spend_data
-- ----------------------------
INSERT INTO `spend_data` VALUES ('1', '1', null, '2', null, '1', null, '1', null);
INSERT INTO `spend_data` VALUES ('2', '花费类型', '500', '2', '备注', '1', '2022-04-15 13:14:36', '1', '1');
INSERT INTO `spend_data` VALUES ('3', '任务支出', '500', '2', '备注', '1', '2022-04-15 13:41:48', '1', '1');
INSERT INTO `spend_data` VALUES ('4', '任务支出', '500', '2', '备注', '1', '2022-04-22 08:32:07', '2', '1');
INSERT INTO `spend_data` VALUES ('5', '因公支出', '500', '2', '群威群胆发生', '1', '2022-04-22 08:35:27', '0', null);
INSERT INTO `spend_data` VALUES ('6', '个人预支', '10000', '2', '预支测试', '1', '2022-04-24 13:13:56', '0', null);
INSERT INTO `spend_data` VALUES ('7', '因公支出', '5620', '2', '哈喽呀', '6', '2022-04-24 13:23:56', '1', '1');
INSERT INTO `spend_data` VALUES ('8', '因公支出', '10000', '14', '1111', '1', '2022-05-04 02:28:43', '2', '1');
