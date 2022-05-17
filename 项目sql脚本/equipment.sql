/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:43:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `equipment`
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `model` varchar(255) DEFAULT NULL COMMENT '型号',
  `price` varchar(1000) DEFAULT NULL COMMENT '价格',
  `create_time` datetime DEFAULT NULL,
  `responsible` varchar(150) DEFAULT NULL COMMENT '责任人',
  `img` varchar(5000) DEFAULT NULL COMMENT '0未删除  1已经删除',
  `create_by` varchar(2000) DEFAULT NULL,
  `total_revenue` varchar(2000) DEFAULT NULL COMMENT '累计收入',
  `delete_is` int(11) NOT NULL DEFAULT '0',
  `work_time` varchar(2000) DEFAULT NULL COMMENT '工作时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '大力摊铺', '摊铺机', 'Y-600', '1560000', '2022-05-03 09:18:59', '严虹钱', 'https://cloud.ilikestudy.cn//Typora13111649265821_.pic.jpg', '小廖', '0', '0', '0');
INSERT INTO `equipment` VALUES ('28', 'a', 'a', 'a', '200', '2022-05-04 01:25:21', '测试', 'http://124.71.223.181:81/16516275127777bc12a874d924e919adbc775f77ec8bd.jpg', null, null, '1', null);
INSERT INTO `equipment` VALUES ('29', '11', '11', '1', '11', '2022-05-04 02:25:47', '11', 'http://124.71.223.181:81/165163114171053ac228020b54b47a597a88564ad8686.jpg', null, null, '1', null);
INSERT INTO `equipment` VALUES ('30', null, null, null, null, '2022-05-15 07:52:07', null, 'http://124.71.223.181:81/16526011251502bd4a50c648046908eb737f5d243bcf4.jpg', null, null, '1', null);
INSERT INTO `equipment` VALUES ('31', '呜呜呜', '我', '我', '213', '2022-05-15 14:49:41', '呜呜企鹅群', 'https://yhqimg.ilikestudy.cn/1652628222163661ddf50fe6d42ea825a957655192d5f.jpg', null, null, '0', null);
