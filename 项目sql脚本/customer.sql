/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:42:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL COMMENT '公司名称',
  `type` varchar(500) DEFAULT NULL COMMENT '公司类型',
  `telephone_number` varchar(3000) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(800) DEFAULT NULL COMMENT '公司地址',
  `superintendent` varchar(300) DEFAULT NULL COMMENT '负责人',
  `remark` text COMMENT '备注',
  `create_by` varchar(300) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `delete_is` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '众和有限公司', '路面工程', '电话号码', '地址', '负责人', '备注', '创建人，就是登录人的姓名', null, '1');
INSERT INTO `customer` VALUES ('2', '云南一建', '房地产', '电话号码', '地址', '负责人', '备注', '创建人，就是登录人的姓名', '2022-04-06 19:09:19', '1');
INSERT INTO `customer` VALUES ('15', '众和责任有限公司', '路面工程', '13887770804', '玉溪', '2', '测试', '严虹钱', '2022-05-04 01:29:25', '0');
INSERT INTO `customer` VALUES ('16', '1', '1', '1', '1', '1', '1', '严虹钱1', '2022-05-15 07:51:14', '1');
