/*
 Navicat Premium Data Transfer

 Source Server         : JspStudy
 Source Server Type    : MySQL
 Source Server Version : 50547
 Source Host           : localhost:3306
 Source Schema         : atcrowdfunding

 Target Server Type    : MySQL
 Target Server Version : 50547
 File Encoding         : 65001

 Date: 31/03/2021 22:15:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '系统菜单', 0, NULL, 'glyphicon glyphicon-th-list');
INSERT INTO `t_permission` VALUES (2, '控制面板', 1, NULL, 'glyphicon glyphicon-dashboard');
INSERT INTO `t_permission` VALUES (3, '权限管理', 1, NULL, 'glyphicon glyphicon-tasks');
INSERT INTO `t_permission` VALUES (4, '用户维护', 3, '/user/index', 'glyphicon glyphicon-user');
INSERT INTO `t_permission` VALUES (5, '角色维护', 3, '/role/index', 'glyphicon glyphicon-king');
INSERT INTO `t_permission` VALUES (6, '许可维护', 3, '/permission/index', 'glyphicon glyphicon-lock');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'PM-项目经理');
INSERT INTO `t_role` VALUES (2, 'SE-软件工程师');
INSERT INTO `t_role` VALUES (3, 'PG-程序员');
INSERT INTO `t_role` VALUES (4, 'TL-组长');
INSERT INTO `t_role` VALUES (5, 'GL-组长');
INSERT INTO `t_role` VALUES (6, 'QC-品质控制');
INSERT INTO `t_role` VALUES (7, 'SA-软件架构师');
INSERT INTO `t_role` VALUES (8, 'CMO / CMS-配置管理员');
INSERT INTO `t_role` VALUES (9, 'SYSTEM-系统管理员');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NULL DEFAULT NULL,
  `permissionid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (19, 3, 4);
INSERT INTO `t_role_permission` VALUES (18, 3, 3);
INSERT INTO `t_role_permission` VALUES (17, 3, 1);
INSERT INTO `t_role_permission` VALUES (5, 9, 1);
INSERT INTO `t_role_permission` VALUES (6, 9, 2);
INSERT INTO `t_role_permission` VALUES (7, 9, 3);
INSERT INTO `t_role_permission` VALUES (8, 9, 4);
INSERT INTO `t_role_permission` VALUES (9, 9, 5);
INSERT INTO `t_role_permission` VALUES (10, 9, 6);
INSERT INTO `t_role_permission` VALUES (11, 1, 1);
INSERT INTO `t_role_permission` VALUES (12, 1, 2);
INSERT INTO `t_role_permission` VALUES (13, 1, 3);
INSERT INTO `t_role_permission` VALUES (14, 1, 4);
INSERT INTO `t_role_permission` VALUES (15, 1, 5);
INSERT INTO `t_role_permission` VALUES (16, 1, 6);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginacct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userpswd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zhangsan', 'zhangsan', 'zhangsan', 'zhangsan@test.com', '2020-03-15');
INSERT INTO `t_user` VALUES (2, '超级管理员', 'admin', 'admin', '962713793@qq.com', NULL);
INSERT INTO `t_user` VALUES (3, '刘一帆', 'liuyifan', '123456', '', '2021-03-14 22:20:30');
INSERT INTO `t_user` VALUES (4, '刘某某', 'liu1fan', '123456', '962713793@qq.com', '2021-03-14 22:20:50');
INSERT INTO `t_user` VALUES (5, '毛毛', 'maomao', '123456', '', '2021-03-14 22:21:02');
INSERT INTO `t_user` VALUES (6, '李四', 'lisi', '123456', '', '2021-03-14 22:21:36');
INSERT INTO `t_user` VALUES (7, '王五', 'wangwu', '123456', '', '2021-03-14 22:21:47');
INSERT INTO `t_user` VALUES (8, '哈哈哈', 'hhh', '123456', '', '2021-03-14 22:22:08');
INSERT INTO `t_user` VALUES (9, 'wangyangming', 'aaa', '123456', '', '2021-03-14 22:22:25');
INSERT INTO `t_user` VALUES (10, 'root', 'admin6', '123456', '', '2021-03-14 22:28:10');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1, 3);
INSERT INTO `t_user_role` VALUES (4, 2, 9);
INSERT INTO `t_user_role` VALUES (3, 9, 3);

SET FOREIGN_KEY_CHECKS = 1;
