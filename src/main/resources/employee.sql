/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-05-16 15:45:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'xiaohong', '123456789');
INSERT INTO `employee` VALUES ('2', 'xiaohong', '123456789');
INSERT INTO `employee` VALUES ('3', 'xiaohong', null);
INSERT INTO `employee` VALUES ('4', 'xiaohong', null);
INSERT INTO `employee` VALUES ('5', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('6', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('7', 'xiaohong2', '1234567');
INSERT INTO `employee` VALUES ('8', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('9', 'xiaohong2', '1234567');
INSERT INTO `employee` VALUES ('10', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('11', 'xiaohong2', '1234567');
INSERT INTO `employee` VALUES ('12', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('13', 'xiaohong2', '1234567');
INSERT INTO `employee` VALUES ('14', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('15', 'xiaohong2', '1234567');
INSERT INTO `employee` VALUES ('16', 'xiaohong1', '12389');
INSERT INTO `employee` VALUES ('17', 'xiaohong2', '1234567');
