create table test.bigtable
(
    id       int auto_increment comment '主键'
        primary key,
    name     varchar(50)  not null comment '姓名',
    gender   smallint     not null comment '性别',
    type     smallint     not null comment '类型',
    phone    varchar(30)  null comment '电话号码',
    email    varchar(100) null comment 'email',
    province smallint     null comment '省',
    city     smallint     null comment '市',
    address  varchar(200) null comment '地址',
    `desc`   varchar(300) null comment '简介'
)
    comment '千万级大表';