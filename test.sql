/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2017-05-21 19:12:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `description` varchar(10) DEFAULT NULL,
  `city_name` varchar(10) DEFAULT NULL,
  `province_id` varchar(10) DEFAULT NULL,
  `id` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('aaa', 'df', '12', '1');

-- ----------------------------
-- Table structure for `cm_picture`
-- ----------------------------
DROP TABLE IF EXISTS `cm_picture`;
CREATE TABLE `cm_picture` (
  `picturename` varchar(60) DEFAULT NULL,
  `pictureid` int(5) NOT NULL AUTO_INCREMENT,
  `pictureurl` varchar(500) DEFAULT NULL,
  `picture_date` datetime DEFAULT NULL,
  `picturefix` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pictureid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cm_picture
-- ----------------------------
INSERT INTO `cm_picture` VALUES ('img_7859520170423a8', '19', 'E:\\java\\idea\\myfreemarker\\target\\classes\\static\\upload\\img_7859520170423a8.jpg', '2017-04-23 11:36:06', '.jpg');

-- ----------------------------
-- Table structure for `cm_task`
-- ----------------------------
DROP TABLE IF EXISTS `cm_task`;
CREATE TABLE `cm_task` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `begindate` datetime DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `isfinish` int(11) DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `registerdate` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cm_task
-- ----------------------------
INSERT INTO `cm_task` VALUES ('1', 'author', '2017-04-11 20:52:24', '2017-04-11 20:52:27', '0', 'shopping', '2017-04-11 20:52:33', 'aaaa');
INSERT INTO `cm_task` VALUES ('2', 'a', '2017-04-12 21:39:57', '2017-04-13 21:40:00', '1', 'aa', '2017-04-11 21:40:17', '222');
INSERT INTO `cm_task` VALUES ('3', 'zhaoying', '2017-04-11 23:15:02', '2017-04-11 23:15:05', '1', 'saaa', '2017-04-11 23:15:17', 'afda');
INSERT INTO `cm_task` VALUES ('4', 'afa', '2017-04-11 23:15:51', '2017-04-11 23:15:27', '0', 'ada', '2017-04-11 23:15:36', 'fada');
INSERT INTO `cm_task` VALUES ('5', 'aaa', '2017-04-11 23:16:01', '2017-04-11 23:16:04', '1', 'ad', '2017-04-11 23:16:10', 'afa');
INSERT INTO `cm_task` VALUES ('6', 'aaf', '2017-04-11 23:16:50', '2017-04-13 23:16:19', '2', 'fadf', '2017-04-21 23:16:30', 'fad');
INSERT INTO `cm_task` VALUES ('7', 'aaa', '2017-04-05 00:00:00', '2017-04-05 00:00:00', '0', 'aaa', '2017-04-15 18:52:12', 'aaa');
INSERT INTO `cm_task` VALUES ('8', 'aaa', '2017-04-06 00:00:00', '2017-04-05 00:00:00', '0', 'create task', '2017-04-17 20:30:29', 'aaa');
INSERT INTO `cm_task` VALUES ('9', 'aaa', '2017-04-06 00:00:00', '2017-04-05 00:00:00', '0', 'create task', '2017-04-17 20:33:09', '');

-- ----------------------------
-- Table structure for `cm_user`
-- ----------------------------
DROP TABLE IF EXISTS `cm_user`;
CREATE TABLE `cm_user` (
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `userid` int(100) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cm_user
-- ----------------------------
INSERT INTO `cm_user` VALUES ('aaa', '123456', '12345678', '1');
INSERT INTO `cm_user` VALUES ('aaa', '12345', '12345678', '2');
