/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - db_crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_crm`;

/*Table structure for table `t_cus_dev_plan` */

DROP TABLE IF EXISTS `t_cus_dev_plan`;

CREATE TABLE `t_cus_dev_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saleChanceId` int(11) DEFAULT NULL,
  `planItem` varchar(100) DEFAULT NULL,
  `planDate` date DEFAULT NULL,
  `exeAffect` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_cus_dev_plan` (`saleChanceId`),
  CONSTRAINT `FK_t_cus_dev_plan` FOREIGN KEY (`saleChanceId`) REFERENCES `t_sale_chance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `t_cus_dev_plan` */

insert  into `t_cus_dev_plan`(`id`,`saleChanceId`,`planItem`,`planDate`,`exeAffect`) values (6,16,'2121','2015-05-28',''),(7,16,'21121','2015-05-19',''),(8,19,'21','2015-05-28',''),(9,2,'1','2015-05-27','2'),(10,2,'2','2015-05-28',''),(11,21,'好','2015-06-09','额'),(12,22,'联系客户，介绍产品','2015-06-01','有点效果'),(13,22,'请客户吃饭，洽谈','2015-06-07','成功了'),(14,15,'洽谈','2015-06-09','可以'),(33,1,'111','2018-01-24','111'),(34,1,'222','2018-01-24','222'),(35,2,'1111','2018-03-14','2222'),(36,2,'2222','2018-03-15','2222'),(37,2,'333','2018-03-22','333');

/*Table structure for table `t_customer` */

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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id`,`khno`,`name`,`area`,`cusManager`,`level`,`myd`,`xyd`,`address`,`postCode`,`phone`,`fax`,`webSite`,`yyzzzch`,`fr`,`zczj`,`nyye`,`khyh`,`khzh`,`dsdjh`,`gsdjh`,`state`) values (1,'KH21321321','北京大牛科技','北京','小张','战略合作伙伴','☆☆☆','☆☆☆','北京海淀区双榆树东里15号','100027','010-62263393','010-62263393','www.daniu.com','420103000057404','张三','1000','5000','中国银行 ','6225231243641','4422214321321','4104322332',0),(16,'KH20150526073022','风驰科技','北京','小红','大客户','☆','☆','321','21','321','321','321','321','321','','21','321','321','321','3213',1),(17,'KH20150526073023','巨人科技2','北京','小丽','普通客户','☆','☆','22','22','222','22','2','2','2','2','2','222','2','2','2',1),(18,'KH20150526073024','新人科技',NULL,NULL,'重点开发客户',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(19,'KH20150526073025','好人集团',NULL,NULL,'合作伙伴',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(20,'KH20150526073026','新浪',NULL,NULL,'大客户',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,'KH20150526073027','百度',NULL,NULL,'大客户',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(28,'KH20150729090910','12','南京','小张','战略合作伙伴','☆☆☆☆☆','☆☆☆☆☆','62','22','32','42','52','112','722','122','82','102','92','132','142',1),(36,NULL,'11','北京','小明','普通客户','☆','☆','11','11','11','11','11','1111','11','111','11','11','11','11','11',0),(37,'KH20180315101444','客户名称','北京','小红','普通客户','☆☆','☆','2222','22','2','22','22','22','2','22','22','22','2','22','22',0),(38,'KH20180315101839','33','北京','小红','重点开发客户','☆','☆','33','33','33','33','3333','33','33','33','333','33','3','33','333',0),(39,'KH20180315102112','33','南京','小明','普通客户','☆','☆','333','33','33','33','33','33','33','33','33','3333','33','33','33',0),(40,'KH20180315102300','3333','北京','小明','重点开发客户','☆','☆','33','33','33','33','33','33','33','33','33','33','33','33','33',0);

/*Table structure for table `t_customer_contact` */

DROP TABLE IF EXISTS `t_customer_contact`;

CREATE TABLE `t_customer_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `contactTime` date DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `overview` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_contact` */

insert  into `t_customer_contact`(`id`,`cusId`,`contactTime`,`address`,`overview`) values (1,1,'2015-05-14','1','2'),(2,1,'2015-05-06','12','22'),(3,1,'2015-08-22','珠江路2','吃饭2');

/*Table structure for table `t_customer_linkman` */

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_linkman` */

insert  into `t_customer_linkman`(`id`,`cusId`,`linkName`,`sex`,`zhiwei`,`officePhone`,`phone`) values (1,1,'1','男','321','321','21321'),(2,1,'2','女','21','321','321'),(4,1,'3','女','4','5','6'),(5,1,'33','男','44','55','66'),(6,1,'张三','男','经理','21321','32132121'),(7,1,'是','女','发送','2321','321321'),(10,1,'da','女','s','fd','fda'),(12,1,'问问','男','问问','问问','问问');

/*Table structure for table `t_customer_loss` */

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_loss` */

insert  into `t_customer_loss`(`id`,`cusNo`,`cusName`,`cusManager`,`lastOrderTime`,`confirmLossTime`,`state`,`lossreason`) values (9,'KH20150526073022','风驰科技','小红','2014-03-02','2015-08-21',1,'客户公司倒闭！'),(10,'KH20150526073023','巨人科技','小丽','2014-02-03',NULL,0,NULL),(11,'KH20150729090910','12','小张',NULL,NULL,0,NULL);

/*Table structure for table `t_customer_order` */

DROP TABLE IF EXISTS `t_customer_order`;

CREATE TABLE `t_customer_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cusId` int(11) DEFAULT NULL,
  `orderNo` varchar(40) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_order` */

insert  into `t_customer_order`(`id`,`cusId`,`orderNo`,`orderDate`,`address`,`state`) values (1,1,'DD11213','2015-07-01','11',0),(2,16,'DD11212','2014-03-02','22',1),(3,16,'DD21321','2014-02-02','22',1),(4,17,'DD2121','2014-02-03','ss',1);

/*Table structure for table `t_customer_reprieve` */

DROP TABLE IF EXISTS `t_customer_reprieve`;

CREATE TABLE `t_customer_reprieve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lossId` int(11) DEFAULT NULL,
  `measure` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_reprieve` */

insert  into `t_customer_reprieve`(`id`,`lossId`,`measure`) values (1,9,'ss2'),(3,10,'111'),(4,9,'打电话咨询客户'),(5,9,'请吃饭');

/*Table structure for table `t_customer_service` */

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_service` */

insert  into `t_customer_service`(`id`,`serveType`,`overview`,`customer`,`state`,`servicerequest`,`createPeople`,`createTime`,`assigner`,`assignTime`,`serviceProce`,`serviceProcePeople`,`serviceProceTime`,`serviceProceResult`,`myd`) values (1,'咨询','咨询下Think pad价格','大浪技术','已归档','。。。测试','Jack','2015-06-03 00:00:00','小红','2015-06-03 00:00:00','s','Jack','2015-06-04 00:00:00','OK','☆☆☆☆'),(2,'咨询','321','1','已归档','321','Jack','2015-06-03 00:00:00',NULL,NULL,'sss','Jack','2015-06-04 00:00:00','OK','☆☆☆'),(3,'咨询','21','21','已归档','1','Jack','2015-06-03 00:00:00','小红','2015-06-03 00:00:00','sds','Jack','2015-06-04 00:00:00','OK','☆☆☆☆'),(6,'咨询','321','21','已归档','321','Jack','2015-06-03 00:00:00','小红','2015-06-04 00:00:00','ds','Jack','2015-06-04 00:00:00','OK','☆☆☆'),(7,'咨询','s','222','已归档','ss','Jack','2015-06-04 00:00:00','小明','2015-06-04 00:00:00','ss','Jack','2015-06-04 00:00:00','OK','☆☆'),(8,'建议','4','3','已处理','5','Jack','2015-06-04 00:00:00','小张','2015-06-04 00:00:00','111','Jack','2015-06-04 00:00:00',NULL,NULL),(9,'投诉','2','1','已归档','3','Jack','2015-06-04 00:00:00','小明','2015-06-04 00:00:00','333','Jack','2015-06-04 00:00:00','OK','☆☆☆☆☆'),(10,'建议','32','32','新创建','32','Jack','2015-06-04 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'建议','21','21','已归档','21','Jack','2015-06-04 00:00:00','小明','2015-06-11 00:00:00','fds','Jack','2015-06-11 00:00:00','d','☆☆☆'),(12,'建议','fda','大牛科技','已归档','fda','Jack','2015-06-10 00:00:00','小红','2015-06-10 00:00:00','fda','Jack','2015-06-10 00:00:00','good','☆☆☆☆☆'),(13,'咨询','咨询下Think pad价格。。','大众科技','已归档','发达龙卷风大。。。。','Jack','2015-06-11 00:00:00','小红','2015-06-11 00:00:00','。。。\r\n1，2\r\n，3。。。','Jack','2015-06-11 00:00:00','OK','☆☆☆☆☆'),(14,'咨询','11','sss','新创建','22','Jack','2015-08-24 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'咨询','问下think pad xx型号 多少钱？','大牛科技',NULL,'xxxx.\r\nxxx.\r\nxxxxx\r\n嗯。','Jack','2015-08-25 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,'投诉','垃圾电脑，刚用就坏。','牛逼科技','已归档','嘻嘻嘻\r\n范德萨','Jack','2015-08-25 00:00:00','小明','2015-08-27 00:00:00','进行了....客户交流。。。\r\n','Jack','2015-08-31 00:00:00','OK','☆☆☆☆☆');

/*Table structure for table `t_datadic` */

DROP TABLE IF EXISTS `t_datadic`;

CREATE TABLE `t_datadic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataDicName` varchar(50) DEFAULT NULL,
  `dataDicValue` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_datadic` (`dataDicValue`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_datadic` */

insert  into `t_datadic`(`id`,`dataDicName`,`dataDicValue`) values (1,'客户等级','普通客户'),(2,'客户等级','重点开发客户'),(3,'客户等级','大客户'),(4,'客户等级','合作伙伴'),(5,'客户等级','战略合作伙伴'),(6,'服务类型','咨询'),(7,'服务类型','建议'),(8,'服务类型','投诉');

/*Table structure for table `t_order_details` */

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_order_details` */

insert  into `t_order_details`(`id`,`orderId`,`goodsName`,`goodsNum`,`unit`,`price`,`sum`) values (1,1,'联想笔记本',2,'台',4900,9800),(2,1,'惠普音响',4,'台',200,800),(3,2,'罗技键盘',10,'个',90,900),(4,3,'艾利鼠标',20,'个',20,400),(5,3,'东芝U盘',5,'个',105,525),(6,4,'充电器',1,'个',30,30);

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(300) DEFAULT NULL,
  `model` varchar(150) DEFAULT NULL,
  `unit` varchar(60) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `store` double DEFAULT NULL,
  `remark` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`productName`,`model`,`unit`,`price`,`store`,`remark`) values (1,'联想笔记本','Y450','台',4500,120,'好');

/*Table structure for table `t_sale_chance` */

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `t_sale_chance` */

insert  into `t_sale_chance`(`id`,`chanceSource`,`customerName`,`cgjl`,`overview`,`linkMan`,`linkPhone`,`description`,`createMan`,`createTime`,`assignMan`,`assignTime`,`state`,`devResult`) values (1,'主动来找的','风软科技',0,'采购笔记本意向','张先生','137234576543','。。。','Jack','2014-01-01 00:00:00','3','2015-05-24 16:15:00',1,3),(2,'','1',0,'','','','','12',NULL,'3','2015-05-25 11:21:00',1,1),(8,NULL,'7',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(9,NULL,'8',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(10,NULL,'9',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(11,'','10',1,'','','','','321',NULL,'',NULL,0,0),(12,NULL,'11',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0),(13,'','21',1,'','','','','21',NULL,'3',NULL,0,0),(14,'2','1',5,'6','3','4','7','8',NULL,'3',NULL,0,0),(15,'213','112',22,'','','','','221','2013-01-01 11:20:00','3','2013-01-01 11:20:00',1,1),(16,'22','11',55,'66','33','44','77','88','2013-01-01 11:20:00','4','2013-01-01 11:20:00',1,3),(17,'321','121',1,'321','321','213','321','321','2015-05-22 11:23:00','3',NULL,0,0),(18,'321','321',11,'321','321','213','321','Jack','2015-05-22 11:43:00','',NULL,0,0),(19,'321','213',21,'21','21','321','321','Jack','2015-05-24 11:33:00','3','2015-05-24 11:34:00',1,3),(20,'321','213',100,'321','321','321','321','Jack','2015-05-24 11:35:00','',NULL,0,0),(21,'行业介绍','大鸟爱科技',80,'阿凡达深刻理解','张先生','0231-321321','发达放大空间发大水发大水了发','Jack','2015-06-10 16:32:00','4','2015-06-10 16:33:00',1,3),(22,'同行介绍','鸟人科技',90,'采购IBM服务器意向','张三','2321321321',',...','Jack','2015-06-11 08:35:00','5','2015-06-11 08:36:00',1,2),(24,'22','22',22,'22','22','22','22','Jack','2017-11-05 18:35:00','',NULL,0,0);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `trueName` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`trueName`,`email`,`phone`,`roleName`) values (1,'wwr','123','Jack','java1234@qq.com','123456789','系统管理员'),(2,'json1234','123','Json','json@qq.com','232132121','销售主管'),(3,'xiaoming','123','小明','khjl01@qq.com','2321321','客户经理'),(4,'xiaohong','123','小红','khjl02@qq.com','21321','客户经理'),(5,'xiaozhang','123','小张','khjl03@qq.com','3242323','客户经理'),(6,'daqian','123','曹大千','gaoguan@qq.com','5434232','高管'),(7,'21','321','321321','321@qq.com','321','系统管理员'),(9,'21','32132','321','321@qq.com','321','销售主管'),(11,'王文英','32132','321','321@qq.com','321','销售主管');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
