/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : cartoon

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 21/05/2020 07:29:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cartoon_info
-- ----------------------------
DROP TABLE IF EXISTS `cartoon_info`;
CREATE TABLE `cartoon_info`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_category` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_intro` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_serialize` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_cover` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_resource` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '未上架',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cartoon_info
-- ----------------------------
INSERT INTO `cartoon_info` VALUES (1, '崩坏3', '上海米哈游', '冒险', '延续《崩坏学园2》主线剧情,崩坏学园系列漫画最新作！ 敌人不再只是死士，那拥有压倒性力量的巨大身影究竟是.....? 无量塔姬子，圣芙蕾雅学园，律者，女武神.......更广阔的未知世界展现在众主角眼前！ 琪亚娜，芽衣，布洛妮娅的身世也即将揭晓，是携手过去拯救世界还是沉溺其中止步不前？少女们的决心，尽请期待！！', '雾都假日 第6话', 'benghuai3.jpg', '重生为英雄的女儿的英雄再次想成为英雄', '连载中');
INSERT INTO `cartoon_info` VALUES (3, '武藤和佐藤', '	赤塚大将', '欢乐向', '武藤与佐藤漫画 ，一个总是无意识中发挥出了男友力的女生与有点天然呆的男主之间的欢乐搞笑日常！！\r\n欢迎在动漫之家漫画网观看武藤与佐藤漫画', '第09话', '武藤和佐藤.jpg', '武藤和佐藤', '连载中');
INSERT INTO `cartoon_info` VALUES (4, '重生为英雄的女儿的英雄再次想成为英雄', '鏑木ハルカ 言寺あまね', '魔幻', '重生为英雄的女儿的英雄再次想成为英雄漫画 ，被称为英雄的六人中的一人雷德，陷入了单独与魔神战斗的困境，以两败俱伤告终。在可疑神明的指引下，他再度醒来时，转生为了婴儿。而且还是原本同伴们的女儿。为了取回过去的力量，抵达曾经以之为目标却未能如愿的理想，雷德·尼可尔的苦难人生开幕了。', '第13话', '重生为英雄的女儿.jpg', '重生为英雄的女儿的英雄再次想成为英雄', '连载中');
INSERT INTO `cartoon_info` VALUES (5, '社畜小姐和离家出走少女', '	タツノコッソ', '百合', '社畜小姐和离家出走少女漫画 ，社畜与离家出走的少女温馨的同居日常。\r\n欢迎在动漫之家漫画网观看社畜小姐和离家出走少女漫画', '第09话', '社畜小姐和离家出走少女.jpg', '社畜小姐和离家出走少女', '连载中');
INSERT INTO `cartoon_info` VALUES (6, '某红魔馆的煎蛋', '粟米汤（さとうきび）', '东方', '某红魔馆的煎蛋漫画 ，料理就是力量!!完全无视科学伦理!!美玲是否能教会妹大人真正的料理呢!!\r\n欢迎在动漫之家漫画网观看某红魔馆的煎蛋漫画', '全一话', '某红魔馆的煎蛋.jpg', '某红魔馆的煎蛋', '完结');
INSERT INTO `cartoon_info` VALUES (7, '那个...能看见哦', '桜の灯る日へ', '欢乐向', '那个…能看见哦漫画 ，这位同学你的那个....漏了....\r\n欢迎在动漫之家漫画网观看那个…能看见哦漫画', '第07话', '那个...能看见哦.jpg', '那个...能看见哦', '连载中');
INSERT INTO `cartoon_info` VALUES (8, '全员恶人', '榊あおい 青崎未来', '校园', '全员恶人漫画 ，放学后的学生会教室、秘密的契约。\r\n欢迎在艾漫漫画网观看全员恶人漫画', '第03话', '全员恶人.jpg', '全员恶人', '连载中');
INSERT INTO `cartoon_info` VALUES (9, '蕾米莉亚似乎在环游新世界', '◆pOgi2U5jM ★', '东方', '蕾米莉亚似乎在环游新世界漫画 ，在救世主蕾米莉亚斯卡雷特拯救了世界后，她的功绩被神明所认可。为了拯救这个日渐沉沦的世界，崭新的蕾米莉亚要开始再次冒险。上吧蕾米莉亚，上吧混沌。野田大神的作品《熊孩子似乎在祸害新世界》，马上就要开始了。', '第06话', '蕾米莉亚似乎在环游新世界.jpg', '蕾米莉亚似乎在环游新世界', '连载中');
INSERT INTO `cartoon_info` VALUES (10, '菜刀幼女的传说', '神波裕太 ささかまたろう', '惊悚', '菜刀幼女的传说漫画 ，菜刀小姐谁都能杀死，所有如果有憎恨的人的话可以召唤菜刀小姐杀死他。', '第13话', '菜刀幼女的传说.jpg', '菜刀幼女的传说', '连载中');
INSERT INTO `cartoon_info` VALUES (11, '鬼泣5前传', 'capcom 尾方富生', '魔幻', '鬼泣5前传漫画 ，迷之男人「Ｖ」 这就是他得到真正的强大为止的故事——。 在全世界拥有莫大的人气，以销售累积超过1700万为豪的传说的系列那系列的最新作品「鬼泣5」的沿生作品堂堂开始！主角是使役三头魔兽的谜之男人「Ｖ」 他的诞生的秘密或跟魔兽们的相遇，以及包含结成契约为止延续到本篇作品前的前传只有沿生作品才有的以「Ｖ」作为视角而写的故事!!', '第14.1话', '鬼泣5前传.jpg', '鬼泣5前传', '连载中');
INSERT INTO `cartoon_info` VALUES (12, '这个勇者明明超强却过分慎重', '	こゆき 土日月', '搞笑', '这个勇者明明超强却过分慎重漫画 ，超慎重的勇者&二流女神组合的新异世界救济谈', '第12.1话', '这个勇者明明超强却过分慎重.jpg', '这个勇者明明超强却过分慎重', '连载中');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `cartoon_id` int(11) NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1032 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1030, 4, 1001);
INSERT INTO `collect` VALUES (1031, 3, 1001);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `f_contact` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `f_content` varchar(800) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1009, '漫画阅读', '1052285750', 'tset测试一下', 1001);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `m_content` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `m_state` tinyint(1) NOT NULL,
  `m_exporter` int(11) NULL DEFAULT NULL,
  `m_receiver` int(11) NULL DEFAULT NULL,
  `m_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (12, NULL, '测试', 1, 1001, 1003, '2020-02-22 18:23:43');
INSERT INTO `message` VALUES (13, NULL, '测试', 1, 1001, 1003, '2020-02-22 18:23:46');

-- ----------------------------
-- Table structure for personage_info
-- ----------------------------
DROP TABLE IF EXISTS `personage_info`;
CREATE TABLE `personage_info`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_intro` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `p_head` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `p_birthday` date NULL DEFAULT NULL,
  `p_sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密',
  `u_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NULL DEFAULT NULL,
  `c_id` int(11) NULL DEFAULT NULL,
  `r_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `r_record` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `r_judge` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE,
  UNIQUE INDEX `r_judge`(`r_judge`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (61, 1001, 4, '2020-02-22 18:39:21', '第01话', 'admin4');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `u_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `u_number`(`u_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
