/*
 Navicat Premium Data Transfer

 Source Server         : 47.112.239.108_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 47.112.239.108:3306
 Source Schema         : presentcloud

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 03/07/2020 18:08:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Account` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`, `Name`) USING BTREE,
  UNIQUE INDEX `Name`(`Name`) USING BTREE,
  UNIQUE INDEX `Phone`(`Phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'zhb', '1', 'a5e0d9e972644a253937b4563dfee578d43614b6a48191df41a6781148ab748f', '18965151839');
INSERT INTO `admin` VALUES (2, 'lhd', '1', '643df07dec7401467aa28979cad56b2accd8a78b6e276ef47fa30d09f7efd0fe', '18965151840');
INSERT INTO `admin` VALUES (3, 'csh', '1', 'e419730f7f23272873ebc12a062b7e16147721a806c93f84e46760976475c452', '18965151841');
INSERT INTO `admin` VALUES (4, 'zal', '1', '60f625a863f0107e35f487259618ca05f4555428f4d1414b190c32ddfc19dd51', '18965151842');
INSERT INTO `admin` VALUES (5, 'whc', '1', '48d653e5aab1feca4c22d93721fafbcb37091b913ef841240ea8a9ae805edb87', '18965151843');
INSERT INTO `admin` VALUES (8, '王五', '2', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '18965151844');
INSERT INTO `admin` VALUES (12, '张三', '2', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '18965151845');
INSERT INTO `admin` VALUES (29, '小王', '2', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '12121211111');

-- ----------------------------
-- Table structure for checkinhistory
-- ----------------------------
DROP TABLE IF EXISTS `checkinhistory`;
CREATE TABLE `checkinhistory`  (
  `Id` int(11) NOT NULL,
  `Start` datetime DEFAULT NULL,
  `Over` datetime DEFAULT NULL,
  `CheckInType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of checkinhistory
-- ----------------------------
INSERT INTO `checkinhistory` VALUES (5, '2020-06-28 11:57:47', '2020-06-29 19:38:30', '1', '190327014', 1, '1');
INSERT INTO `checkinhistory` VALUES (5, '2020-06-28 11:57:47', '2020-06-29 20:36:51', '2', '190327104', 1, '1');
INSERT INTO `checkinhistory` VALUES (8, '2020-06-30 14:12:33', '2020-06-30 14:57:15', '1', '190327014', 1, '231240');
INSERT INTO `checkinhistory` VALUES (8, '2020-06-30 14:12:33', '2020-06-30 14:57:55', '1', '190327014', 1, '231240');
INSERT INTO `checkinhistory` VALUES (8, '2020-06-30 14:12:33', '2020-06-30 15:00:11', '1', '190327014', 1, '231240');
INSERT INTO `checkinhistory` VALUES (8, '2020-06-30 14:12:33', '2020-06-30 15:01:31', '1', '190327014', 1, '231240');
INSERT INTO `checkinhistory` VALUES (9, '2020-06-30 15:19:22', '2020-06-30 15:35:55', '2', '190327014', 1, '231240');
INSERT INTO `checkinhistory` VALUES (16, '2020-07-01 11:40:36', '2020-07-01 12:13:00', '2', '190327014', 1, '231242');
INSERT INTO `checkinhistory` VALUES (18, '2020-07-01 15:04:52', '2020-07-01 15:05:18', '2', '190327014', 1, '231242');
INSERT INTO `checkinhistory` VALUES (24, '2020-07-01 16:05:56', '2020-07-01 16:06:12', '1', '190327014', 1, '231242');
INSERT INTO `checkinhistory` VALUES (25, '2020-07-01 16:08:54', '2020-07-01 16:09:05', '2', '190327014', 1, '231242');
INSERT INTO `checkinhistory` VALUES (26, '2020-07-01 16:13:19', '2020-07-01 16:13:33', '2', '190327014', 1, '231243');
INSERT INTO `checkinhistory` VALUES (27, '2020-07-01 16:13:53', '2020-07-01 16:13:57', '1', '190327014', 1, '231243');
INSERT INTO `checkinhistory` VALUES (28, '2020-07-02 20:57:05', '2020-07-02 20:57:22', '1', '190327014', 1, '231249');
INSERT INTO `checkinhistory` VALUES (37, '2020-07-02 21:44:13', '2020-07-02 21:45:27', '1', '190327014', 1, '231249');
INSERT INTO `checkinhistory` VALUES (38, '2020-07-02 21:46:13', '2020-07-02 21:46:35', '2', '190327014', 1, '231249');
INSERT INTO `checkinhistory` VALUES (39, '2020-07-02 21:50:26', '2020-07-02 21:52:52', '2', '190327014', 1, '231249');
INSERT INTO `checkinhistory` VALUES (40, '2020-07-02 22:24:29', '2020-07-02 22:24:46', '1', '190327014', 1, '3');
INSERT INTO `checkinhistory` VALUES (40, '2020-07-02 22:24:29', '2020-07-02 22:25:06', '1', '190327072', 1, '3');
INSERT INTO `checkinhistory` VALUES (41, '2020-07-02 22:43:08', '2020-07-02 22:43:37', '2', '190327064', 1, '3');
INSERT INTO `checkinhistory` VALUES (41, '2020-07-02 22:43:08', '2020-07-02 22:43:58', '2', '190327014', 1, '3');
INSERT INTO `checkinhistory` VALUES (41, '2020-07-02 22:43:08', '2020-07-02 22:47:42', '2', '190327072', 1, '3');

-- ----------------------------
-- Table structure for classcoursemember
-- ----------------------------
DROP TABLE IF EXISTS `classcoursemember`;
CREATE TABLE `classcoursemember`  (
  `ClassId` int(11) NOT NULL,
  `StudentName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `StudentId` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ClassName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TeacherName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  `Experience` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classcoursemember
-- ----------------------------
INSERT INTO `classcoursemember` VALUES (231240, '黎明', '190327014', '测试', '张三', 190327201, 0);
INSERT INTO `classcoursemember` VALUES (231245, '黎明', '190327014', '云计算', '张三', 190327201, 10);
INSERT INTO `classcoursemember` VALUES (231249, '黎明', '190327014', '设计', '张三', 190327201, 18);
INSERT INTO `classcoursemember` VALUES (3, '王海朝', '190327072', '密码学', '张三', 190327201, 14);
INSERT INTO `classcoursemember` VALUES (3, '小池', '190327094', '密码学', '张三', 190327201, 0);
INSERT INTO `classcoursemember` VALUES (3, '黎明', '190327014', '密码学', '张三', 190327201, 14);
INSERT INTO `classcoursemember` VALUES (3, '柳煌达', '190327064', '密码学', '张三', 190327201, 2);
INSERT INTO `classcoursemember` VALUES (233, '庄', '190327107', '测试班课1', '池芝标', 190327113, 2);
INSERT INTO `classcoursemember` VALUES (233, '柳', '190327108', '测试班课1', '池芝标', 190327113, 0);
INSERT INTO `classcoursemember` VALUES (233, '王', '190327109', '测试班课1', '池芝标', 190327113, 1);

-- ----------------------------
-- Table structure for classlesson
-- ----------------------------
DROP TABLE IF EXISTS `classlesson`;
CREATE TABLE `classlesson`  (
  `ClassId` int(11) NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TeacherName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Master` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `People_Count` int(11) DEFAULT NULL,
  `Location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ClassTime` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `College` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `School` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CreatTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ClassId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 231250 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classlesson
-- ----------------------------
INSERT INTO `classlesson` VALUES (1, '2', '池指标', 190327113, NULL, NULL, NULL, NULL, '2020-2021-2', '音乐学院', '福建师范大学', '2020-07-02 12:13:17');
INSERT INTO `classlesson` VALUES (2, '高等数学', '张三', 190327201, 'over', NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-06-26 09:30:11');
INSERT INTO `classlesson` VALUES (3, '密码学', '张三', 190327201, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', NULL);
INSERT INTO `classlesson` VALUES (4, '三国', '张三', 2, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-06-26 21:50:06');
INSERT INTO `classlesson` VALUES (10, '中特', '张三', 2, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-06-26 21:57:49');
INSERT INTO `classlesson` VALUES (11, '工程英语', '张三', 2, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-06-26 22:03:17');
INSERT INTO `classlesson` VALUES (111, 'test', '池芝标', 190327113, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-07-02 12:17:20');
INSERT INTO `classlesson` VALUES (233, '测试班课1', '池芝标', 190327113, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-07-02 01:55:20');
INSERT INTO `classlesson` VALUES (2323, '测试班课2', '池芝标', 190327113, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-07-02 01:57:22');
INSERT INTO `classlesson` VALUES (121212, '测试班课3', '池芝标', 190327113, NULL, NULL, NULL, NULL, '2020-2021-2', '数学与计算机科学学院', '福州大学', '2020-07-02 01:59:35');
INSERT INTO `classlesson` VALUES (231249, '设计', '张三', 190327201, NULL, '工程实训', NULL, NULL, '2020-2021-2', '数计学院', '福州大学', '2020-07-02 20:16:31');

-- ----------------------------
-- Table structure for dictionarytype
-- ----------------------------
DROP TABLE IF EXISTS `dictionarytype`;
CREATE TABLE `dictionarytype`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `TypeD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Description` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Creator` int(20) DEFAULT NULL,
  `CreatorDate` datetime DEFAULT NULL,
  `ModificationDate` datetime DEFAULT NULL,
  `Modifier` int(20) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `TypeD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `KeyD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ValueD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DefaultValueD` int(1) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ExperienceValue` int(10) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  PRIMARY KEY (`StudentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `Id` int(100) NOT NULL AUTO_INCREMENT,
  `SuperiorMenuNumber` int(100) DEFAULT NULL,
  `MenuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ButtonEnglichlogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ButtonChineselogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IsMenu` int(3) DEFAULT NULL,
  `Creator` int(10) DEFAULT NULL,
  `CreationDate` datetime DEFAULT NULL,
  `ModificationDate` datetime DEFAULT NULL,
  `Modifier` int(10) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `menu` VALUES (35, 14, '签到', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (36, 25, '退出班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (37, 0, '发现', NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (38, 37, '发现-首页', NULL, NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (39, 38, '扫码加入班课', NULL, NULL, 3, NULL, NULL, NULL, NULL);
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
  `SuperiorMenuNumber` int(100) DEFAULT NULL,
  `MenuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ButtonEnglishlogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ButtonChineselogo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IsMenu` int(3) DEFAULT NULL,
  `Creator` int(10) DEFAULT NULL,
  `CreationDate` datetime DEFAULT NULL,
  `ModificationDate` datetime DEFAULT NULL,
  `Modifier` int(10) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `permission` VALUES (61, 44, '签到数', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (62, 44, '解答数', NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (63, 44, '查看点赞数', NULL, NULL, 4, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `MenuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `menu` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 486 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `rolemenu` VALUES (24, '学生', '扫码加入班课');
INSERT INTO `rolemenu` VALUES (25, '学生', '发现-课程圈');
INSERT INTO `rolemenu` VALUES (26, '学生', '发现-社区');
INSERT INTO `rolemenu` VALUES (27, '学生', '我的频道');
INSERT INTO `rolemenu` VALUES (28, '学生', '我的频道-首页');
INSERT INTO `rolemenu` VALUES (29, '学生', '个人信息');
INSERT INTO `rolemenu` VALUES (30, '学生', '查看经验值');
INSERT INTO `rolemenu` VALUES (31, '学生', '签到数');
INSERT INTO `rolemenu` VALUES (32, '学生', '解答数');
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
INSERT INTO `rolemenu` VALUES (382, '助教', '班课频道');
INSERT INTO `rolemenu` VALUES (383, '助教', '班课管理');
INSERT INTO `rolemenu` VALUES (384, '助教', '班课搜索');
INSERT INTO `rolemenu` VALUES (385, '助教', '班课列表排序');
INSERT INTO `rolemenu` VALUES (386, '助教', '查看列表班课信息');
INSERT INTO `rolemenu` VALUES (387, '助教', '班课详情-添加活动');
INSERT INTO `rolemenu` VALUES (388, '助教', '发布作业任务');
INSERT INTO `rolemenu` VALUES (389, '助教', '查看活动库');
INSERT INTO `rolemenu` VALUES (390, '助教', '头脑风暴');
INSERT INTO `rolemenu` VALUES (391, '助教', '班课详情-成员');
INSERT INTO `rolemenu` VALUES (392, '助教', '发起签到');
INSERT INTO `rolemenu` VALUES (393, '助教', '心意卡片');
INSERT INTO `rolemenu` VALUES (394, '助教', '小组方案');
INSERT INTO `rolemenu` VALUES (395, '助教', '挂科预警');
INSERT INTO `rolemenu` VALUES (396, '助教', '切换排序');
INSERT INTO `rolemenu` VALUES (397, '助教', '成员列表');
INSERT INTO `rolemenu` VALUES (398, '助教', '查看成员信息');
INSERT INTO `rolemenu` VALUES (399, '助教', '班课详情-活动');
INSERT INTO `rolemenu` VALUES (400, '助教', '活动列表');
INSERT INTO `rolemenu` VALUES (401, '助教', '班课详情-消息');
INSERT INTO `rolemenu` VALUES (402, '助教', '班课详情-详情');
INSERT INTO `rolemenu` VALUES (403, '助教', '信息列表');
INSERT INTO `rolemenu` VALUES (404, '助教', '修改信息列表');
INSERT INTO `rolemenu` VALUES (405, '助教', '结束班课');
INSERT INTO `rolemenu` VALUES (406, '助教', '编辑班课信息');
INSERT INTO `rolemenu` VALUES (407, '助教', '退出班课');
INSERT INTO `rolemenu` VALUES (408, '助教', '班课详情-资源');
INSERT INTO `rolemenu` VALUES (409, '助教', '班课信息');
INSERT INTO `rolemenu` VALUES (410, '助教', '搜索班课');
INSERT INTO `rolemenu` VALUES (411, '助教', '排序');
INSERT INTO `rolemenu` VALUES (412, '助教', '发现');
INSERT INTO `rolemenu` VALUES (413, '助教', '发现-课程圈');
INSERT INTO `rolemenu` VALUES (414, '助教', '发现-社区');
INSERT INTO `rolemenu` VALUES (415, '助教', '我的频道');
INSERT INTO `rolemenu` VALUES (416, '助教', '我的频道-首页');
INSERT INTO `rolemenu` VALUES (417, '助教', '我的频道-设置');
INSERT INTO `rolemenu` VALUES (418, '助教', '关联手机');
INSERT INTO `rolemenu` VALUES (419, '助教', '个人信息');
INSERT INTO `rolemenu` VALUES (420, '助教', '关联邮箱');
INSERT INTO `rolemenu` VALUES (421, '助教', '修改密码');
INSERT INTO `rolemenu` VALUES (422, '助教', '查看用户协议');
INSERT INTO `rolemenu` VALUES (423, '助教', '查看隐私政策');
INSERT INTO `rolemenu` VALUES (424, '助教', '查看关于我们');
INSERT INTO `rolemenu` VALUES (425, '助教', '缓存管理');
INSERT INTO `rolemenu` VALUES (426, '助教', '检查更新');
INSERT INTO `rolemenu` VALUES (427, '助教', '反馈、投诉与建议');
INSERT INTO `rolemenu` VALUES (428, '助教', '隐私设计');
INSERT INTO `rolemenu` VALUES (429, '助教', '经验值');
INSERT INTO `rolemenu` VALUES (430, '助教', '魅力值');
INSERT INTO `rolemenu` VALUES (431, '助教', '蓝豆');
INSERT INTO `rolemenu` VALUES (432, '助教', '心意');
INSERT INTO `rolemenu` VALUES (433, '教师', '班课频道');
INSERT INTO `rolemenu` VALUES (434, '教师', '班课管理');
INSERT INTO `rolemenu` VALUES (435, '教师', '创建班课');
INSERT INTO `rolemenu` VALUES (436, '教师', '班课搜索');
INSERT INTO `rolemenu` VALUES (437, '教师', '班课列表排序');
INSERT INTO `rolemenu` VALUES (438, '教师', '查看列表班课信息');
INSERT INTO `rolemenu` VALUES (439, '教师', '班课详情-添加活动');
INSERT INTO `rolemenu` VALUES (440, '教师', '发布作业任务');
INSERT INTO `rolemenu` VALUES (441, '教师', '查看活动库');
INSERT INTO `rolemenu` VALUES (442, '教师', '头脑风暴');
INSERT INTO `rolemenu` VALUES (443, '教师', '班课详情-成员');
INSERT INTO `rolemenu` VALUES (444, '教师', '发起签到');
INSERT INTO `rolemenu` VALUES (445, '教师', '心意卡片');
INSERT INTO `rolemenu` VALUES (446, '教师', '小组方案');
INSERT INTO `rolemenu` VALUES (447, '教师', '挂科预警');
INSERT INTO `rolemenu` VALUES (448, '教师', '切换排序');
INSERT INTO `rolemenu` VALUES (449, '教师', '成员列表');
INSERT INTO `rolemenu` VALUES (450, '教师', '查看成员信息');
INSERT INTO `rolemenu` VALUES (451, '教师', '班课详情-活动');
INSERT INTO `rolemenu` VALUES (452, '教师', '活动列表');
INSERT INTO `rolemenu` VALUES (453, '教师', '班课详情-消息');
INSERT INTO `rolemenu` VALUES (454, '教师', '班课详情-详情');
INSERT INTO `rolemenu` VALUES (455, '教师', '信息列表');
INSERT INTO `rolemenu` VALUES (456, '教师', '修改信息列表');
INSERT INTO `rolemenu` VALUES (457, '教师', '结束班课');
INSERT INTO `rolemenu` VALUES (458, '教师', '删除班课');
INSERT INTO `rolemenu` VALUES (459, '教师', '编辑班课信息');
INSERT INTO `rolemenu` VALUES (460, '教师', '班课详情-资源');
INSERT INTO `rolemenu` VALUES (461, '教师', '发现');
INSERT INTO `rolemenu` VALUES (462, '教师', '发现-首页');
INSERT INTO `rolemenu` VALUES (463, '教师', '扫码加入班课');
INSERT INTO `rolemenu` VALUES (464, '教师', '发现-课程圈');
INSERT INTO `rolemenu` VALUES (465, '教师', '发现-社区');
INSERT INTO `rolemenu` VALUES (466, '教师', '我的频道');
INSERT INTO `rolemenu` VALUES (467, '教师', '我的频道-首页');
INSERT INTO `rolemenu` VALUES (468, '教师', '个人信息');
INSERT INTO `rolemenu` VALUES (469, '教师', '经验值');
INSERT INTO `rolemenu` VALUES (470, '教师', '魅力值');
INSERT INTO `rolemenu` VALUES (471, '教师', '蓝豆');
INSERT INTO `rolemenu` VALUES (472, '教师', '心意');
INSERT INTO `rolemenu` VALUES (473, '教师', '我的频道-设置');
INSERT INTO `rolemenu` VALUES (474, '教师', '关联手机');
INSERT INTO `rolemenu` VALUES (475, '教师', '关联邮箱');
INSERT INTO `rolemenu` VALUES (476, '教师', '修改密码');
INSERT INTO `rolemenu` VALUES (477, '教师', '查看用户协议');
INSERT INTO `rolemenu` VALUES (478, '教师', '查看隐私政策');
INSERT INTO `rolemenu` VALUES (479, '教师', '查看关于我们');
INSERT INTO `rolemenu` VALUES (480, '教师', '缓存管理');
INSERT INTO `rolemenu` VALUES (481, '教师', '检查更新');
INSERT INTO `rolemenu` VALUES (482, '教师', '反馈、投诉与建议');
INSERT INTO `rolemenu` VALUES (483, '教师', '隐私设计');
INSERT INTO `rolemenu` VALUES (484, '教师', '签到');
INSERT INTO `rolemenu` VALUES (485, '教师', '班课信息');

-- ----------------------------
-- Table structure for signin
-- ----------------------------
DROP TABLE IF EXISTS `signin`;
CREATE TABLE `signin`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `SignInType` int(11) DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `Publisher` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `StartTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_4`(`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of signin
-- ----------------------------
INSERT INTO `signin` VALUES (1, 2, 1, '2020-06-30 21:42:25', '张三', 1, '2020-06-21 21:42:18');
INSERT INTO `signin` VALUES (2, 190327201, 1, '2020-06-28 10:27:08', '210,140', 1, '2020-06-28 10:09:59');
INSERT INTO `signin` VALUES (3, 190327201, 1, '2020-06-28 11:54:54', '210,140', 1, '2020-06-28 10:18:17');
INSERT INTO `signin` VALUES (4, 190327201, 2, '2020-06-28 10:52:31', '210,140,1-5-9-3-4-6', 1, '2020-06-28 10:50:58');
INSERT INTO `signin` VALUES (5, 190327201, 2, NULL, '210,140,1-5-9-3-4-6', 1, '2020-06-28 11:57:47');
INSERT INTO `signin` VALUES (6, 190327201, 1, NULL, '210,140', 231240, '2020-06-29 23:12:11');
INSERT INTO `signin` VALUES (7, 190327201, 1, '2020-06-29 23:17:36', '210,140', 231240, '2020-06-29 23:17:33');
INSERT INTO `signin` VALUES (8, 190327201, 1, NULL, '210,140', 231240, '2020-06-30 14:12:33');
INSERT INTO `signin` VALUES (9, 190327201, 2, '2020-06-30 15:42:55', '210,140,1-2-3', 231240, '2020-06-30 15:19:22');
INSERT INTO `signin` VALUES (10, 190327201, 2, '2020-06-30 22:40:18', '210,140,1-2-3-6-9', 231240, '2020-06-30 22:39:54');
INSERT INTO `signin` VALUES (11, 190327201, 1, '2020-06-30 22:40:54', '210,140', 231240, '2020-06-30 22:40:22');
INSERT INTO `signin` VALUES (12, 190327201, 2, '2020-06-30 22:41:28', '210,140,1-4-7', 231240, '2020-06-30 22:41:17');
INSERT INTO `signin` VALUES (13, 190327201, 2, '2020-06-30 22:47:12', '210,140,1-2-3', 231240, '2020-06-30 22:46:39');
INSERT INTO `signin` VALUES (14, 190327201, 1, '2020-06-30 22:47:31', '210,140', 231240, '2020-06-30 22:47:15');
INSERT INTO `signin` VALUES (15, 190327201, 1, '2020-07-01 11:38:26', '210,140', 231242, '2020-07-01 11:37:51');
INSERT INTO `signin` VALUES (16, 190327201, 2, NULL, '210,140,1-2-3-5-7-8-9', 231242, '2020-07-01 11:40:36');
INSERT INTO `signin` VALUES (17, 190327201, 1, '2020-07-01 15:04:45', '210,140', 231242, '2020-07-01 15:03:22');
INSERT INTO `signin` VALUES (18, 190327201, 2, '2020-07-01 15:07:29', '210,140,1-2-3', 231242, '2020-07-01 15:04:52');
INSERT INTO `signin` VALUES (19, 190327201, 1, '2020-07-01 15:15:25', '210,140', 231242, '2020-07-01 15:15:17');
INSERT INTO `signin` VALUES (20, 190327201, 1, '2020-07-01 15:18:00', '210,140', 231242, '2020-07-01 15:15:31');
INSERT INTO `signin` VALUES (21, 190327201, 1, '2020-07-01 15:23:38', '210,140', 231242, '2020-07-01 15:18:17');
INSERT INTO `signin` VALUES (22, 190327201, 1, '2020-07-01 15:55:47', '210,140', 231242, '2020-07-01 15:55:31');
INSERT INTO `signin` VALUES (23, 190327201, 1, NULL, '210,140', 231242, '2020-07-01 15:58:15');
INSERT INTO `signin` VALUES (24, 190327201, 1, NULL, '119.655711,26.956937', 231242, '2020-07-01 16:05:56');
INSERT INTO `signin` VALUES (25, 190327201, 2, '2020-07-01 16:09:16', '119.655715,26.956888,1-2-3', 231242, '2020-07-01 16:08:54');
INSERT INTO `signin` VALUES (26, 190327201, 2, '2020-07-01 16:13:47', '119.655713,26.956866,1-2-3-6-9', 231243, '2020-07-01 16:13:19');
INSERT INTO `signin` VALUES (27, 190327201, 1, '2020-07-01 16:14:07', '119.655712,26.956878', 231243, '2020-07-01 16:13:53');
INSERT INTO `signin` VALUES (28, 190327201, 1, '2020-07-02 20:57:27', '118.906018,24.95725', 231249, '2020-07-02 20:57:05');
INSERT INTO `signin` VALUES (29, 190327201, 2, '2020-07-02 21:02:45', '118.905971,24.960699,1-2-3', 1, '2020-07-02 21:01:37');
INSERT INTO `signin` VALUES (30, 190327201, 1, '2020-07-02 21:09:09', '119.655698,26.956882', 3, '2020-07-02 21:08:47');
INSERT INTO `signin` VALUES (31, 190327201, 1, '2020-07-02 21:20:27', '119.655695,26.957078', 3, '2020-07-02 21:10:16');
INSERT INTO `signin` VALUES (32, 190327201, 1, '2020-07-02 21:27:24', '119.65568,26.957083', 231249, '2020-07-02 21:24:55');
INSERT INTO `signin` VALUES (33, 190327201, 1, NULL, '119.655734,26.9571', 231249, '2020-07-02 21:33:40');
INSERT INTO `signin` VALUES (34, 190327201, 1, NULL, '119.655704,26.957099', 231249, '2020-07-02 21:33:40');
INSERT INTO `signin` VALUES (35, 190327201, 1, NULL, '119.655731,26.9571', 231249, '2020-07-02 21:33:42');
INSERT INTO `signin` VALUES (36, 190327201, 1, '2020-07-02 21:41:39', '119.655747,26.957103', 231249, '2020-07-02 21:38:51');
INSERT INTO `signin` VALUES (37, 190327201, 1, '2020-07-02 21:45:40', '119.655725,26.957083', 231249, '2020-07-02 21:44:13');
INSERT INTO `signin` VALUES (38, 190327201, 2, '2020-07-02 21:46:45', '119.655837,26.957103,1-2-3-6-9', 231249, '2020-07-02 21:46:13');
INSERT INTO `signin` VALUES (39, 190327201, 2, '2020-07-02 21:55:32', '118.905985,24.960703,1-2-3', 231249, '2020-07-02 21:50:26');
INSERT INTO `signin` VALUES (40, 190327201, 1, '2020-07-02 22:26:50', '119.65568,26.957101', 3, '2020-07-02 22:24:29');
INSERT INTO `signin` VALUES (41, 190327201, 2, '2020-07-02 22:44:55', '119.655721,26.956894,1-2-3', 3, '2020-07-02 22:43:08');

-- ----------------------------
-- Table structure for systemparameter
-- ----------------------------
DROP TABLE IF EXISTS `systemparameter`;
CREATE TABLE `systemparameter`  (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of systemparameter
-- ----------------------------
INSERT INTO `systemparameter` VALUES (1, '作业经验值', '10');
INSERT INTO `systemparameter` VALUES (2, '签到经验值', '2');
INSERT INTO `systemparameter` VALUES (3, '魅力值', '1');
INSERT INTO `systemparameter` VALUES (4, '蓝豆', '1');
INSERT INTO `systemparameter` VALUES (5, '心意', '12');
INSERT INTO `systemparameter` VALUES (6, '距离', '300000000');

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) NOT NULL,
  `Grade` int(11) DEFAULT NULL,
  `Answer` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GradePoint` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Task` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `Team` int(11) DEFAULT NULL,
  `ScoringMethod` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LastSubmitTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_5`(`UserId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 190327201, 1, NULL, NULL, '提交代码', 231240, 2, '无', '2020-06-25 22:15:37');
INSERT INTO `task` VALUES (2, 190327201, 2, NULL, NULL, '写实验报告', 231240, NULL, NULL, '2020-07-11 10:37:08');
INSERT INTO `task` VALUES (3, 190327201, 2, NULL, '写实验报告', '提价代码', 231242, NULL, NULL, '2020-07-02 04:00:00');
INSERT INTO `task` VALUES (4, 190327201, 10, NULL, '详情', '任务测试', 231245, NULL, NULL, '2020-07-06 10:00:00');
INSERT INTO `task` VALUES (5, 190327201, 10, NULL, '详情', '测试的任务', 231243, NULL, NULL, '2020-07-02 05:00:00');
INSERT INTO `task` VALUES (6, 190327201, 10, NULL, '详情', '测试的任务11', 231243, NULL, NULL, '2020-07-04 05:00:00');
INSERT INTO `task` VALUES (7, 190327201, 10, NULL, '测试使用', '测试任务', 231249, NULL, NULL, '2020-07-08 04:00:00');
INSERT INTO `task` VALUES (8, 190327201, 10, NULL, '任务详情', '添加任务', 3, NULL, NULL, '2020-07-02 05:00:00');
INSERT INTO `task` VALUES (9, 190327201, 10, NULL, '详情……', '发布任务1', 3, NULL, NULL, '2020-07-02 08:00:00');
INSERT INTO `task` VALUES (10, 190327201, 10, NULL, '详情……', '发布任务2', 3, NULL, NULL, '2020-07-03 22:00:00');

-- ----------------------------
-- Table structure for taskmemory
-- ----------------------------
DROP TABLE IF EXISTS `taskmemory`;
CREATE TABLE `taskmemory`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `StudentId` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IsParticipate` int(11) DEFAULT NULL,
  `Grade` int(11) DEFAULT NULL,
  `Anser` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `GradePoint` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Task` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  `Team` int(11) DEFAULT NULL,
  `ScoringMethod` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LastSubmitTime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_6`(`StudentId`) USING BTREE,
  CONSTRAINT `taskmemory_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `userinfo` (`Number`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of taskmemory
-- ----------------------------
INSERT INTO `taskmemory` VALUES (3, '190327014', 1, 1, '2', '2', '2', 231240, NULL, NULL, '2020-06-27 10:59:02');
INSERT INTO `taskmemory` VALUES (4, '190327014', 1, 2, '提交测试任务', NULL, '3', 231242, NULL, NULL, '2020-07-02 04:00:00');
INSERT INTO `taskmemory` VALUES (5, '190327014', 1, 10, '提交内容', NULL, '6', 231243, NULL, NULL, '2020-07-04 05:00:00');
INSERT INTO `taskmemory` VALUES (8, '190327014', 1, 10, 'vsf个大V是', NULL, '4', 231245, NULL, NULL, '2020-07-06 10:00:00');
INSERT INTO `taskmemory` VALUES (9, '190327014', 1, 10, '任务提交', NULL, '7', 231249, NULL, NULL, '2020-07-08 04:00:00');
INSERT INTO `taskmemory` VALUES (10, '190327072', 1, 10, '是好事还是', NULL, '10', 3, NULL, NULL, '2020-07-03 22:00:00');
INSERT INTO `taskmemory` VALUES (11, '190327014', 1, 10, '。。。', NULL, '10', 3, NULL, NULL, '2020-07-03 22:00:00');

-- ----------------------------
-- Table structure for usercheck
-- ----------------------------
DROP TABLE IF EXISTS `usercheck`;
CREATE TABLE `usercheck`  (
  `Id` int(11) NOT NULL,
  `Fk_UserInfo_UserCheck_Id` int(11) DEFAULT NULL,
  `Type` int(11) DEFAULT NULL,
  `ThirdParty` int(11) DEFAULT NULL,
  `Identifier` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PasswordToken` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CreationDate` datetime DEFAULT NULL,
  `Creater` int(11) DEFAULT NULL,
  `ModificationDate` datetime DEFAULT NULL,
  `Modifier` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
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
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Image` mediumblob,
  `NickName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `School` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Master` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CreationDate` datetime DEFAULT NULL,
  `ModificationDate` datetime DEFAULT NULL,
  `Creator` int(11) DEFAULT NULL,
  `Modifier` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`, `Number`) USING BTREE,
  UNIQUE INDEX `Number`(`Number`) USING BTREE,
  UNIQUE INDEX `Id`(`Id`) USING BTREE,
  UNIQUE INDEX `NickName`(`NickName`) USING BTREE,
  UNIQUE INDEX `Phone`(`Phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (2, '190327201', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '张三', NULL, '李四', '2020-10-10', '男', '福州大学', '数学与计算机科学学院', '教师', '18965151839', '计算机技术', '2020-07-03 00:23:40', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (3, '190327014', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '黎明', NULL, '旺财', '2020-10-10', '男', '厦门大学', '国际关系学院', '学生', '18111111111', '计算机技术', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (5, '190327111', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '李四', NULL, '喵喵', NULL, '男', '厦门大学', '管理学院', '学生', '13276555555', '计算机技术', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (69, '190327112', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '池升恒', NULL, '嘤嘤怪', NULL, '男', '福州大学', '数学与计算机科学学院', '学生', '15963248122', '计算机技术', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (70, '190327113', 'bcbac47c6b7c244acea485e5791fb23daf096220e42d1bf68aedbae3794b4a63', '池芝标', NULL, '测试教师', NULL, '男', '福州大学', '数学与计算机科学学院', '教师', '15963248123', '计算机技术', NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (84, '190327012', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '池升恒', NULL, 'nickname', '2020-11-10', 'male', '福州大学', '数计学院', '教师', '15078383033', '计算机技术', '2020-07-02 15:39:52', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (87, '190327072', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '王海朝', NULL, NULL, NULL, '男', '福州大学', '数学与计算机科学学院', '学生', '18238797860', '计算机技术', '2020-07-02 22:00:39', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (88, '190327021', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '柳煌达', NULL, NULL, NULL, '男', '福州大学', '数学与计算机科学学院', '学生', '15078383011', '', '2020-07-02 22:12:02', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (90, '190327064', '1968e64810e7f8bf475d3f78420d39f01074515f24568cf798d79cde54e92ad5', '柳煌达', NULL, NULL, NULL, '男', '福州大学', '数学与计算机科学学院', '学生', '13358551999', '计算机技术', '2020-07-02 22:21:22', NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (91, '190327065', '615ed7fb1504b0c724a296d7a69e6c7b2f9ea2c57c1d8206c5afdf392ebdfd25', '庄红兵', NULL, 'xiaozhuang', NULL, '男', '福州大学', '经济与管理学院', '学生', '13311111111', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (113, '123456', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '池升恒', NULL, NULL, NULL, '男', 'd', 'd', '学生', '15078380000', 'd', '2020-07-03 17:06:07', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
