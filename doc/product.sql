/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50545
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50545
File Encoding         : 65001

Date: 2018-07-09 11:46:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) NOT NULL,
  `dir_id` bigint(11) DEFAULT NULL,
  `salePrice` decimal(10,2) DEFAULT NULL,
  `supplier` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `cutoff` double(2,2) DEFAULT NULL,
  `costPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('3', '电脑', '1234', '500.00', 'pppp', 'pc', '0.70', '100.80');
