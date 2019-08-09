/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.48 : Database - probjectcloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`probjectcloud` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `probjectcloud`;

/*Table structure for table `tb_authority` */

DROP TABLE IF EXISTS `tb_authority`;

CREATE TABLE `tb_authority` (
  `auth_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `auth_name` varchar(200) NOT NULL COMMENT '菜单名称',
  `auth_logo` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `auth_url` varchar(200) DEFAULT NULL COMMENT '跳转url',
  `auth_type` int(11) DEFAULT '2' COMMENT '类型（1=导航，2=菜单，3=api，4=按钮）',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `is_hide` smallint(6) DEFAULT '0' COMMENT '是否隐藏（0=否，1=是）',
  `p_id` bigint(20) DEFAULT '-1' COMMENT '父id',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_authority` */

insert  into `tb_authority`(`auth_id`,`auth_name`,`auth_logo`,`auth_url`,`auth_type`,`sort`,`is_hide`,`p_id`,`created`,`updated`) values (1,'用户管理','&#xe770','user.html',2,0,0,7,'2018-10-12','2018-10-12'),(2,'权限管理','&#xe60f','auth.html',2,2,0,7,'2018-11-14','2018-11-14'),(3,'测试API','/','/test',3,0,0,-1,'2019-01-15','2019-01-15'),(4,'测试microservice-provider-web','/','/microservice-provider-web/test',3,0,0,-1,'2019-01-15','2019-01-15'),(5,'/microservice-provider-web/getAllCode','/','/microservice-provider-web/getAllCode',3,0,0,-1,'2019-01-15','2019-01-15'),(6,'/microservice-provider-web/getAllMenu','/','/microservice-provider-web/getAllMenu',3,0,0,-1,'2019-01-15','2019-01-15'),(7,'基础配置管理','&#xe716','',2,0,0,-1,'2019-01-22','2019-01-22'),(8,'角色管理','&#xe613','roles.html',2,1,0,7,'2019-01-22','2019-01-22'),(10,'商品管理','&#xe716','',2,0,0,7,'2019-08-07',NULL),(11,'test','','',1,0,0,7,'2019-08-07',NULL),(12,'test权限','','',1,0,0,-1,'2019-08-07',NULL),(13,'test1',NULL,NULL,2,0,0,-1,NULL,NULL),(14,'测试','','',1,0,0,7,'2019-08-07',NULL),(15,'测试1','','',1,0,0,7,'2019-08-07',NULL),(16,'测试2','','',1,0,0,7,'2019-08-07',NULL),(17,'测试3','/','',1,0,0,-1,'2019-08-07','2019-08-08'),(18,'测试5','/','/',1,0,0,-1,'2019-08-07','2019-08-07'),(19,'测试4','/','/',0,0,0,-1,'2019-08-07','2019-08-07');

/*Table structure for table `tb_brand` */

DROP TABLE IF EXISTS `tb_brand`;

CREATE TABLE `tb_brand` (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'brand_id',
  `brand_ch_name` varchar(200) DEFAULT NULL COMMENT '品牌中文名称',
  `brand_en_name` varchar(200) DEFAULT NULL COMMENT '品牌英文名称',
  `brand_logo` varchar(500) DEFAULT NULL COMMENT '品牌logo',
  `is_online` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `brand_sort` int(11) DEFAULT '0' COMMENT '排序',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `brand_place` varchar(200) DEFAULT NULL COMMENT '产地',
  `brand_remarks` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='品牌表';

/*Data for the table `tb_brand` */

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `name` varchar(200) NOT NULL COMMENT '菜单名称',
  `logo` varchar(200) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(200) DEFAULT NULL COMMENT '跳转url',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `is_hide` smallint(6) DEFAULT NULL COMMENT '是否隐藏',
  `p_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_menu` */

insert  into `tb_menu`(`id`,`name`,`logo`,`url`,`sort`,`is_hide`,`p_id`,`created`,`updated`) values (1,'用户管理','/','http://localhost:8761',1,0,NULL,'2018-10-12','2018-10-12'),(2,'权限管理','/','https://www.baidu.com/',2,0,NULL,'2018-11-14','2018-11-14');

/*Table structure for table `tb_products_attribute` */

DROP TABLE IF EXISTS `tb_products_attribute`;

CREATE TABLE `tb_products_attribute` (
  `attribute_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '最小分类的类目ID',
  `attribute_name` varchar(100) DEFAULT NULL COMMENT '属性名称',
  `is_online` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `attribute_sort` int(11) DEFAULT '0' COMMENT '属性排序',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性';

/*Data for the table `tb_products_attribute` */

/*Table structure for table `tb_products_attribute_value` */

DROP TABLE IF EXISTS `tb_products_attribute_value`;

CREATE TABLE `tb_products_attribute_value` (
  `value_id` bigint(20) NOT NULL COMMENT '属性值ID',
  `attribute_id` bigint(20) DEFAULT NULL COMMENT '属性ID',
  `attribute_value` varchar(100) NOT NULL COMMENT '属性值',
  `is_online` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `value_sort` int(11) DEFAULT '0' COMMENT '属性值排序',
  PRIMARY KEY (`value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性值';

/*Data for the table `tb_products_attribute_value` */

/*Table structure for table `tb_products_category` */

DROP TABLE IF EXISTS `tb_products_category`;

CREATE TABLE `tb_products_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `p_category_id` bigint(20) DEFAULT NULL COMMENT '父类目ID',
  `category_name` varchar(200) NOT NULL COMMENT '类目名称',
  `is_online` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `category_sort` int(11) DEFAULT '0' COMMENT '类目排序',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品类目';

/*Data for the table `tb_products_category` */

/*Table structure for table `tb_products_sku` */

DROP TABLE IF EXISTS `tb_products_sku`;

CREATE TABLE `tb_products_sku` (
  `sku_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'sku_id',
  `spu_id` bigint(20) DEFAULT NULL COMMENT 'spu_id',
  `sku_name` varchar(200) NOT NULL COMMENT 'sku名称',
  `sku_original_price` double DEFAULT '0' COMMENT 'sku原价格',
  `sku_selling_price` double DEFAULT '0' COMMENT 'sku在售价格',
  `sku_desc` varchar(500) DEFAULT NULL COMMENT 'sku描述',
  `is_online` smallint(6) DEFAULT NULL COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `sku_sort` int(11) DEFAULT '0' COMMENT '排序',
  `sku_stocks` int(11) DEFAULT '0' COMMENT '库存',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品sku';

/*Data for the table `tb_products_sku` */

/*Table structure for table `tb_products_sku_value` */

DROP TABLE IF EXISTS `tb_products_sku_value`;

CREATE TABLE `tb_products_sku_value` (
  `sku_attribute_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'sku_attribute_id',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'sku_id',
  `value_id` bigint(20) DEFAULT NULL COMMENT '属性值ID',
  `是否上线` int(11) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`sku_attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性值关联表';

/*Data for the table `tb_products_sku_value` */

/*Table structure for table `tb_products_spu` */

DROP TABLE IF EXISTS `tb_products_spu`;

CREATE TABLE `tb_products_spu` (
  `spu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'spu_id',
  `spu_name` varchar(200) NOT NULL COMMENT 'spu名称',
  `category_id` bigint(20) NOT NULL COMMENT '类目ID',
  `spu_maintitle` varchar(200) DEFAULT NULL COMMENT 'spu主标题',
  `spu_subtitle` varchar(200) DEFAULT NULL COMMENT 'spu副标题',
  `is_online` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `spu_sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`spu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品spu';

/*Data for the table `tb_products_spu` */

/*Table structure for table `tb_products_spu_attribute` */

DROP TABLE IF EXISTS `tb_products_spu_attribute`;

CREATE TABLE `tb_products_spu_attribute` (
  `spu_attribute_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '属性-spu关联表id',
  `spu_id` bigint(20) DEFAULT NULL COMMENT 'spu_id',
  `attribute_id` bigint(20) DEFAULT NULL COMMENT '属性ID',
  `是否上线` smallint(6) DEFAULT '0' COMMENT '是否上线.0=是1=否',
  `created_time` date DEFAULT NULL COMMENT '创建时间',
  `updated_time` date DEFAULT NULL COMMENT '更新时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`spu_attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品spu属性关联表';

/*Data for the table `tb_products_spu_attribute` */

/*Table structure for table `tb_roles` */

DROP TABLE IF EXISTS `tb_roles`;

CREATE TABLE `tb_roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(200) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `role_desc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `is_hide` int(11) DEFAULT '0' COMMENT '是否隐藏（0=否，1=是）',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_CODE` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

/*Data for the table `tb_roles` */

insert  into `tb_roles`(`role_id`,`role_name`,`role_code`,`role_desc`,`sort`,`is_hide`,`created`,`updated`) values (1,'测试角色','001','测试角色',0,0,'2019-01-15','2019-01-15'),(2,'管理员角色','admin','管理员角色',0,0,'2019-01-15','2019-01-15'),(3,'测试1','1560137841684','测试1',3,0,'2019-06-10',NULL);

/*Table structure for table `tb_roles_menu` */

DROP TABLE IF EXISTS `tb_roles_menu`;

CREATE TABLE `tb_roles_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_roles_menu` */

insert  into `tb_roles_menu`(`id`,`role_id`,`auth_id`) values (1,1,3),(2,2,1),(3,1,4),(4,1,5),(5,1,6);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(150) NOT NULL COMMENT '用户名',
  `user_logo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `user_pwd` varchar(100) NOT NULL COMMENT '密码',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1=男，2=女）',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `blood_type` int(11) DEFAULT '6' COMMENT '血型（1=A，2=B，3=O，4=AB，5=其他，6=未知）',
  `birth_address` varchar(200) DEFAULT NULL COMMENT '出生地',
  `live_address` varchar(200) DEFAULT NULL COMMENT '居住地',
  `eduction` int(11) DEFAULT '1' COMMENT '教育程度（1=未知，2=初中，3=高中，4=大学，5=硕士，6=小学，7=中专/技校，8=大专，9=博士，10=其他）',
  `work` varchar(200) DEFAULT NULL COMMENT '当前职业',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `status` int(11) DEFAULT '1' COMMENT '状态(1=正常用户)',
  `regist_type` int(11) DEFAULT '1' COMMENT '注册类型(1=系统录入，2=注册)',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_user_name` (`user_name`),
  UNIQUE KEY `uk_user_phone` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`user_name`,`user_logo`,`user_pwd`,`user_phone`,`user_email`,`sex`,`birthday`,`blood_type`,`birth_address`,`live_address`,`eduction`,`work`,`sort`,`status`,`regist_type`,`created`,`updated`,`login_time`) values (1,'test','files/img/15517764589891.jpg','123','13800013800','970064181@qq.com',0,'2019-03-01 14:46:58',0,'string','string',0,'string',0,1,1,'2019-03-01 17:29:15',NULL,NULL),(6,'测试','files/img/15517764589891.jpg','123','13800013801','',2,NULL,1,'','',1,'',0,0,1,'2019-03-06 18:30:20',NULL,NULL),(7,'xiaoxiao ','','123','13700013700','',2,NULL,1,'','',1,'',0,0,1,'2019-03-11 16:07:39',NULL,NULL),(9,'test1','','','','',1,NULL,1,'','',1,'',0,0,1,'2019-03-19 12:57:20',NULL,NULL);

/*Table structure for table `tb_user_bak` */

DROP TABLE IF EXISTS `tb_user_bak`;

CREATE TABLE `tb_user_bak` (
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `user_name` varchar(150) NOT NULL COMMENT '用户名',
  `user_logo` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `user_pwd` varchar(100) NOT NULL COMMENT '密码',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1=男，2=女）',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `blood_type` int(11) DEFAULT '6' COMMENT '血型（1=A，2=B，3=O，4=AB，5=其他，6=未知）',
  `birth_address` varchar(200) DEFAULT NULL COMMENT '出生地',
  `live_address` varchar(200) DEFAULT NULL COMMENT '居住地',
  `eduction` int(11) DEFAULT '1' COMMENT '教育程度（1=未知，2=初中，3=高中，4=大学，5=硕士，6=小学，7=中专/技校，8=大专，9=博士，10=其他）',
  `work` varchar(200) DEFAULT NULL COMMENT '当前职业',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `status` int(11) DEFAULT '1' COMMENT '状态(1=正常用户)',
  `regist_type` int(11) DEFAULT '1' COMMENT '注册类型(1=系统录入，2=注册)',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '更新时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_user_bak` */

insert  into `tb_user_bak`(`user_id`,`user_name`,`user_logo`,`user_pwd`,`user_phone`,`user_email`,`sex`,`birthday`,`blood_type`,`birth_address`,`live_address`,`eduction`,`work`,`sort`,`status`,`regist_type`,`created`,`updated`,`login_time`) values (1,'test','files/img/15517764589891.jpg','123','13800013800','970064181@qq.com',0,'2019-03-01 14:46:58',0,'string','string',0,'string',0,1,1,'2019-03-01 17:29:15',NULL,NULL),(6,'测试','files/img/15517764589891.jpg','123','13800013801','',2,NULL,1,'','',1,'',0,0,1,'2019-03-06 18:30:20',NULL,NULL),(7,'xiaoxiao ','','123','13700013700','',2,NULL,1,'','',1,'',0,0,1,'2019-03-11 16:07:39',NULL,NULL),(9,'test1','','','','',1,NULL,1,'','',1,'',0,0,1,'2019-03-19 12:57:20',NULL,NULL);

/*Table structure for table `tb_user_roles` */

DROP TABLE IF EXISTS `tb_user_roles`;

CREATE TABLE `tb_user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_user_roles` */

insert  into `tb_user_roles`(`id`,`user_id`,`role_id`) values (1,1,1),(2,2,1),(3,1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
