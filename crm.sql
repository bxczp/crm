/*
Navicat MySQL Data Transfer

Source Server         : root-ASUS
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-17 16:20:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `khno` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `level` varchar(30) DEFAULT NULL,
  `myd` varchar(30) DEFAULT NULL,
  `xyd` varchar(30) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postCode` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `webSite` varchar(20) DEFAULT NULL,
  `yyzzzch` varchar(50) DEFAULT NULL,
  `fr` varchar(20) DEFAULT NULL,
  `zczj` varchar(20) DEFAULT NULL,
  `nyye` varchar(20) DEFAULT NULL,
  `khyh` varchar(50) DEFAULT NULL,
  `khzh` varchar(50) DEFAULT NULL,
  `dsdjh` varchar(50) DEFAULT NULL,
  `gsdjh` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', 'KH21321321', '北京大牛科技', '北京', '小张', '战略合作伙伴', '☆☆☆', '☆☆☆', '北京海淀区双榆树东里15号', '100027', '010-62263393', '010-62263393', 'www.daniu.com', '420103000057404', '张三', '1000', '5000', '中国银行 ', '6225231243641', '4422214321321', '4104322332', '0');
INSERT INTO `t_customer` VALUES ('16', 'KH20150526073022', '风驰科技', '北京', '小红', '大客户', '☆', '☆', '321', '21', '321', '321', '321', '321', '321', '', '21', '321', '321', '321', '3213', '0');
INSERT INTO `t_customer` VALUES ('17', 'KH20150526073023', '巨人科技', null, '小丽', '普通客户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `t_customer` VALUES ('18', 'KH20150526073024', '新人科技', null, null, '重点开发客户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `t_customer` VALUES ('19', 'KH20150526073025', '好人集团', null, null, '合作伙伴', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `t_customer` VALUES ('20', 'KH20150526073026', '新浪', null, null, '大客户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `t_customer` VALUES ('21', 'KH20150526073027', '百度', null, null, '大客户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for t_customer_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_contact`;
CREATE TABLE `t_customer_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `contactTime` date DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `overview` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_contact
-- ----------------------------
INSERT INTO `t_customer_contact` VALUES ('1', '1', '2015-05-14', '1', '2');
INSERT INTO `t_customer_contact` VALUES ('2', '1', '2015-05-06', '1', '2');
INSERT INTO `t_customer_contact` VALUES ('4', '16', '2016-03-29', '任霆发够无色', '二班');

-- ----------------------------
-- Table structure for t_customer_linkman
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_linkman`;
CREATE TABLE `t_customer_linkman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `linkName` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `zhiwei` varchar(50) DEFAULT NULL,
  `officePhone` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_linkman
-- ----------------------------
INSERT INTO `t_customer_linkman` VALUES ('1', '1', '1', '男', '321', '321', '21321');
INSERT INTO `t_customer_linkman` VALUES ('2', '1', '2', '女', '21', '321', '321');
INSERT INTO `t_customer_linkman` VALUES ('4', '1', '3', '女', '4', '5', '6');
INSERT INTO `t_customer_linkman` VALUES ('5', '1', '33', '男', '44', '55', '66');
INSERT INTO `t_customer_linkman` VALUES ('6', '1', '张三', '男', '经理', '21321', '32132121');
INSERT INTO `t_customer_linkman` VALUES ('7', '1', '是', '女', '发送', '2321', '321321');
INSERT INTO `t_customer_linkman` VALUES ('8', '1', '给你', '男', '是', '杀人', '而更新');
INSERT INTO `t_customer_linkman` VALUES ('9', '1', '额', '男', '问题我', '为5 ', '252 ');

-- ----------------------------
-- Table structure for t_customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_loss`;
CREATE TABLE `t_customer_loss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusNo` varchar(40) DEFAULT NULL,
  `cusName` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `lastOrderTime` date DEFAULT NULL,
  `confirmLossTime` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `lossreason` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_loss
-- ----------------------------
INSERT INTO `t_customer_loss` VALUES ('6', 'KH20150526073023', '巨人科技', '小丽', '2014-02-03', '2016-03-30', '1', '饿有人');
INSERT INTO `t_customer_loss` VALUES ('7', 'KH20150526073024', '新人科技', null, null, '2016-03-30', '1', '是否认为');
INSERT INTO `t_customer_loss` VALUES ('8', 'KH20150526073025', '好人集团', null, null, null, '0', null);
INSERT INTO `t_customer_loss` VALUES ('9', 'KH20150526073026', '新浪', null, null, null, '1', null);
INSERT INTO `t_customer_loss` VALUES ('10', 'KH20150526073027', '百度', null, null, null, '1', null);

-- ----------------------------
-- Table structure for t_customer_order
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_order`;
CREATE TABLE `t_customer_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `orderNo` varchar(40) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_order
-- ----------------------------
INSERT INTO `t_customer_order` VALUES ('1', '1', 'DD11213', '2015-12-01', '11', '0');
INSERT INTO `t_customer_order` VALUES ('2', '16', 'DD11212', '2016-01-02', '22', '0');
INSERT INTO `t_customer_order` VALUES ('3', '16', 'DD21321', '2015-12-02', '22', '0');
INSERT INTO `t_customer_order` VALUES ('4', '17', 'DD2121', '2014-02-03', 'ss', '0');

-- ----------------------------
-- Table structure for t_customer_reprieve
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_reprieve`;
CREATE TABLE `t_customer_reprieve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lossId` int(11) DEFAULT NULL,
  `measure` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_reprieve
-- ----------------------------
INSERT INTO `t_customer_reprieve` VALUES ('1', '8', '威尔刚以为得喝');
INSERT INTO `t_customer_reprieve` VALUES ('3', '8', '问过我');
INSERT INTO `t_customer_reprieve` VALUES ('4', '8', '无任何问');

-- ----------------------------
-- Table structure for t_customer_service
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_service`;
CREATE TABLE `t_customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serveType` varchar(30) DEFAULT NULL,
  `overview` varchar(500) DEFAULT NULL,
  `customer` varchar(30) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `servicerequest` varchar(500) DEFAULT NULL,
  `createPeople` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assigner` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `serviceProce` varchar(500) DEFAULT NULL,
  `serviceProcePeople` varchar(20) DEFAULT NULL,
  `serviceProceTime` datetime DEFAULT NULL,
  `serviceProceResult` varchar(500) DEFAULT NULL,
  `myd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_customer_service
-- ----------------------------
INSERT INTO `t_customer_service` VALUES ('1', '咨询', '咨询下Think pad价格', '大浪技术', '已归档', '。。。测试', 'Jack', '2015-06-03 00:00:00', '小红', '2015-06-03 00:00:00', 's', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('2', '咨询', '321', '1', '已归档', '321', 'Jack', '2015-06-03 00:00:00', null, null, 'sss', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆☆');
INSERT INTO `t_customer_service` VALUES ('3', '咨询', '21', '21', '已归档', '1', 'Jack', '2015-06-03 00:00:00', '小红', '2015-06-03 00:00:00', 'sds', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('6', '咨询', '321', '21', '已归档', '321', 'Jack', '2015-06-03 00:00:00', '小红', '2015-06-04 00:00:00', 'ds', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆☆');
INSERT INTO `t_customer_service` VALUES ('7', '咨询', 's', '222', '已归档', 'ss', 'Jack', '2015-06-04 00:00:00', '小明', '2015-06-04 00:00:00', 'ss', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆');
INSERT INTO `t_customer_service` VALUES ('8', '建议', '4', '3', '已处理', '5', 'Jack', '2015-06-04 00:00:00', '小张', '2015-06-04 00:00:00', '111', 'Jack', '2015-06-04 00:00:00', null, null);
INSERT INTO `t_customer_service` VALUES ('9', '投诉', '2', '1', '已归档', '3', 'Jack', '2015-06-04 00:00:00', '小明', '2015-06-04 00:00:00', '333', 'Jack', '2015-06-04 00:00:00', 'OK', '☆☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('10', '建议', '32', '32', '新创建', '32', 'Jack', '2015-06-04 00:00:00', null, null, null, null, null, null, null);
INSERT INTO `t_customer_service` VALUES ('11', '建议', '21', '21', '已归档', '21', 'Jack', '2015-06-04 00:00:00', '小明', '2015-06-11 00:00:00', 'fds', 'Jack', '2015-06-11 00:00:00', 'd', '☆☆☆');
INSERT INTO `t_customer_service` VALUES ('12', '建议', 'fda', '大牛科技', '已归档', 'fda', 'Jack', '2015-06-10 00:00:00', '小红', '2015-06-10 00:00:00', 'fda', 'Jack', '2015-06-10 00:00:00', 'good', '☆☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('13', '咨询', '咨询下Think pad价格。。', '大众科技', '已归档', '发达龙卷风大。。。。', 'Jack', '2015-06-11 00:00:00', '小红', '2015-06-11 00:00:00', '。。。\r\n1，2\r\n，3。。。', 'Jack', '2015-06-11 00:00:00', 'OK', '☆☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('14', '咨询', '11', 'sss', '已分配', '22', 'Jack', '2015-08-24 00:00:00', '小明', '2016-03-30 00:00:00', null, null, null, null, null);
INSERT INTO `t_customer_service` VALUES ('15', '而', '格式', '对符合规定', '已归档', '还不太热爱', '笨熊', '2016-03-30 00:00:00', '小明', '2016-03-30 00:00:00', '个人的人格为我要换个', '笨熊', '2016-03-30 00:00:00', '提空调', '☆☆☆');
INSERT INTO `t_customer_service` VALUES ('16', '而', '切尔夫人', '番茄味 ', '新创建', '无法如期安慰', '笨熊', '2016-03-30 00:00:00', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_cus_dev_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_cus_dev_plan`;
CREATE TABLE `t_cus_dev_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saleChanceId` int(11) DEFAULT NULL,
  `planItem` varchar(100) DEFAULT NULL,
  `planDate` date DEFAULT NULL,
  `exeAffect` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_cus_dev_plan` (`saleChanceId`) USING BTREE,
  CONSTRAINT `FK_t_cus_dev_plan` FOREIGN KEY (`saleChanceId`) REFERENCES `t_sale_chance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_cus_dev_plan
-- ----------------------------
INSERT INTO `t_cus_dev_plan` VALUES ('1', '1', '测试计划项', '2011-01-01', '好');
INSERT INTO `t_cus_dev_plan` VALUES ('4', '1', 'haha', '2015-05-20', 'en啊');
INSERT INTO `t_cus_dev_plan` VALUES ('5', '1', 'ss', '2015-05-13', '');
INSERT INTO `t_cus_dev_plan` VALUES ('6', '16', '2121', '2015-05-28', '');
INSERT INTO `t_cus_dev_plan` VALUES ('7', '16', '21121', '2015-05-19', '');
INSERT INTO `t_cus_dev_plan` VALUES ('8', '19', '21', '2015-05-28', '');
INSERT INTO `t_cus_dev_plan` VALUES ('9', '2', '1', '2015-05-27', '2');
INSERT INTO `t_cus_dev_plan` VALUES ('10', '2', '2', '2015-05-28', '');
INSERT INTO `t_cus_dev_plan` VALUES ('11', '21', '好', '2015-06-09', '额');
INSERT INTO `t_cus_dev_plan` VALUES ('12', '22', '联系客户，介绍产品', '2015-06-01', '有点效果');
INSERT INTO `t_cus_dev_plan` VALUES ('13', '22', '请客户吃饭，洽谈', '2015-06-07', '成功了');
INSERT INTO `t_cus_dev_plan` VALUES ('14', '15', '洽谈', '2015-06-09', '可以');
INSERT INTO `t_cus_dev_plan` VALUES ('15', '1', '的体验活动', '2016-03-23', '我是认为22222');
INSERT INTO `t_cus_dev_plan` VALUES ('16', '1', '山东分行公司 ', '2016-03-15', '商务沟通');
INSERT INTO `t_cus_dev_plan` VALUES ('17', '15', '有人', '2016-03-29', '表格和');
INSERT INTO `t_cus_dev_plan` VALUES ('18', '2', '更深入的', '2016-03-29', '人防办v个');
INSERT INTO `t_cus_dev_plan` VALUES ('19', '2', '我二哥', null, '为');

-- ----------------------------
-- Table structure for t_datadic
-- ----------------------------
DROP TABLE IF EXISTS `t_datadic`;
CREATE TABLE `t_datadic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataDicName` varchar(50) DEFAULT NULL,
  `dataDicValue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_datadic` (`dataDicValue`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_datadic
-- ----------------------------
INSERT INTO `t_datadic` VALUES ('1', '客户等级', '普通客户');
INSERT INTO `t_datadic` VALUES ('2', '客户等级', '重点开发客户');
INSERT INTO `t_datadic` VALUES ('3', '客户等级', '大客户');
INSERT INTO `t_datadic` VALUES ('4', '客户等级', '合作伙伴');
INSERT INTO `t_datadic` VALUES ('5', '客户等级', '战略合作伙伴');
INSERT INTO `t_datadic` VALUES ('6', '服务类型', '咨询');
INSERT INTO `t_datadic` VALUES ('7', '服务类型', '建议');
INSERT INTO `t_datadic` VALUES ('8', '服务类型', '投诉');
INSERT INTO `t_datadic` VALUES ('26', '服务类型', '而');
INSERT INTO `t_datadic` VALUES ('27', '我认为吧', '千万人前往');

-- ----------------------------
-- Table structure for t_order_details
-- ----------------------------
DROP TABLE IF EXISTS `t_order_details`;
CREATE TABLE `t_order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `goodsName` varchar(100) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `sum` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_order_details
-- ----------------------------
INSERT INTO `t_order_details` VALUES ('1', '1', '联想笔记本', '2', '台', '4900', '9800');
INSERT INTO `t_order_details` VALUES ('2', '1', '惠普音响', '4', '台', '200', '800');
INSERT INTO `t_order_details` VALUES ('3', '2', '罗技键盘', '10', '个', '90', '900');
INSERT INTO `t_order_details` VALUES ('4', '3', '艾利鼠标', '20', '个', '20', '400');
INSERT INTO `t_order_details` VALUES ('5', '3', '东芝U盘', '5', '个', '105', '525');
INSERT INTO `t_order_details` VALUES ('6', '4', '充电器', '1', '个', '30', '30');

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` double NOT NULL AUTO_INCREMENT,
  `productName` varchar(300) DEFAULT NULL,
  `model` varchar(150) DEFAULT NULL,
  `unit` varchar(60) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `store` double DEFAULT NULL,
  `remark` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '无日峰', '搜狗', '个人的', '89', '564', '547我有好多');

-- ----------------------------
-- Table structure for t_sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_chance`;
CREATE TABLE `t_sale_chance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chanceSource` varchar(300) DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `cgjl` int(11) DEFAULT NULL,
  `overview` varchar(300) DEFAULT NULL,
  `linkMan` varchar(100) DEFAULT NULL,
  `linkPhone` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `createMan` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assignMan` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `devResult` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_sale_chance
-- ----------------------------
INSERT INTO `t_sale_chance` VALUES ('1', '主动来找的', '风软科技', '100', '采购笔记本意向', '张先生', '137234576543', '。。。', 'Jack', '2014-01-01 00:00:00', '3', '2015-05-24 16:15:00', '1', '1');
INSERT INTO `t_sale_chance` VALUES ('2', '', '1', '12', '', '', '', '', '12', null, '3', '2015-05-25 11:21:00', '1', '1');
INSERT INTO `t_sale_chance` VALUES ('8', null, '7', null, null, null, null, null, null, null, null, null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('9', null, '8', null, null, null, null, null, null, null, null, null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('10', null, '9', null, null, null, null, null, null, null, null, null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('11', '', '10', '1', '', '', '', '', '321', null, '', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('12', null, '11', null, null, null, null, null, null, null, null, null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('13', '', '21', '1', '', '', '', '', '21', null, '3', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('14', '2', '1', '5', '6', '3', '4', '7', '8', null, '3', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('15', '213', '112', '22', '', '', '', '', '221', '2013-01-01 11:20:00', '3', '2013-01-01 11:20:00', '1', '1');
INSERT INTO `t_sale_chance` VALUES ('16', '22', '11', '55', '66', '33', '44', '77', '88', '2013-01-01 11:20:00', '4', '2013-01-01 11:20:00', '1', '3');
INSERT INTO `t_sale_chance` VALUES ('17', '321', '121', '1', '321', '321', '213', '321', '321', '2015-05-22 11:23:00', '3', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('18', '321', '321', '11', '321', '321', '213', '321', 'Jack', '2015-05-22 11:43:00', '', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('19', '321', '213', '21', '21', '21', '321', '321', 'Jack', '2015-05-24 11:33:00', '3', '2015-05-24 11:34:00', '1', '3');
INSERT INTO `t_sale_chance` VALUES ('20', '321', '213', '100', '321', '321', '321', '321', 'Jack', '2015-05-24 11:35:00', '', null, '0', '0');
INSERT INTO `t_sale_chance` VALUES ('21', '行业介绍', '大鸟爱科技', '80', '阿凡达深刻理解', '张先生', '0231-321321', '发达放大空间发大水发大水了发', 'Jack', '2015-06-10 16:32:00', '4', '2015-06-10 16:33:00', '1', '3');
INSERT INTO `t_sale_chance` VALUES ('22', '同行介绍', '鸟人科技', '90', '采购IBM服务器意向', '张三', '2321321321', ',...', 'Jack', '2015-06-11 08:35:00', '5', '2015-06-11 08:36:00', '1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `trueName` varchar(20) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `roleName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '11', '123456', '笨熊', 'java1234@qq.com', '123456789', '系统管理员');
INSERT INTO `t_user` VALUES ('2', 'jack', '123456', 'Json', 'json@qq.com', '232132121', '销售主管');
INSERT INTO `t_user` VALUES ('3', 'marry', '123456', '小明', 'khjl01@qq.com', '2321321', '客户经理');
INSERT INTO `t_user` VALUES ('4', 'xiaohong', '123', '小红', 'khjl02@qq.com', '21321', '客户经理');
INSERT INTO `t_user` VALUES ('5', 'xiaozhang', '123', '小张', 'khjl03@qq.com', '3242323', '客户经理');
INSERT INTO `t_user` VALUES ('6', 'daqian', '123', '曹大千', 'gaoguan@qq.com', '5434232', '高管');
INSERT INTO `t_user` VALUES ('7', '21', '321', '321321', '321@qq.com', '321', '系统管理员');
INSERT INTO `t_user` VALUES ('9', '21', '32132', '321', '321@qq.com', '321', '销售主管');
