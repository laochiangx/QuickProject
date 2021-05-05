/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : sys_admin

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-05-05 17:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_name` varchar(100) DEFAULT NULL COMMENT '任务名',
  `description` varchar(100) DEFAULT NULL COMMENT '任务描述',
  `cron` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `bean_name` varchar(100) DEFAULT NULL COMMENT '任务执行时调用的spring的bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '任务方法名',
  `status` varchar(1) DEFAULT NULL COMMENT '任务状态（1运行中 2暂停中 3未启动)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='quartz定时任务表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('21', '我的任务', '我的新任务', '0/2 * * * * ?', 'myWebJob', 'abc', '2', '2021-05-05 10:38:20', '2021-05-05 10:20:39');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` varchar(1) DEFAULT NULL COMMENT '日志类型 1:用户日志 2菜单日志 3角色日志',
  `title` varchar(30) DEFAULT NULL COMMENT '日志标题',
  `ip` varchar(30) DEFAULT NULL COMMENT '操作ip地址',
  `addr` varchar(25) DEFAULT NULL COMMENT '操作地址',
  `request_uri` varchar(30) DEFAULT NULL COMMENT '请求uri',
  `method` varchar(10) DEFAULT NULL COMMENT '请求方式(POST,GET,PUT,DELETE)',
  `params` varchar(100) DEFAULT NULL COMMENT '请求提交参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时间',
  `response` text COMMENT '响应数据',
  `create_by` varchar(20) DEFAULT NULL COMMENT '操作人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除,1已删0未删',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('129', '2', '更新菜单信息', '127.0.0.1', '内网IP', '/system/menu', 'PUT', '', '16', '{\"status\":200,\"message\":\"ok\",\"data\":{\"id\":46,\"title\":\"任务管理\",\"name\":\"systemJob\",\"permission\":\"sys:job:list\",\"type\":1,\"path\":\"job\",\"icon\":\"chart\",\"sort\":9,\"pId\":40,\"tId\":0,\"mType\":1}}', 'admin', '2021-04-26 17:33:59', '2021-04-26 17:33:59', '0', '1');
INSERT INTO `sys_log` VALUES ('130', '0', '登录系统', '127.0.0.1', '内网IP', '/auth/login', 'POST', '', '178', '{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6IjIzZWMxNmUyLWI0ZjYtNDk2MC1iOGJhLTI1YTZmM2ZhOGEyNyIsInVzZXJuYW1lIjoiYWRtaW4ifQ.y3MREMlH85N2K7kzXWhexnGJAYhdT6t8m4wwTooAOUk\",\"login_in\":1619271630000,\"expires_in\":1620567630000}', 'admin', '2021-04-27 09:12:02', '2021-04-27 09:12:02', '0', '1');
INSERT INTO `sys_log` VALUES ('131', '0', '登录系统', '127.0.0.1', '内网IP', '/auth/login', 'POST', '', '7', '{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6IjIzZWMxNmUyLWI0ZjYtNDk2MC1iOGJhLTI1YTZmM2ZhOGEyNyIsInVzZXJuYW1lIjoiYWRtaW4ifQ.y3MREMlH85N2K7kzXWhexnGJAYhdT6t8m4wwTooAOUk\",\"login_in\":1619271630000,\"expires_in\":1620567630000}', 'admin', '2021-04-27 16:49:36', '2021-04-27 16:49:36', '0', '1');
INSERT INTO `sys_log` VALUES ('132', '0', '登录系统', '127.0.0.1', '内网IP', '/auth/login', 'POST', '', '5922', '{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6IjI1ZjlkNzM4LTU4NjUtNDRhMy1iZTk3LTU2MzYyODllMGE4NCIsInVzZXJuYW1lIjoiYWRtaW4ifQ.3b4rfguBko1jiSMhpkKgu-j4a8yu22ET5OL6fj8caWQ\",\"login_in\":1619681176055,\"expires_in\":1620977174169}', 'admin', '2021-04-29 15:26:14', '2021-04-29 15:26:14', '0', '1');
INSERT INTO `sys_log` VALUES ('133', '0', '登录系统', '127.0.0.1', '内网IP', '/auth/login', 'POST', '', '6420', '{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJ0b2tlbiI6IjUzNmJjMjBiLWE1N2UtNDNkYy1hODEyLTgzNzllMzYxMzQ3OCIsInVzZXJuYW1lIjoiYWRtaW4ifQ.7AnmKk24TwtcC6jC64pHE7cLkr7NA-2SvBVAeG3ukVA\",\"login_in\":1620205772414,\"expires_in\":1621501770594}', 'admin', '2021-05-05 17:09:31', '2021-05-05 17:09:31', '0', '1');
INSERT INTO `sys_log` VALUES ('134', '1', '刪除用户', '127.0.0.1', '内网IP', '/system/user/10', 'DELETE', '', '52', '{\"status\":200,\"message\":\"ok\",\"data\":null}', 'admin', '2021-05-05 17:15:27', '2021-05-05 17:15:27', '0', '1');
INSERT INTO `sys_log` VALUES ('135', '1', '刪除用户', '127.0.0.1', '内网IP', '/system/user/8', 'DELETE', '', '32', '{\"status\":200,\"message\":\"ok\",\"data\":null}', 'admin', '2021-05-05 17:15:30', '2021-05-05 17:15:30', '0', '1');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'menu id',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '唯一，找路由使用',
  `permission` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限标识',
  `p_id` int(11) NOT NULL DEFAULT '0' COMMENT '父类id，默认0（第一级）',
  `t_id` int(11) NOT NULL DEFAULT '0' COMMENT '顶部id，默认0',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1：菜单，2：按钮',
  `m_type` int(11) NOT NULL DEFAULT '1' COMMENT '1：左侧菜单，2：顶部菜单',
  `path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '路径，一级加/，其他不要加/',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='系统-菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '首页', null, 'index', '0', '12', '1', '1', '/index', 'home', '1', '/');
INSERT INTO `sys_menu` VALUES ('2', '控制台', 'dashboard', 'dashboard', '1', '0', '1', '1', 'console', 'home', '0', '/');
INSERT INTO `sys_menu` VALUES ('3', '系统用户', null, 'sys:user:index', '0', '11', '1', '1', '/system', 'system-user', '3', '/');
INSERT INTO `sys_menu` VALUES ('4', '用户管理', 'systemUser', 'sys:user:list', '3', '0', '1', '1', 'user', 'system-user', '0', '/');
INSERT INTO `sys_menu` VALUES ('5', '权限中心', null, 'sys:permission:index', '0', '11', '1', '1', '/permission', 'permission', '4', '/');
INSERT INTO `sys_menu` VALUES ('6', '角色管理', 'systemRole', 'sys:role:list', '5', '0', '1', '1', 'role', 'role', '0', '/');
INSERT INTO `sys_menu` VALUES ('7', '菜单管理', 'systemMenu', 'sys:menu:list', '5', '0', '1', '1', 'menu', 'menu', '0', '/');
INSERT INTO `sys_menu` VALUES ('11', '系统配置', null, 'top:user:center', '0', '0', '1', '2', '/top2', 'system-config', '2', '/');
INSERT INTO `sys_menu` VALUES ('12', '业务系统', null, 'top:biz:center', '0', '0', '1', '2', '/top1', 'biz', '1', '/');
INSERT INTO `sys_menu` VALUES ('14', '顶部菜单', '', 'top:test:1', '0', '0', '1', '2', '/top3', 'menu', '3', '/');
INSERT INTO `sys_menu` VALUES ('15', '测试1', 'test1', 'top:test:1:1', '14', '0', '1', '2', 'test1', 'test', '1', '/');
INSERT INTO `sys_menu` VALUES ('16', '测试2', 'test2', 'top:test:1:2', '14', '0', '1', '2', 'test2', 'test', '2', '/');
INSERT INTO `sys_menu` VALUES ('19', '增加菜单', null, 'sys:menu:add', '7', '0', '2', '1', null, null, '0', '/');
INSERT INTO `sys_menu` VALUES ('20', '删除菜单', null, 'sys:menu:del', '7', '0', '2', '1', null, null, '0', '/');
INSERT INTO `sys_menu` VALUES ('21', '修改菜单', null, 'sys:menu:update', '7', '0', '2', '1', null, null, '0', '/');
INSERT INTO `sys_menu` VALUES ('23', '增加用户', null, 'sys:user:add', '4', '0', '2', '1', '', 'system-user', '0', '/');
INSERT INTO `sys_menu` VALUES ('24', '删除用户', null, 'sys:user:del', '4', '0', '2', '1', '', 'role', '0', '/');
INSERT INTO `sys_menu` VALUES ('25', '修改用户', null, 'sys:user:update', '4', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('26', '增加角色', null, 'sys:role:add', '6', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('27', '删除角色', null, 'sys:role:del', '6', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('28', '修改角色', null, 'sys:role:update', '6', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('29', '启用禁用', null, 'sys:user:enable', '4', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('30', '启用禁用', null, 'sys:role:enable', '6', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('32', '租户管理', 'systemTenant', 'sys:tenant:list', '3', '0', '1', '1', 'tenant', 'tenant', '5', '/');
INSERT INTO `sys_menu` VALUES ('33', '增加租户', null, 'sys:tenant:add', '32', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('34', '删除租户', null, 'sys:tenant:del', '32', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('35', '修改租户', null, 'sys:tenant:update', '32', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('36', '部门管理', 'systemOrg', 'sys:org:list', '5', '0', '1', '1', 'org', 'peoples', '1', '/');
INSERT INTO `sys_menu` VALUES ('37', '增加部门', null, 'sys:org:add', '36', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('38', '修改部门', null, 'sys:org:update', '36', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('39', '删除部门', null, 'sys:org:del', '36', '0', '2', '1', '', '', '0', '/');
INSERT INTO `sys_menu` VALUES ('40', '系统监控', 'monitor', 'sys:monitor:index', '0', '11', '1', '1', '/monitor', 'system-permission', '5', '/');
INSERT INTO `sys_menu` VALUES ('41', '日志管理', 'systemLog', 'sys:log:list', '40', '0', '1', '1', 'log', 'biz', '0', '/');
INSERT INTO `sys_menu` VALUES ('43', '删除日志', null, 'sys:log:del', '41', '0', '2', '1', '', '', '0', null);
INSERT INTO `sys_menu` VALUES ('46', '任务管理', 'systemJob', 'sys:job:list', '40', '0', '1', '1', 'job', 'chart', '9', null);
INSERT INTO `sys_menu` VALUES ('47', 'JVM信息管理', 'systemJvm', 'sys:jvm:list', '40', '0', '1', '1', 'jvm', 'dashboard', '2', null);
INSERT INTO `sys_menu` VALUES ('48', 'MBeans', 'systemMBeans', 'sys:beans:list', '40', '0', '1', '1', 'beans', 'system-menu', '3', null);

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `org_pid` int(11) DEFAULT NULL COMMENT '父节点id',
  `org_pids` varchar(20) DEFAULT NULL COMMENT '所有的父节点',
  `is_leaf` int(2) DEFAULT NULL COMMENT '是否叶子节点',
  `org_name` varchar(20) DEFAULT NULL COMMENT '组织机构名称',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `status` int(2) DEFAULT '1' COMMENT '状态,1启用0无效',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `level` int(4) DEFAULT NULL COMMENT '菜单的层级',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` int(2) DEFAULT '0' COMMENT '是否删除,1已删0未删',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '0', '0', '0', 'cup总部', '北京海淀', '1', '1', '1', '2021-05-05 00:34:37', '2021-05-05 17:12:52', '0', '1');
INSERT INTO `sys_org` VALUES ('2', '1', '1', '0', '研发部', '北京海淀', '1', '1', '2', '2021-05-05 00:36:31', '2021-05-05 17:12:57', '0', '1');
INSERT INTO `sys_org` VALUES ('3', '2', '1,2', '1', '研发一部', '北京海淀', '1', '1', '3', '2021-05-05 00:37:36', '2021-05-05 17:13:01', '0', '1');
INSERT INTO `sys_org` VALUES ('4', '2', '1,2', '1', '研发二部', '北京海淀', '1', '2', '3', '2021-05-05 00:38:09', '2021-05-05 17:13:03', '0', '1');
INSERT INTO `sys_org` VALUES ('5', '0', null, '1', '测试机构', '1', '1', '3', '1', '2021-05-05 14:48:15', '2021-05-05 17:13:09', '0', '1');
INSERT INTO `sys_org` VALUES ('6', '1', '1', '1', '业务部', '北京海淀', '1', '1', '2', '2021-05-05 14:52:36', '2021-05-05 14:52:36', '0', '1');

-- ----------------------------
-- Table structure for sys_org_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_org_user`;
CREATE TABLE `sys_org_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `org_pid` int(11) DEFAULT NULL COMMENT '父节点id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所有的父节点',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='组织机构表';

-- ----------------------------
-- Records of sys_org_user
-- ----------------------------
INSERT INTO `sys_org_user` VALUES ('1', '6', '1', '1');
INSERT INTO `sys_org_user` VALUES ('7', '1', '8', '1');
INSERT INTO `sys_org_user` VALUES ('8', '3', '10', '1');
INSERT INTO `sys_org_user` VALUES ('9', '2', '2', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色英文名称',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `status` int(2) DEFAULT '1' COMMENT '状态,1可用0不可用',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` int(2) DEFAULT '0' COMMENT '是否删除,1已删0未删',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `update_user_name` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '1', '1', '2021-05-05 17:13:43', '2021-05-05 00:32:26', '1', '1', '管理员描述', 'admin');
INSERT INTO `sys_role` VALUES ('2', '普通用户', 'common', '2', '1', '2021-05-05 17:13:47', '2021-05-05 00:33:15', '1', '1', '普通用户', 'admin');
INSERT INTO `sys_role` VALUES ('11', '测试', null, null, '1', '2021-05-05 15:31:11', '2021-05-05 14:21:56', '1', '1', 'C测试', null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1552 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('976', '11', '1', '0');
INSERT INTO `sys_role_menu` VALUES ('977', '11', '2', '0');
INSERT INTO `sys_role_menu` VALUES ('1408', '2', '3', '0');
INSERT INTO `sys_role_menu` VALUES ('1409', '2', '4', '0');
INSERT INTO `sys_role_menu` VALUES ('1410', '2', '25', '0');
INSERT INTO `sys_role_menu` VALUES ('1411', '2', '29', '0');
INSERT INTO `sys_role_menu` VALUES ('1412', '2', '23', '0');
INSERT INTO `sys_role_menu` VALUES ('1413', '2', '24', '0');
INSERT INTO `sys_role_menu` VALUES ('1414', '2', '5', '0');
INSERT INTO `sys_role_menu` VALUES ('1415', '2', '6', '0');
INSERT INTO `sys_role_menu` VALUES ('1416', '2', '30', '0');
INSERT INTO `sys_role_menu` VALUES ('1417', '2', '28', '0');
INSERT INTO `sys_role_menu` VALUES ('1418', '2', '27', '0');
INSERT INTO `sys_role_menu` VALUES ('1419', '2', '26', '0');
INSERT INTO `sys_role_menu` VALUES ('1420', '2', '19', '0');
INSERT INTO `sys_role_menu` VALUES ('1421', '2', '20', '0');
INSERT INTO `sys_role_menu` VALUES ('1422', '2', '21', '0');
INSERT INTO `sys_role_menu` VALUES ('1423', '2', '12', '0');
INSERT INTO `sys_role_menu` VALUES ('1424', '2', '11', '0');
INSERT INTO `sys_role_menu` VALUES ('1425', '2', '14', '0');
INSERT INTO `sys_role_menu` VALUES ('1426', '2', '15', '0');
INSERT INTO `sys_role_menu` VALUES ('1427', '2', '16', '0');
INSERT INTO `sys_role_menu` VALUES ('1520', '1', '1', '0');
INSERT INTO `sys_role_menu` VALUES ('1521', '1', '2', '0');
INSERT INTO `sys_role_menu` VALUES ('1522', '1', '3', '0');
INSERT INTO `sys_role_menu` VALUES ('1523', '1', '4', '0');
INSERT INTO `sys_role_menu` VALUES ('1524', '1', '29', '0');
INSERT INTO `sys_role_menu` VALUES ('1525', '1', '23', '0');
INSERT INTO `sys_role_menu` VALUES ('1526', '1', '24', '0');
INSERT INTO `sys_role_menu` VALUES ('1527', '1', '25', '0');
INSERT INTO `sys_role_menu` VALUES ('1528', '1', '32', '0');
INSERT INTO `sys_role_menu` VALUES ('1529', '1', '35', '0');
INSERT INTO `sys_role_menu` VALUES ('1530', '1', '34', '0');
INSERT INTO `sys_role_menu` VALUES ('1531', '1', '33', '0');
INSERT INTO `sys_role_menu` VALUES ('1532', '1', '5', '0');
INSERT INTO `sys_role_menu` VALUES ('1533', '1', '6', '0');
INSERT INTO `sys_role_menu` VALUES ('1534', '1', '26', '0');
INSERT INTO `sys_role_menu` VALUES ('1535', '1', '30', '0');
INSERT INTO `sys_role_menu` VALUES ('1536', '1', '28', '0');
INSERT INTO `sys_role_menu` VALUES ('1537', '1', '27', '0');
INSERT INTO `sys_role_menu` VALUES ('1538', '1', '7', '0');
INSERT INTO `sys_role_menu` VALUES ('1539', '1', '19', '0');
INSERT INTO `sys_role_menu` VALUES ('1540', '1', '20', '0');
INSERT INTO `sys_role_menu` VALUES ('1541', '1', '21', '0');
INSERT INTO `sys_role_menu` VALUES ('1542', '1', '36', '0');
INSERT INTO `sys_role_menu` VALUES ('1543', '1', '37', '0');
INSERT INTO `sys_role_menu` VALUES ('1544', '1', '38', '0');
INSERT INTO `sys_role_menu` VALUES ('1545', '1', '39', '0');
INSERT INTO `sys_role_menu` VALUES ('1546', '1', '40', '0');
INSERT INTO `sys_role_menu` VALUES ('1547', '1', '41', '0');
INSERT INTO `sys_role_menu` VALUES ('1548', '1', '43', '0');
INSERT INTO `sys_role_menu` VALUES ('1549', '1', '46', '0');
INSERT INTO `sys_role_menu` VALUES ('1550', '1', '47', '0');
INSERT INTO `sys_role_menu` VALUES ('1551', '1', '48', '0');

-- ----------------------------
-- Table structure for sys_tenant
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tenant_id` int(11) DEFAULT NULL COMMENT '租户编号',
  `tenant_name` varchar(50) DEFAULT NULL COMMENT '租户名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注信息',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '是否已删除(0:未删除1:已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='租户信息表';

-- ----------------------------
-- Records of sys_tenant
-- ----------------------------
INSERT INTO `sys_tenant` VALUES ('1', '1', '北京卡普公司', '一家科技公司2', '2021-05-05 13:48:16', '2021-05-05 13:48:16', '0');
INSERT INTO `sys_tenant` VALUES ('4', '2', '上海卡普公司', 'IT', '2021-05-05 10:45:31', '2021-05-05 10:45:31', '0');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `status` int(2) DEFAULT '1' COMMENT '状态,1可用0不可用',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `is_admin` int(11) DEFAULT NULL COMMENT '是否是系统管理员',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` int(2) DEFAULT '0' COMMENT '是否删除,1已删0未删',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  `update_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后一次更新的用户',
  `last_login_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后一次登录id',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'sadmin', '超级管理员', '$2a$10$BqmyJhzbUTwAlW6JPQINZufIgEBVvUs/Go6CjDPXPiI3bvSOJrWaW', '23xxx@qq.com', '18911483365', null, '1', '1', '1', null, '2021-05-05 17:14:51', '0', null, 'admin', '172.0.0.1', '2021-05-05 17:32:19', '');
INSERT INTO `sys_user` VALUES ('2', 'admin', '级管理员', '$2a$10$BqmyJhzbUTwAlW6JPQINZufIgEBVvUs/Go6CjDPXPiI3bvSOJrWaW', '22@qq.com', '189222222', null, '1', null, null, null, '2021-05-05 17:14:53', '0', '2', 'admin', '172.0.0.1', '2021-05-05 17:32:23', '');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `tenant_id` int(11) DEFAULT '1' COMMENT '租户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('59', '1', '1', '0');
INSERT INTO `sys_user_role` VALUES ('66', '2', '1', '0');
