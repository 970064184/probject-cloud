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
  `p_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_authority` */

insert  into `tb_authority`(`auth_id`,`auth_name`,`auth_logo`,`auth_url`,`auth_type`,`sort`,`is_hide`,`p_id`,`created`,`updated`) values (1,'用户管理','/','http://localhost:8761',2,1,0,NULL,'2018-10-12','2018-10-12'),(2,'权限管理','/','https://www.baidu.com/',2,2,0,NULL,'2018-11-14','2018-11-14'),(3,'测试API','/','/test',3,0,0,NULL,'2019-01-15','2019-01-15');

/*Table structure for table `tb_roles` */

DROP TABLE IF EXISTS `tb_roles`;

CREATE TABLE `tb_roles` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `role_name` varchar(200) NOT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `role_desc` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `is_hide` int(11) DEFAULT '0' COMMENT '是否隐藏（0=否，1=是）',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_CODE` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

/*Data for the table `tb_roles` */

insert  into `tb_roles`(`role_id`,`role_name`,`role_code`,`role_desc`,`sort`,`is_hide`,`created`,`updated`) values (1,'测试角色','001','测试角色',0,0,'2019-01-15','2019-01-15'),(2,'测试角色2','002','测试角色2',0,0,'2019-01-15','2019-01-15');

/*Table structure for table `tb_roles_menu` */

DROP TABLE IF EXISTS `tb_roles_menu`;

CREATE TABLE `tb_roles_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `auth_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_roles_menu` */

insert  into `tb_roles_menu`(`id`,`role_id`,`auth_id`) values (1,1,3),(2,2,1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(200) NOT NULL COMMENT '用户名',
  `user_pwd` varchar(100) NOT NULL COMMENT '密码',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `sort` tinyint(4) DEFAULT '0' COMMENT '排序',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态(1=正常用户)',
  `created` date DEFAULT NULL COMMENT '创建时间',
  `updated` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11112 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`user_name`,`user_pwd`,`user_phone`,`sort`,`status`,`created`,`updated`) values (1,'test','123','13800013800',0,1,'2019-01-03',NULL),(11111,'托尔斯泰','123','13800013801',0,1,'2019-01-08',NULL);

/*Table structure for table `tb_user_roles` */

DROP TABLE IF EXISTS `tb_user_roles`;

CREATE TABLE `tb_user_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_user_roles` */

insert  into `tb_user_roles`(`id`,`user_id`,`role_id`) values (1,1,1),(2,11111,2),(3,1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
