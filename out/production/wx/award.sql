/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : wx

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2016-09-22 23:40:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `min_angle` int(11) DEFAULT NULL,
  `max_angle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of award
-- ----------------------------
INSERT INTO `award` VALUES ('1', '1', '一等奖', '0.01', '100', '1', '14');
INSERT INTO `award` VALUES ('3', '2', '二等奖', '0.02', '100', '106', '134');
INSERT INTO `award` VALUES ('4', '3', '三等奖', '0.05', '100', '226', '254');
INSERT INTO `award` VALUES ('5', '4', '不要灰心', '0.1', null, '16', '44');
INSERT INTO `award` VALUES ('6', '4', '神马也没有', '0.1', null, '46', '74');
INSERT INTO `award` VALUES ('7', '4', '祝您好运', '0.1', null, '76', '104');
INSERT INTO `award` VALUES ('8', '4', '运气先攒着', '0.1', null, '196', '224');
INSERT INTO `award` VALUES ('9', '4', '要加油哦', '0.1', null, '256', '284');
INSERT INTO `award` VALUES ('10', '4', '谢谢参与', '0.1', null, '316', '344');
INSERT INTO `award` VALUES ('11', '4', '再接再厉', '0.1', null, '136', '164');
INSERT INTO `award` VALUES ('12', '1', '一等奖', '0.01', '100', '346', '364');
INSERT INTO `award` VALUES ('13', '4', '神马也没有', '0.1', null, '166', '194');
INSERT INTO `award` VALUES ('14', '4', '神马也没有', '0.1', null, '286', '314');

-- ----------------------------
-- Table structure for msg_award
-- ----------------------------
DROP TABLE IF EXISTS `msg_award`;
CREATE TABLE `msg_award` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `prize` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_award
-- ----------------------------
INSERT INTO `msg_award` VALUES ('6', 'o8dlRwNH5', '6262', '14', '2016-09-22 18:07:39');
INSERT INTO `msg_award` VALUES ('7', 'o8dlRwNH5t-C9QpLQFPEw8LP', '66w', '9', '2016-09-22 18:14:07');
INSERT INTO `msg_award` VALUES ('8', 'o8dlRwNH5t-C9QpLQFPEw8LP3Su0=', '18229472', '4', '2016-09-22 22:05:50');
INSERT INTO `msg_award` VALUES ('9', 'o8dlRwNH5t-C9QpLQFPEw8LP3S', '18229', '10', '2016-09-22 22:54:06');
INSERT INTO `msg_award` VALUES ('10', 'o8dlRwNH5t-C9QpLQFPEw8LP3', '1822', '5', '2016-09-22 23:13:10');
INSERT INTO `msg_award` VALUES ('11', 'o8dlRwNH5t-C9QpLQFPEw8LP3Su0', '182294', '14', '2016-09-22 23:16:35');
