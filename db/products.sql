/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/8/7 14:41:54                            */
/*==============================================================*/


drop table if exists tb_brand;

drop table if exists tb_products_attribute;

drop table if exists tb_products_attribute_value;

drop table if exists tb_products_category;

drop table if exists tb_products_sku;

drop table if exists tb_products_sku_value;

drop table if exists tb_products_spu;

drop table if exists tb_products_spu_attribute;

/*==============================================================*/
/* Table: tb_brand                                              */
/*==============================================================*/
create table tb_brand
(
   brand_id             bigint not null auto_increment comment 'brand_id',
   brand_ch_name        varchar(200) comment '品牌中文名称',
   brand_en_name        varchar(200) comment '品牌英文名称',
   brand_logo           varchar(500) comment '品牌logo',
   is_online            smallint default 0 comment '是否上线.0=是1=否',
   brand_sort           int default 0 comment '排序',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   brand_place          varchar(200) comment '产地',
   brand_remarks        varchar(500) comment '备注',
   primary key (brand_id)
);

alter table tb_brand comment '品牌表';

/*==============================================================*/
/* Table: tb_products_attribute                                 */
/*==============================================================*/
create table tb_products_attribute
(
   attribute_id         bigint not null auto_increment comment '属性ID',
   category_id          bigint comment '最小分类的类目ID',
   attribute_name       varchar(100) comment '属性名称',
   is_online            smallint default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   attribute_sort       int default 0 comment '属性排序',
   primary key (attribute_id)
);

alter table tb_products_attribute comment '商品属性';

/*==============================================================*/
/* Table: tb_products_attribute_value                           */
/*==============================================================*/
create table tb_products_attribute_value
(
   value_id             bigint not null comment '属性值ID',
   attribute_id         bigint comment '属性ID',
   attribute_value      varchar(100) not null comment '属性值',
   is_online            smallint default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   value_sort           int default 0 comment '属性值排序',
   primary key (value_id)
);

alter table tb_products_attribute_value comment '商品属性值';

/*==============================================================*/
/* Table: tb_products_category                                  */
/*==============================================================*/
create table tb_products_category
(
   category_id          bigint not null auto_increment comment '类目ID',
   p_category_id        bigint comment '父类目ID',
   category_name        varchar(200) not null comment '类目名称',
   is_online            smallint default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   category_sort        int default 0 comment '类目排序',
   primary key (category_id)
);

alter table tb_products_category comment '商品类目';

/*==============================================================*/
/* Table: tb_products_sku                                       */
/*==============================================================*/
create table tb_products_sku
(
   sku_id               bigint not null auto_increment comment 'sku_id',
   spu_id               bigint comment 'spu_id',
   sku_name             varchar(200) not null comment 'sku名称',
   sku_original_price   double default 0 comment 'sku原价格',
   sku_selling_price    double default 0 comment 'sku在售价格',
   sku_desc             varchar(500) comment 'sku描述',
   is_online            smallint comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   sku_sort             int default 0 comment '排序',
   sku_stocks           int default 0 comment '库存',
   primary key (sku_id)
);

alter table tb_products_sku comment '商品sku';

/*==============================================================*/
/* Table: tb_products_sku_value                                 */
/*==============================================================*/
create table tb_products_sku_value
(
   sku_attribute_id     bigint not null auto_increment comment 'sku_attribute_id',
   sku_id               bigint comment 'sku_id',
   value_id             bigint comment '属性值ID',
   是否上线                 int default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   sort                 int default 0 comment '排序',
   primary key (sku_attribute_id)
);

alter table tb_products_sku_value comment '商品属性值关联表';

/*==============================================================*/
/* Table: tb_products_spu                                       */
/*==============================================================*/
create table tb_products_spu
(
   spu_id               bigint not null auto_increment comment 'spu_id',
   spu_name             varchar(200) not null comment 'spu名称',
   category_id          bigint not null comment '类目ID',
   spu_maintitle        varchar(200) comment 'spu主标题',
   spu_subtitle         varchar(200) comment 'spu副标题',
   is_online            smallint default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   spu_sort             int default 0 comment '排序',
   primary key (spu_id)
);

alter table tb_products_spu comment '商品spu';

/*==============================================================*/
/* Table: tb_products_spu_attribute                             */
/*==============================================================*/
create table tb_products_spu_attribute
(
   spu_attribute_id     bigint not null auto_increment comment '属性-spu关联表id',
   spu_id               bigint comment 'spu_id',
   attribute_id         bigint comment '属性ID',
   是否上线                 smallint default 0 comment '是否上线.0=是1=否',
   created_time         date comment '创建时间',
   updated_time         date comment '更新时间',
   sort                 int default 0 comment '排序',
   primary key (spu_attribute_id)
);

alter table tb_products_spu_attribute comment '商品spu属性关联表';

