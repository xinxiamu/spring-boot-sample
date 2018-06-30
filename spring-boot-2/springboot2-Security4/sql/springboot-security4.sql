/*
Navicat MySQL Data Transfer

Source Server         : 架空科技
Source Server Version : 80011
Source Host           : jiakongkeji.cn:3306
Source Database       : springboot-security4

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-05-23 15:18:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for s_resource
-- ----------------------------
DROP TABLE IF EXISTS `s_resource`;
CREATE TABLE `s_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `method_name` varchar(400) DEFAULT NULL,
  `method_path` varchar(1000) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `resource_id` varchar(50) DEFAULT NULL,
  `resource_name` varchar(400) DEFAULT NULL,
  `resource_string` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s_resource
-- ----------------------------
INSERT INTO `s_resource` VALUES ('1', null, null, '1', '1', 'ADMIN', '/hello');
INSERT INTO `s_resource` VALUES ('2', null, null, '1', '2', 'super', '/hello1');
INSERT INTO `s_resource` VALUES ('3', null, null, '1', '3', 'user', '/hello2');

-- ----------------------------
-- Table structure for s_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `s_resource_role`;
CREATE TABLE `s_resource_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` varchar(50) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s_resource_role
-- ----------------------------
INSERT INTO `s_resource_role` VALUES ('1', '1', '2', '2018-05-23 11:33:39');
INSERT INTO `s_resource_role` VALUES ('2', '2', '1', '2018-05-23 11:33:46');
INSERT INTO `s_resource_role` VALUES ('3', '3', '3', '2018-05-23 11:33:58');

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpkoo0xfyi6rd0hs9ybqv92fjp` (`uid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES ('1', 'ADMIN', '1');
INSERT INTO `s_role` VALUES ('2', 'super', '2');
INSERT INTO `s_role` VALUES ('3', 'user', '3');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dob` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', '2018-05-23', '1527107@sina.com', 'TEST', '$2a$04$PjAZFtgkuXa8kxGkypQS/O5WK/h9Vw3N5NNXyRj3U7Z32HHhH3N.W');
INSERT INTO `s_user` VALUES ('2', '2018-05-23', '123456@sian.com', 'user', '$2a$04$a9qutQ1qdoBrJ9aE.Kx90el6kEsajp3T/wWo0L1bsYm4wR6IVIeR6');
