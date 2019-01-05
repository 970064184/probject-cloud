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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`user_name`,`user_pwd`,`user_phone`,`sort`,`status`,`created`,`updated`) values (1,'test','123','13800013800',0,1,'2019-01-03',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
