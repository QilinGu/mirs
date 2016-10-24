# 电影智能推荐系统的数据库

DROP DATABASE mirs;
CREATE DATABASE mirs;

USE mirs;

DROP TABLE IF EXISTS mirs_register_session;
CREATE TABLE mirs_register_session(
  `rgst_id` INT NOT NULL AUTO_INCREMENT COMMENT '注册会话编号',
  `rgst_create_time` DATETIME NOT NULL COMMENT '注册会话创建时间',
  `rgst_email` VARCHAR(200) NOT NULL COMMENT '验证成功邮件地址',
  `rgst_state` TINYINT NOT NULL DEFAULT 0 COMMENT '注册会话状态：0：正在注册;-1：注册超时;-2注册失败;1:注册成功',
  `rgst_client_id_address` VARCHAR(15) COMMENT '客服端IP地址',
  `rgst_expire_time` DATETIME NOT NULL COMMENT '注册会话过期时间',
  PRIMARY KEY (rgst_id),
  INDEX idx_rgst_email_address(rgst_email)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '注册会话表';


DROP TABLE IF EXISTS mirs_email_verify;
CREATE TABLE mirs_email_verify(
  `vrf_id` INT NOT NULL AUTO_INCREMENT COMMENT '验证编号',
  `vrf_email` VARCHAR(200) NOT NULL COMMENT '验证邮箱地址',
  `vrf_create_time` DATETIME NOT NULL COMMENT '验证创建时间',
  `vrf_expirt_time` DATETIME NOT NULL COMMENT '验证过期时间',
  `vrf_channel` TINYINT NOT NULL DEFAULT 0 COMMENT '验证渠道，默认为通过网站版验证',
  `vrf_verify_code` VARCHAR(10) NOT NULL COMMENT '验证码',
  `vrf_verify_type` TINYINT NOT NULL COMMENT '验证类型：0：注册;1：找回密码;2:异地登录',
  'vrf_request_id' VARCHAR(15) COMMENT '请求IP',
  `vrf_state` TINYINT NOT NULL DEFAULT 0 COMMENT '验证状态：0:正在验证;-1:验证超时;-2:验证失败;1:验证成功',
  'vrf_parameter1' VARCHAR(200) COMMENT '额外参数1',
  'vrf_parameter2' VARCHAR(200) COMMENT '额外参数2',
  PRIMARY KEY (vrf_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '邮件验证表，验证登录注册，修改密码等';


DROP TABLE IF EXISTS mirs_email_template;
CREATE TABLE mirs_email_template(
  `et_id` INT NOT NULL AUTO_INCREMENT COMMENT '邮件模板编号',
  `et_title` VARCHAR(200) NOT NULL COMMENT '邮件模板标题',
  `et_content` TEXT NOT NULL COMMENT '邮件模板内容',
  `et_sort` INT NOT NULL DEFAULT 100 COMMENT '邮件模板排序',
  `et_description` VARCHAR(200) COMMENT '邮件模板描述',
  `et_unique_identity` VARCHAR(50) CHARSET '邮件模板唯一标识',
  PRIMARY KEY (et_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '邮件模板表，用来保存常用的邮件模板';


DROP TABLE IF EXISTS mirs_user_info;
CREATE TABLE mirs_user_info(
  `u_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户唯一编号',
  `u_user_name` VARCHAR(100) NOT NULL UNIQUE COMMENT '用户名',
  `u_password` VARCHAR(128) NOT NULL COMMENT '密码',
  `u_avatar` VARCHAR(100) COMMENT '用户头像地址',
  `u_email` VARCHAR(200) NOT NULL UNIQUE COMMENT '用户邮箱',
  `u_bio` VARCHAR(200) COMMENT '个人格言',
  `u_location` VARCHAR(100) COMMENT '地址',
  `u_university` VARCHAR(200) COMMENT '大学信息',
  `u_major` VARCHAR(100) COMMENT '专业信息',
  `u_state` TINYINT NOT NULL DEFAULT 0 COMMENT '用户状态：0：正常;1:停用',
  `u_last_login_time` DATETIME COMMENT '上次登录时间',
  `u_last_login_ip` VARCHAR(15) COMMENT '上次登录IP',
  `u_register_time` DATETIME COMMENT '注册时间',
  `u_register_ip` VARCHAR(15) COMMENT '注册IP',
  PRIMARY KEY (u_id),
  INDEX idx_user_name(u_user_name),
  INDEX idx_user_email(u_email)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户基本信息表';


DROP TABLE IF EXISTS mirs_user_oauth;
CREATE TABLE mirs_user_oauth(
  `uo_id` INT NOT NULL AUTO_INCREMENT COMMENT 'OAuth编号',
  `uo_u_id` INT NOT NULL COMMENT '用户编号',
  `uo_oauth_type` VARCHAR(20) NOT NULL COMMENT 'OAuth认证方式',
  `uo_oauth_id` VARCHAR(128) NOT NULL COMMENT '第三方返回的oauth_id',
  `uo_oauth_access_token` VARCHAR(256) NOT NULL COMMENT '第三方返回的接口调用凭证',
  `uo_oauth_expires` INT COMMENT 'access_token接口调用凭证超时时间，单位（秒）',
  `uo_oauth_scope` VARCHAR(256) COMMENT '用户授权的作用域，使用逗号（,）分隔'
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户第三方授权信息表';




















