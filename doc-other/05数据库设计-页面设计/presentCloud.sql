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

 Date: 29/04/2020 19:35:47
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dictionarytype
-- ----------------------------
INSERT INTO `dictionarytype` VALUES (1, '性别', 'sexy', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionarytype` VALUES (2, '身份', 'role', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `dictionarytype` VALUES (3, '学历', 'degree', NULL, NULL, NULL, NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of directorydata
-- ----------------------------
INSERT INTO `directorydata` VALUES (1, 'sexy', 'male', '男', 1);
INSERT INTO `directorydata` VALUES (2, 'sexy', 'female', '女', 0);
INSERT INTO `directorydata` VALUES (3, 'role', 'teacher', '老师', 0);
INSERT INTO `directorydata` VALUES (4, 'role', 'student', '学生', 1);
INSERT INTO `directorydata` VALUES (5, 'role', 'assistant', '助教', 0);
INSERT INTO `directorydata` VALUES (6, 'role', 'admin', '管理员', 0);
INSERT INTO `directorydata` VALUES (7, 'degree', 'undergraduate', '本科', 1);
INSERT INTO `directorydata` VALUES (8, 'degree', 'master', '硕士', 0);
INSERT INTO `directorydata` VALUES (9, 'degree', 'doctor', '博士', 0);
INSERT INTO `directorydata` VALUES (10, 'degree', 'college', '专科', 0);
INSERT INTO `directorydata` VALUES (11, 'degree', 'belowhigh', '高中及以下', NULL);

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
  `Id` int(11) NOT NULL,
  `SuperiorMenuNumber` int(10) NOT NULL,
  `MenuName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ButtonEnglishlogo` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ButtonChineselogo` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IsMenu` int(1) NULL DEFAULT NULL,
  `Creator` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Modifier` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MenuId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '教师', NULL);
INSERT INTO `role` VALUES (2, '学生', NULL);
INSERT INTO `role` VALUES (3, '助教', NULL);
INSERT INTO `role` VALUES (4, '管理员', NULL);

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
  `Id` int(11) NOT NULL,
  `Number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Image` mediumblob NULL,
  `NickName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Birthday` datetime NULL DEFAULT NULL,
  `Sex` int(11) NULL DEFAULT NULL,
  `School` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Master` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CreationDate` datetime NULL DEFAULT NULL,
  `ModificationDate` datetime NULL DEFAULT NULL,
  `Creator` int(11) NULL DEFAULT NULL,
  `Modifier` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
