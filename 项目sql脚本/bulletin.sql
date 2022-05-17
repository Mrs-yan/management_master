/*
Navicat MySQL Data Transfer

Source Server         : management_sys
Source Server Version : 50737
Source Host           : 124.71.223.181:3306
Source Database       : management_sys

Target Server Type    : MYSQL
Target Server Version : 50737
File Encoding         : 65001

Date: 2022-05-17 23:42:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bulletin`
-- ----------------------------
DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '公告名称',
  `type` varchar(255) DEFAULT NULL COMMENT '公告类型',
  `task_id` int(11) DEFAULT NULL COMMENT '所属任务',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `content` text COMMENT '公告内容',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bulletin
-- ----------------------------
INSERT INTO `bulletin` VALUES ('2', '上线测试', '公告类型', '2', '严虹钱', '内容', '2022-04-09 13:53:49');
INSERT INTO `bulletin` VALUES ('4', '公告名4', '公告类型', '1', '严虹钱', '内容', '2022-04-09 14:04:32');
INSERT INTO `bulletin` VALUES ('18', '公告测试', '测试', '10', '严虹钱', '开始测试！', '2022-04-24 07:48:10');

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
