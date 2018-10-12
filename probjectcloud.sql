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

insert  into `tb_menu`(`id`,`name`,`logo`,`url`,`sort`,`is_hide`,`p_id`,`created`,`updated`) values (1,'用户管理','/','/',1,0,NULL,'2018-10-12','2018-10-12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
