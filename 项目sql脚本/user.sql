/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:43:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `telephone_number` varchar(1000) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `work_type` varchar(200) DEFAULT '' COMMENT '工种',
  `id_card_number` varchar(6000) DEFAULT NULL,
  `account` varchar(2000) NOT NULL,
  `password` varchar(2000) NOT NULL,
  `role` int(11) NOT NULL COMMENT '0管理员  1用户',
  `img` varchar(3000) DEFAULT NULL,
  `work_number` varchar(3000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '严虹钱1', '138800088', '男', '程序员', '565555555', 'admin', 'admin', '0', 'https://yhqimg.ilikestudy.cn/1652629487018b85baf9c6ea94993b377e8d41899b2d3.jpg', '1649177821093', '2022-04-13 09:09:26');
INSERT INTO `user` VALUES ('15', '二屁（用户权限）', '138877999', '男', '程序员', '530402199652', 'sa', '123', '1', 'https://yhqimg.ilikestudy.cn/16526286988475583ec8199ff43d38a31705ae7f44d4f.jpg', '1649223932899', '2022-04-06 05:45:33');
INSERT INTO `user` VALUES ('18', 'yhq', '13887770804', '男', '程序员', '565555555', 'yhq', '123', '1', 'http://124.71.223.181:81/1651818137910dd323faa597d4760a8d80723bf4893ea.jpg', '1651815450484', '2022-05-06 05:37:30');
INSERT INTO `user` VALUES ('19', '严虹钱', '13887770804', '女', '程序员', '530402199955555', 'fy', '520', '1', 'http://124.71.223.181:81/16518182182795ac914af35294b09bdf7d87c2ea2ffb3.jpg', '1651818277762', '2022-05-06 06:24:38');
