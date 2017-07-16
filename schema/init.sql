USE phoenix;

DROP TABLE IF EXISTS user;
create table `user` (
  `id` int(11) not null,
  `user_code` varchar(32) default null,
  `username` varchar(32) not null,
  `password` varchar(32) not null,
  `delete_flag` int(1) default 0,
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

DROP TABLE IF EXISTS project;
create table `project` (
  `id` int(11) not null,
  `proj_code` varchar(32) default null,
  `proj_name` varchar(32) default null,
  `owner_id` int(11) default null,
  `dev_version` int(11) default 0,
  `prod_version` int(11) default 0,
  `test_version` int(11) default 0,
  `delete_flag` int(1) default 0,
  `create_time` datetime default null,
  `update_time` datetime default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

DROP TABLE IF EXISTS project_user;
create table `project_user` (
  `proj_id` int(11) not null,
  `user_id` int(11) not null default 0,
  primary key (`proj_id`,`user_id`)
) engine=innodb default charset=utf8;

DROP TABLE IF EXISTS project_module;
create table `project_module` (
  `module_id` int(11) not null,
  `proj_id` int(11) not null,
  `module_name` varchar(32) default null,
  primary key (`module_id`)
) engine=innodb default charset=utf8;

drop TABLE IF EXISTS project_user_role;
create table `project_user_role` (
  `proj_id` int(11) not null,
  `user_id` int(11) not null,
  `role_code` varchar(32) not null,
  primary key (`proj_id`,`user_id`,`role_code`)
) engine=innodb default charset=utf8;

DROP TABLE IF EXISTS project_config;
create table `project_config` (
  `config_id` int(11) not null,
  `config_key` varchar(64) not null,
  `config_value` varchar(256) not null,
  `config_desc` varchar(256) default null,
  `proj_id` int(11) not null,
  `module_id` int(11) not null,
  `delete_flag` int(1) default 0,
  `opt_user` varchar(32) default null,
  `opt_time` datetime default null,
  `prod_value` varchar(256) not null,
  `prod_user` varchar(32) default null,
  `prod_time` datetime default null,
  `test_value` varchar(256) not null,
  `test_user` varchar(32) default null,
  `test_time` datetime default null,
  `build_value` varchar(256) not null,
  `build_user` varchar(32) default null,
  `build_time` datetime default null,
  primary key (`config_id`)
) engine=innodb default charset=utf8;
