/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:42:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clock_record`
-- ----------------------------
DROP TABLE IF EXISTS `clock_record`;
CREATE TABLE `clock_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `task_id` int(11) DEFAULT NULL COMMENT '任务id',
  `create_time` datetime NOT NULL,
  `status` varchar(255) DEFAULT NULL COMMENT '正常/请假/调休',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clock_record
-- ----------------------------
INSERT INTO `clock_record` VALUES ('20', '1', '2', '2022-04-15 05:47:15', '工作', '备注');
INSERT INTO `clock_record` VALUES ('22', '1', '2', '2022-04-22 14:57:08', '打卡', '玩玩');
INSERT INTO `clock_record` VALUES ('24', '6', '2', '2022-04-24 11:49:20', '打卡', '哈哈哈哈');
INSERT INTO `clock_record` VALUES ('25', '1', '2', '2022-04-24 14:05:52', '打卡', '备注');
INSERT INTO `clock_record` VALUES ('26', '1', '2', '2022-05-02 08:56:24', '打卡', '还好');
INSERT INTO `clock_record` VALUES ('27', '1', '2', '2022-05-03 14:29:11', '打卡', '5/3打卡');
INSERT INTO `clock_record` VALUES ('28', '1', '14', '2022-05-04 02:27:22', '打卡', '111');
INSERT INTO `clock_record` VALUES ('29', '1', '2', '2022-05-06 06:48:26', '打卡', '897');
INSERT INTO `clock_record` VALUES ('30', '15', '15', '2022-05-10 18:30:09', '请假', '呜呜呜');
INSERT INTO `clock_record` VALUES ('31', '15', '15', '2022-05-14 06:37:06', '打卡', '11');
INSERT INTO `clock_record` VALUES ('32', '1', '2', '2022-05-15 07:53:23', '打卡', '哈喽');
