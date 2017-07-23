use dolphin;

drop table if exists user;
create table `user` (
  `id` int(11) not null comment '主键',
  `user_code` varchar(32) default null comment '用户编码',
  `username` varchar(32) not null comment '用户名',
  `password` varchar(32) not null comment '登录密码',
  `delete_flag` int(1) default 0 comment '删除标志',
  `create_time` datetime default null comment '创建时间',
  `update_time` datetime default null comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment '用户信息表';

drop table if exists project;
create table `project` (
  `id` int(11) not null comment '主键',
  `proj_code` varchar(32) default null comment '项目编码',
  `proj_name` varchar(32) default null comment '项目名称',
  `owner_id` int(11) default null comment '主键',
  `dev_version` int(11) default 0 comment '开发版本号',
  `prod_version` int(11) default 0 comment '生产版本号',
  `test_version` int(11) default 0 comment '测试版本号',
  `delete_flag` int(1) default 0 comment '删除标志',
  `create_time` datetime default null comment '创建时间',
  `update_time` datetime default null comment '更新时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment '项目配置表';

drop table if exists project_user;
create table `project_user` (
  `proj_id` int(11) not null comment '项目id',
  `user_id` int(11) not null default 0 comment '用户id',
  primary key (`proj_id`,`user_id`)
) engine=innodb default charset=utf8 comment '项目用户关联表';

drop table if exists project_module;
create table `project_module` (
  `module_id` int(11) not null comment '主键',
  `proj_id` int(11) not null comment '项目id',
  `module_name` varchar(32) default null comment '模块id',
  primary key (`module_id`)
) engine=innodb default charset=utf8 comment '项目模块表';

drop table if exists project_user_role;
create table `project_user_role` (
  `proj_id` int(11) not null comment '主键',
  `user_id` int(11) not null comment '用户id',
  `role_code` varchar(32) not null  comment '角色编码',
  primary key (`proj_id`,`user_id`,`role_code`)
) engine=innodb default charset=utf8 comment '用户角色';

drop table if exists project_config;
create table `project_config` (
  `config_id` int(11) not null comment '主键',
  `config_key` varchar(64) not null comment '配置的key',
  `config_value` varchar(256) not null comment '配置的value',
  `config_desc` varchar(256) default null comment '配置项的描述',
  `proj_id` int(11) not null comment '项目id',
  `module_id` int(11) not null comment '模块id',
  `delete_flag` int(1) default 0 comment '删除标志',
  `opt_user` varchar(32) default null comment '主键',
  `opt_time` datetime default null comment '主键',
  `prod_value` varchar(256) not null comment '主键',
  `prod_user` varchar(32) default null comment '主键',
  `prod_time` datetime default null comment '主键',
  `test_value` varchar(256) not null comment '主键',
  `test_user` varchar(32) default null comment '主键',
  `test_time` datetime default null comment '主键',
  `build_value` varchar(256) not null comment '主键',
  `build_user` varchar(32) default null comment '主键',
  `build_time` datetime default null comment '',
  primary key (`config_id`)
) engine=innodb default charset=utf8 comment '项目配置表';
