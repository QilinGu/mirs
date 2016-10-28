# 电影智能推荐系统的数据库

DROP DATABASE mirs;
CREATE DATABASE mirs;

USE mirs;

DROP TABLE IF EXISTS mirs_register_session;
CREATE TABLE mirs_register_session(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '注册会话编号',
  `create_time` DATETIME NOT NULL COMMENT '注册会话创建时间',
  `email` VARCHAR(200) NOT NULL COMMENT '验证成功邮件地址',
  `state` TINYINT NOT NULL DEFAULT 0 COMMENT '注册会话状态：0：正在注册;1：注册超时;2注册失败;4:注册成功',
  `client_ip` VARCHAR(15) COMMENT '客服端IP地址',
  `expire_time` DATETIME NOT NULL COMMENT '注册会话过期时间',
  PRIMARY KEY (id),
  INDEX idx_email_address(email)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '注册会话表';


DROP TABLE IF EXISTS mirs_email_verify;
CREATE TABLE mirs_email_verify(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '验证编号',
  `email` VARCHAR(200) NOT NULL COMMENT '验证邮箱地址',
  `create_time` DATETIME NOT NULL COMMENT '验证创建时间',
  `expire_time` DATETIME NOT NULL COMMENT '验证过期时间',
  `channel` TINYINT NOT NULL DEFAULT 0 COMMENT '验证渠道，默认为通过网站版验证',
  `verify_code` VARCHAR(10) NOT NULL COMMENT '验证码',
  `verify_type` TINYINT NOT NULL COMMENT '验证类型：0：注册;1：找回密码;2:异地登录',
  `request_ip` VARCHAR(15) COMMENT '请求IP',
  `state` TINYINT NOT NULL DEFAULT 0 COMMENT '验证状态：0:正在验证;1:验证超时;2:验证失败;3:验证成功',
  `parameter1` VARCHAR(200) COMMENT '额外参数1',
  `parameter2` VARCHAR(200) COMMENT '额外参数2',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '邮件验证表，验证登录注册，修改密码等';


DROP TABLE IF EXISTS mirs_email_template;
CREATE TABLE mirs_email_template(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '邮件模板编号',
  `title` VARCHAR(200) NOT NULL COMMENT '邮件模板标题',
  `content` TEXT NOT NULL COMMENT '邮件模板内容',
  `sort` INT NOT NULL DEFAULT 100 COMMENT '邮件模板排序',
  `description` VARCHAR(200) COMMENT '邮件模板描述',
  `unique_identity` VARCHAR(50) COMMENT '邮件模板唯一标识',
  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '邮件模板表，用来保存常用的邮件模板';


DROP TABLE IF EXISTS mirs_user;
CREATE TABLE mirs_user(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '用户唯一编号',
  `username` VARCHAR(100) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(128) COMMENT '密码',
  `salt` VARCHAR(128) COMMENT '盐值',
  `avatar` VARCHAR(100) COMMENT '用户头像地址',
  `email` VARCHAR(200) NOT NULL UNIQUE COMMENT '用户邮箱',
  `bio` VARCHAR(200) COMMENT '个人格言',
  `location` VARCHAR(100) COMMENT '地址',
  `university` VARCHAR(200) COMMENT '大学信息',
  `major` VARCHAR(100) COMMENT '专业信息',
  `state` TINYINT NOT NULL DEFAULT 0 COMMENT '用户状态：0：正常;1:停用',
  `last_login_time` DATETIME COMMENT '上次登录时间',
  `last_login_ip` VARCHAR(15) COMMENT '上次登录IP',
  `register_time` DATETIME COMMENT '注册时间',
  `register_ip` VARCHAR(15) COMMENT '注册IP',
  PRIMARY KEY (id),
  INDEX idx_user_name(username),
  INDEX idx_user_email(email)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户基本信息表';


DROP TABLE IF EXISTS mirs_oauth_user;
CREATE TABLE mirs_oauth_user(
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'OAuth编号',
  `u_id` INT NOT NULL COMMENT '用户编号',
  `oauth_type` VARCHAR(20) NOT NULL COMMENT 'OAuth认证方式',
  `oauth_id` VARCHAR(128) NOT NULL COMMENT '第三方返回的oauth_id',
  `oauth_access_token` VARCHAR(256) NOT NULL COMMENT '第三方返回的接口调用凭证',
  `oauth_expires` INT COMMENT 'access_token接口调用凭证超时时间，单位（秒）',
  `oauth_scope` VARCHAR(256) COMMENT '用户授权的作用域，使用逗号（,）分隔',
  PRIMARY KEY (id),
  INDEX idx_u_id(u_id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户第三方授权信息表';




















