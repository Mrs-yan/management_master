/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:43:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `financial`
-- ----------------------------
DROP TABLE IF EXISTS `financial`;
CREATE TABLE `financial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(255,0) DEFAULT NULL COMMENT '金额',
  `type` varchar(100) DEFAULT NULL COMMENT '类型/收入-支出',
  `describe` varchar(200) DEFAULT NULL COMMENT '性质',
  `task_id` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of financial
-- ----------------------------
INSERT INTO `financial` VALUES ('4', '5000', '收入', '任务收入', '1', '备注', '创建人', '2022-04-22 15:49:34');
INSERT INTO `financial` VALUES ('5', '620', '支出', '任务支出', '1', '备注', '创建人', '2022-04-22 15:50:16');
INSERT INTO `financial` VALUES ('8', '15', '支出', '其他', '2', '备注', '创建人', '2022-04-23 07:07:56');
INSERT INTO `financial` VALUES ('11', '1555', '收入', '55', '14', '5555', '严虹钱', '2022-05-04 02:29:34');
