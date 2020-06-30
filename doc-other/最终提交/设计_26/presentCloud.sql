/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : presentcloud

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 31/05/2020 00:46:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Id` int(11) NOT NULL,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Account` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'zhb', '1', '190327107zhb');
INSERT INTO `admin` VALUES (2, 'lhd', '1', '190327064lhd');
INSERT INTO `admin` VALUES (3, 'csh', '1', '190327022csh');
INSERT INTO `admin` VALUES (4, 'zal', '1', '190327105zal');
INSERT INTO `admin` VALUES (5, 'whc', '1', '190327072whc');
INSERT INTO `admin` VALUES (6, '张三', '2', '88888888zs');
INSERT INTO `admin` VALUES (7, '李四', '2', '88888888ls');
INSERT INTO `admin` VALUES (8, '王五', '2', '88888888ww');

-- ----------------------------
-- Table structure for checkinhistory
-- ----------------------------
DROP TABLE IF EXISTS `checkinhistory`;
CREATE TABLE `checkinhistory`  (
  `Id` int(11) NOT NULL,
  `Start` datetime NULL DEFAULT NULL,
  `Over` datetime NULL DEFAULT NULL,
  `CheckInType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `State` int(11) NULL DEFAULT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`Id`) REFERENCES `userinfo` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for classcoursemember
-- ----------------------------
DROP TABLE IF EXISTS `classcoursemember`;
CREATE TABLE `classcoursemember`  (
  `ClassId` int(11) NOT NULL,
  `StudentName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `StudentId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ClassName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherId` int(11) NULL DEFAULT NULL,
  `Experience` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ClassId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for classlesson
-- ----------------------------
DROP TABLE IF EXISTS `classlesson`;
CREATE TABLE `classlesson`  (
  `ClassId` int(11) NOT NULL,
  `ClassName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TeacherId` int(11) NULL DEFAULT NULL,
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Master` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `People_Count` int(11) NULL DEFAULT NULL,
  `Location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ClassTime` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `College` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `School` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreatTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ClassId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dictionarytype
-- ----------------------------
DROP TABLE IF EXISTS `dictionarytype`;
CREATE TABLE `dictionarytype`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TypeD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Description` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Creator` int(20) NULL DEFAULT NULL,
  `CreatorDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Modifier` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dictionarytype
-- ----------------------------
INSERT INTO `dictionarytype` VALUES (2, '身份', 'role', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionarytype` VALUES (20, '性别', 'sexy', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for directorydata
-- ----------------------------
DROP TABLE IF EXISTS `directorydata`;
CREATE TABLE `directorydata`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TypeD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `KeyD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ValueD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DefaultValueD` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of directorydata
-- ----------------------------
INSERT INTO `directorydata` VALUES (1, 'sexy', 'male', '男', 1);
INSERT INTO `directorydata` VALUES (2, 'sexy', 'female', '女', 0);
INSERT INTO `directorydata` VALUES (3, 'role', 'teacher', '教师', 0);
INSERT INTO `directorydata` VALUES (4, 'role', 'student', '学生', 1);
INSERT INTO `directorydata` VALUES (5, 'role', 'assistant', '助教', 0);

-- ----------------------------
-- Table structure for experience
-- ----------------------------
DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience`  (
  `StudentId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ExperienceValue` int(10) NULL DEFAULT NULL,
  `ClassId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`StudentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `SuperiorMenuNumber` int(100) NULL DEFAULT NULL,
  `MenuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ButtonEnglichlogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ButtonChineselogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IsMenu` int(3) NULL DEFAULT NULL,
  `Creator` int(10) NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Modifier` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '班课频道', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (2, 1, '班课管理', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (3, 1, '加入班级', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (4, 2, '创建班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (5, 2, '班课搜索', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (6, 2, '班课列表排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (8, 3, '班课号加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (9, 3, '二维码加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (10, 1, '班课详情-添加活动', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (11, 10, '发布作业任务', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (12, 10, '查看活动库', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (13, 10, '头脑风暴', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (14, 1, '班课详情-成员', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (15, 14, '发起签到', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (16, 14, '心意卡片', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (17, 14, '小组方案', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (18, 14, '挂科预警', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (19, 14, '切换排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (20, 14, '成员列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (21, 14, '查看成员信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (22, 1, '班课详情-活动', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (23, 22, '活动列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (24, 1, '班课详情-消息', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (25, 1, '班课详情-详情', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (27, 25, '修改信息列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (28, 25, '结束班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (29, 25, '删除班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (30, 25, '编辑班课信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (31, 1, '班课详情-资源', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (32, 1, '班课信息', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (33, 32, '搜索班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (34, 32, '排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (35, 14, '签到', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (36, 25, '退出班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (37, 0, '发现', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (38, 37, '发现-首页', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (39, 38, '二维码加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (40, 37, '发现-课程圈', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (41, 37, '发现-社区', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (42, 0, '我的频道', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (43, 42, '我的频道-首页', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (44, 43, '个人信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (49, 42, '我的频道-设置', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (50, 49, '关联手机', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (51, 49, '关联邮箱', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (52, 49, '修改密码', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (53, 49, '查看用户协议', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (54, 49, '查看隐私政策', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (55, 49, '查看关于我们', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (56, 49, '缓存管理', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (57, 49, '检查更新', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (58, 49, '反馈、投诉与建议', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (59, 49, '隐私设计', NULL, NULL, 3, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `SuperiorMenuNumber` int(100) NULL DEFAULT NULL,
  `MenuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ButtonEnglishlogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ButtonChineselogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IsMenu` int(3) NULL DEFAULT NULL,
  `Creator` int(10) NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Modifier` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 0, '班课频道', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (2, 1, '班课管理', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (3, 1, '加入班级', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (4, 2, '创建班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (5, 2, '班课搜索', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (6, 2, '班课列表排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (7, 2, '查看列表班课信息', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (8, 3, '班课号加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (9, 3, '二维码加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (10, 1, '班课详情-添加活动', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (11, 10, '发布作业任务', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (12, 10, '查看活动库', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (13, 10, '头脑风暴', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (14, 1, '班课详情-成员', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (15, 14, '发起签到', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (16, 14, '心意卡片', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (17, 14, '小组方案', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (18, 14, '挂科预警', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (19, 14, '切换排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (20, 14, '成员列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (21, 14, '查看成员信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (22, 1, '班课详情-活动', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (23, 22, '活动列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (24, 1, '班课详情-消息', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (25, 1, '班课详情-详情', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (26, 25, '信息列表', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (27, 25, '修改信息列表', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (28, 25, '结束班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (29, 25, '删除班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (30, 25, '编辑班课信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (31, 1, '班课详情-资源', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (32, 1, '班课信息', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (33, 32, '搜索班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (34, 32, '排序', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (35, 14, '签到', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (36, 25, '退出班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (37, 0, '发现', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (38, 37, '发现-首页', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (39, 38, '扫码加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (40, 37, '发现-课程圈', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (41, 37, '发现-社区', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (42, 0, '我的频道', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (43, 42, '我的频道-首页', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (44, 43, '个人信息', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (45, 44, '经验值', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (46, 44, '魅力值', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (47, 44, '蓝豆', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (48, 44, '心意', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (49, 42, '我的频道-设置', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (50, 49, '关联手机', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (51, 49, '关联邮箱', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (52, 49, '修改密码', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (53, 49, '查看用户协议', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (54, 49, '查看隐私政策', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (55, 49, '查看关于我们', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (56, 49, '缓存管理', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (57, 49, '检查更新', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (58, 49, '反馈、投诉与建议', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (59, 49, '隐私设计', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (60, 44, '查看经验值', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (61, 44, '查看签到数', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (62, 44, '查看解答数', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (63, 44, '查看点赞数', NULL, NULL, 4, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MenuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '教师', NULL);
INSERT INTO `role` VALUES (19, '助教', NULL);
INSERT INTO `role` VALUES (20, '学生', NULL);

-- ----------------------------
-- Table structure for rolemenu
-- ----------------------------
DROP TABLE IF EXISTS `rolemenu`;
CREATE TABLE `rolemenu`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 158 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rolemenu
-- ----------------------------
INSERT INTO `rolemenu` VALUES (1, '学生', '班课频道');
INSERT INTO `rolemenu` VALUES (2, '学生', '加入班级');
INSERT INTO `rolemenu` VALUES (3, '学生', '班课号加入班级');
INSERT INTO `rolemenu` VALUES (4, '学生', '二维码加入班级');
INSERT INTO `rolemenu` VALUES (5, '学生', '班课信息');
INSERT INTO `rolemenu` VALUES (6, '学生', '搜索班课');
INSERT INTO `rolemenu` VALUES (7, '学生', '排序');
INSERT INTO `rolemenu` VALUES (8, '学生', '班课详情-成员');
INSERT INTO `rolemenu` VALUES (9, '学生', '签到');
INSERT INTO `rolemenu` VALUES (10, '学生', '心意卡片');
INSERT INTO `rolemenu` VALUES (11, '学生', '小组方案');
INSERT INTO `rolemenu` VALUES (12, '学生', '切换排序');
INSERT INTO `rolemenu` VALUES (13, '学生', '成员列表');
INSERT INTO `rolemenu` VALUES (14, '学生', '班课详情-活动');
INSERT INTO `rolemenu` VALUES (15, '学生', '活动列表');
INSERT INTO `rolemenu` VALUES (16, '学生', '班课详情-消息');
INSERT INTO `rolemenu` VALUES (17, '学生', '班课详情-详情');
INSERT INTO `rolemenu` VALUES (18, '学生', '信息列表');
INSERT INTO `rolemenu` VALUES (19, '学生', '修改信息列表');
INSERT INTO `rolemenu` VALUES (20, '学生', '退出班课');
INSERT INTO `rolemenu` VALUES (21, '学生', '班课详情-资源');
INSERT INTO `rolemenu` VALUES (22, '学生', '发现');
INSERT INTO `rolemenu` VALUES (23, '学生', '发现-首页');
INSERT INTO `rolemenu` VALUES (24, '学生', '二维码加入班课');
INSERT INTO `rolemenu` VALUES (25, '学生', '发现-课程圈');
INSERT INTO `rolemenu` VALUES (26, '学生', '发现-社区');
INSERT INTO `rolemenu` VALUES (27, '学生', '我的频道');
INSERT INTO `rolemenu` VALUES (28, '学生', '我的频道-首页');
INSERT INTO `rolemenu` VALUES (29, '学生', '个人信息');
INSERT INTO `rolemenu` VALUES (30, '学生', '查看经验值');
INSERT INTO `rolemenu` VALUES (31, '学生', '查看签到数');
INSERT INTO `rolemenu` VALUES (32, '学生', '查看解答数');
INSERT INTO `rolemenu` VALUES (33, '学生', '查看点赞数');
INSERT INTO `rolemenu` VALUES (34, '学生', '我的频道-设置');
INSERT INTO `rolemenu` VALUES (35, '学生', '关联手机');
INSERT INTO `rolemenu` VALUES (36, '学生', '关联邮箱');
INSERT INTO `rolemenu` VALUES (37, '学生', '修改密码');
INSERT INTO `rolemenu` VALUES (38, '学生', '查看用户协议');
INSERT INTO `rolemenu` VALUES (39, '学生', '查看隐私政策');
INSERT INTO `rolemenu` VALUES (40, '学生', '查看关于我们');
INSERT INTO `rolemenu` VALUES (41, '学生', '缓存管理');
INSERT INTO `rolemenu` VALUES (42, '学生', '检查更新');
INSERT INTO `rolemenu` VALUES (43, '学生', '反馈、投诉与建议');
INSERT INTO `rolemenu` VALUES (44, '学生', '隐私设计');
INSERT INTO `rolemenu` VALUES (45, '学生', '发现-社区');
INSERT INTO `rolemenu` VALUES (46, '教师', '班课频道');
INSERT INTO `rolemenu` VALUES (47, '教师', '班课管理');
INSERT INTO `rolemenu` VALUES (48, '教师', '创建班课');
INSERT INTO `rolemenu` VALUES (49, '教师', '班课搜索');
INSERT INTO `rolemenu` VALUES (50, '教师', '班课列表排序');
INSERT INTO `rolemenu` VALUES (51, '教师', '查看列表班课信息');
INSERT INTO `rolemenu` VALUES (52, '教师', '班课详情-添加活动');
INSERT INTO `rolemenu` VALUES (53, '教师', '发布作业任务');
INSERT INTO `rolemenu` VALUES (54, '教师', '查看活动库');
INSERT INTO `rolemenu` VALUES (55, '教师', '头脑风暴');
INSERT INTO `rolemenu` VALUES (56, '教师', '班课详情-成员');
INSERT INTO `rolemenu` VALUES (57, '教师', '发起签到');
INSERT INTO `rolemenu` VALUES (58, '教师', '心意卡片');
INSERT INTO `rolemenu` VALUES (59, '教师', '小组方案');
INSERT INTO `rolemenu` VALUES (60, '教师', '挂科预警');
INSERT INTO `rolemenu` VALUES (61, '教师', '切换排序');
INSERT INTO `rolemenu` VALUES (62, '教师', '成员列表');
INSERT INTO `rolemenu` VALUES (63, '教师', '查看成员信息');
INSERT INTO `rolemenu` VALUES (64, '教师', '班课详情-活动');
INSERT INTO `rolemenu` VALUES (65, '教师', '活动列表');
INSERT INTO `rolemenu` VALUES (66, '教师', '班课详情-消息');
INSERT INTO `rolemenu` VALUES (67, '教师', '班课详情-详情');
INSERT INTO `rolemenu` VALUES (68, '教师', '信息列表');
INSERT INTO `rolemenu` VALUES (69, '教师', '修改信息列表');
INSERT INTO `rolemenu` VALUES (70, '教师', '结束班课');
INSERT INTO `rolemenu` VALUES (71, '教师', '删除班课');
INSERT INTO `rolemenu` VALUES (72, '教师', '编辑班课信息');
INSERT INTO `rolemenu` VALUES (73, '教师', '班课详情-资源');
INSERT INTO `rolemenu` VALUES (74, '教师', '发现');
INSERT INTO `rolemenu` VALUES (75, '教师', '发现-首页');
INSERT INTO `rolemenu` VALUES (76, '教师', '扫码加入班课');
INSERT INTO `rolemenu` VALUES (77, '教师', '发现-课程圈');
INSERT INTO `rolemenu` VALUES (78, '教师', '发现-社区');
INSERT INTO `rolemenu` VALUES (79, '教师', '我的频道');
INSERT INTO `rolemenu` VALUES (80, '教师', '我的频道-首页');
INSERT INTO `rolemenu` VALUES (81, '教师', '个人信息');
INSERT INTO `rolemenu` VALUES (82, '教师', '经验值');
INSERT INTO `rolemenu` VALUES (83, '教师', '魅力值');
INSERT INTO `rolemenu` VALUES (84, '教师', '蓝豆');
INSERT INTO `rolemenu` VALUES (85, '教师', '心意');
INSERT INTO `rolemenu` VALUES (86, '教师', '我的频道-设置');
INSERT INTO `rolemenu` VALUES (87, '教师', '关联手机');
INSERT INTO `rolemenu` VALUES (88, '教师', '关联邮箱');
INSERT INTO `rolemenu` VALUES (89, '教师', '修改密码');
INSERT INTO `rolemenu` VALUES (90, '教师', '查看用户协议');
INSERT INTO `rolemenu` VALUES (91, '教师', '查看隐私政策');
INSERT INTO `rolemenu` VALUES (92, '教师', '查看关于我们');
INSERT INTO `rolemenu` VALUES (93, '教师', '缓存管理');
INSERT INTO `rolemenu` VALUES (94, '教师', '检查更新');
INSERT INTO `rolemenu` VALUES (95, '教师', '反馈、投诉与建议');
INSERT INTO `rolemenu` VALUES (96, '教师', '隐私设计');
INSERT INTO `rolemenu` VALUES (155, '教师', '签到');
INSERT INTO `rolemenu` VALUES (156, '教师', '班课信息');
INSERT INTO `rolemenu` VALUES (157, '教师', '搜索班课');

-- ----------------------------
-- Table structure for signin
-- ----------------------------
DROP TABLE IF EXISTS `signin`;
CREATE TABLE `signin`  (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `SignInType` int(11) NULL DEFAULT NULL,
  `EndTime` datetime NULL DEFAULT NULL,
  `Publisher` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ClassId` int(11) NULL DEFAULT NULL,
  `StartTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_4`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`UserId`) REFERENCES `userinfo` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for systemparameter
-- ----------------------------
DROP TABLE IF EXISTS `systemparameter`;
CREATE TABLE `systemparameter`  (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of systemparameter
-- ----------------------------
INSERT INTO `systemparameter` VALUES (1, '经验值', '3');
INSERT INTO `systemparameter` VALUES (2, '魅力值', '2');
INSERT INTO `systemparameter` VALUES (3, '蓝豆', '1');
INSERT INTO `systemparameter` VALUES (4, '心意', '1');
INSERT INTO `systemparameter` VALUES (5, '距离', '100m');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `Grade` int(11) NULL DEFAULT NULL,
  `Answer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GradePoint` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Task` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ClassId` int(11) NULL DEFAULT NULL,
  `Team` int(11) NULL DEFAULT NULL,
  `ScoringMethod` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LastSubmitTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_5`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`UserId`) REFERENCES `userinfo` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for taskmemory
-- ----------------------------
DROP TABLE IF EXISTS `taskmemory`;
CREATE TABLE `taskmemory`  (
  `Id` int(11) NOT NULL,
  `StudentId` int(11) NOT NULL,
  `IsParticipate` int(11) NULL DEFAULT NULL,
  `Grade` int(11) NULL DEFAULT NULL,
  `Anser` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GradePoint` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Task` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ClassId` int(11) NULL DEFAULT NULL,
  `Team` int(11) NULL DEFAULT NULL,
  `ScoringMethod` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LastSubmitTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_6`(`StudentId`) USING BTREE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`StudentId`) REFERENCES `userinfo` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `tokenId` int(20) NOT NULL,
  `userId` int(20) NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buildTime` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`tokenId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for usercheck
-- ----------------------------
DROP TABLE IF EXISTS `usercheck`;
CREATE TABLE `usercheck`  (
  `Id` int(11) NOT NULL,
  `Fk_UserInfo_UserCheck_Id` int(11) NULL DEFAULT NULL,
  `Type` int(11) NULL DEFAULT NULL,
  `ThirdParty` int(11) NULL DEFAULT NULL,
  `Identifier` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PasswordToken` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `Creater` int(11) NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Modifier` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_1`(`Fk_UserInfo_UserCheck_Id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`Fk_UserInfo_UserCheck_Id`) REFERENCES `userinfo` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Image` mediumblob NULL,
  `NickName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Birthday` datetime NULL DEFAULT NULL,
  `Sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `School` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Master` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Creator` int(11) NULL DEFAULT NULL,
  `Modifier` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`, `Number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (2, '190327201', 'xxx123', '张三', NULL, '李四', NULL, '男', '福州大学', '数学与计算机科学学院', '教师', '18965151839', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
