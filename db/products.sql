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
   brand_ch_name        varchar(200) comment 'Ʒ����������',
   brand_en_name        varchar(200) comment 'Ʒ��Ӣ������',
   brand_logo           varchar(500) comment 'Ʒ��logo',
   is_online            smallint default 0 comment '�Ƿ�����.0=��1=��',
   brand_sort           int default 0 comment '����',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   brand_place          varchar(200) comment '����',
   brand_remarks        varchar(500) comment '��ע',
   primary key (brand_id)
);

alter table tb_brand comment 'Ʒ�Ʊ�';

/*==============================================================*/
/* Table: tb_products_attribute                                 */
/*==============================================================*/
create table tb_products_attribute
(
   attribute_id         bigint not null auto_increment comment '����ID',
   category_id          bigint comment '��С�������ĿID',
   attribute_name       varchar(100) comment '��������',
   is_online            smallint default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   attribute_sort       int default 0 comment '��������',
   primary key (attribute_id)
);

alter table tb_products_attribute comment '��Ʒ����';

/*==============================================================*/
/* Table: tb_products_attribute_value                           */
/*==============================================================*/
create table tb_products_attribute_value
(
   value_id             bigint not null comment '����ֵID',
   attribute_id         bigint comment '����ID',
   attribute_value      varchar(100) not null comment '����ֵ',
   is_online            smallint default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   value_sort           int default 0 comment '����ֵ����',
   primary key (value_id)
);

alter table tb_products_attribute_value comment '��Ʒ����ֵ';

/*==============================================================*/
/* Table: tb_products_category                                  */
/*==============================================================*/
create table tb_products_category
(
   category_id          bigint not null auto_increment comment '��ĿID',
   p_category_id        bigint comment '����ĿID',
   category_name        varchar(200) not null comment '��Ŀ����',
   is_online            smallint default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   category_sort        int default 0 comment '��Ŀ����',
   primary key (category_id)
);

alter table tb_products_category comment '��Ʒ��Ŀ';

/*==============================================================*/
/* Table: tb_products_sku                                       */
/*==============================================================*/
create table tb_products_sku
(
   sku_id               bigint not null auto_increment comment 'sku_id',
   spu_id               bigint comment 'spu_id',
   sku_name             varchar(200) not null comment 'sku����',
   sku_original_price   double default 0 comment 'skuԭ�۸�',
   sku_selling_price    double default 0 comment 'sku���ۼ۸�',
   sku_desc             varchar(500) comment 'sku����',
   is_online            smallint comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   sku_sort             int default 0 comment '����',
   sku_stocks           int default 0 comment '���',
   primary key (sku_id)
);

alter table tb_products_sku comment '��Ʒsku';

/*==============================================================*/
/* Table: tb_products_sku_value                                 */
/*==============================================================*/
create table tb_products_sku_value
(
   sku_attribute_id     bigint not null auto_increment comment 'sku_attribute_id',
   sku_id               bigint comment 'sku_id',
   value_id             bigint comment '����ֵID',
   �Ƿ�����                 int default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   sort                 int default 0 comment '����',
   primary key (sku_attribute_id)
);

alter table tb_products_sku_value comment '��Ʒ����ֵ������';

/*==============================================================*/
/* Table: tb_products_spu                                       */
/*==============================================================*/
create table tb_products_spu
(
   spu_id               bigint not null auto_increment comment 'spu_id',
   spu_name             varchar(200) not null comment 'spu����',
   category_id          bigint not null comment '��ĿID',
   spu_maintitle        varchar(200) comment 'spu������',
   spu_subtitle         varchar(200) comment 'spu������',
   is_online            smallint default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   spu_sort             int default 0 comment '����',
   primary key (spu_id)
);

alter table tb_products_spu comment '��Ʒspu';

/*==============================================================*/
/* Table: tb_products_spu_attribute                             */
/*==============================================================*/
create table tb_products_spu_attribute
(
   spu_attribute_id     bigint not null auto_increment comment '����-spu������id',
   spu_id               bigint comment 'spu_id',
   attribute_id         bigint comment '����ID',
   �Ƿ�����                 smallint default 0 comment '�Ƿ�����.0=��1=��',
   created_time         date comment '����ʱ��',
   updated_time         date comment '����ʱ��',
   sort                 int default 0 comment '����',
   primary key (spu_attribute_id)
);

alter table tb_products_spu_attribute comment '��Ʒspu���Թ�����';

