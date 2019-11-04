/*
 Navicat Premium Data Transfer

 Source Server         : testmssql
 Source Server Type    : SQL Server
 Source Server Version : 11006020
 Source Host           : rm-m5eh4uoca2f178b7rfo.sqlserver.rds.aliyuncs.com:1433
 Source Catalog        : guns
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 11006020
 File Encoding         : 65001

 Date: 02/04/2019 15:37:04
*/


-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_dept]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_dept]
GO

CREATE TABLE [dbo].[sys_dept] (
  [dept_id] bigint  NOT NULL,
  [pid] bigint DEFAULT ((0)) NULL,
  [pids] varchar(512) COLLATE Chinese_PRC_CI_AS DEFAULT '' NULL,
  [simple_name] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [full_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [version] int  NULL,
  [sort] int  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_dept] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_dept]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_dept]  VALUES (N'24', N'0', N'[0],', N'总公司', N'总公司', N'', NULL, N'1', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[sys_dept]  VALUES (N'25', N'24', N'[0],[24],', N'开发部', N'开发部', N'', NULL, N'2', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[sys_dept]  VALUES (N'26', N'24', N'[0],[24],', N'运营部', N'运营部', N'', NULL, N'3', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[sys_dept]  VALUES (N'27', N'24', N'[0],[24],', N'战略部', N'战略部', N'', NULL, N'4', NULL, NULL, NULL, NULL)
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_dict]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_dict]
GO

CREATE TABLE [dbo].[sys_dict] (
  [dict_id] bigint  NOT NULL,
  [dict_type_id] bigint  NOT NULL,
  [code] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [parent_id] bigint  NOT NULL,
  [parent_ids] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [status] varchar(10) COLLATE Chinese_PRC_CI_AS DEFAULT ('ENABLE') NOT NULL,
  [sort] int  NULL,
  [description] varchar(1000) COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_dict] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_dict]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120532442595330', N'1106120208097067009', N'M', N'男', N'0', N'[0]', N'ENABLE', NULL, N'', N'2019-03-14 17:11:00.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120574163337218', N'1106120208097067009', N'F', N'女', N'0', N'[0]', N'ENABLE', NULL, N'', N'2019-03-14 17:11:10.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120645697191938', N'1106120265689055233', N'ENABLE', N'启用', N'0', N'[0]', N'ENABLE', NULL, N'', N'2019-03-14 17:11:27.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120699468169217', N'1106120265689055233', N'DISABLE', N'禁', N'0', N'[0]', N'ENABLE', NULL, N'', N'2019-03-14 17:11:40.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120784318939137', N'1106120322450571266', N'ENABLE', N'启用', N'0', N'[0]', N'ENABLE', NULL, N'', N'2019-03-14 17:12:00.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120825993543682', N'1106120322450571266', N'FREEZE', N'冻结', N'0', N'[0]', N'ENABLE', N'1', N'', N'2019-03-14 17:12:10.000', N'2019-03-16 10:56:36.000', N'1', N'1')
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120875872206849', N'1106120322450571266', N'DELETED', N'已删除', N'0', N'[0]', N'ENABLE', N'-1221', N'', N'2019-03-14 17:12:22.000', N'2019-03-16 10:56:53.000', N'1', N'1')
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120935070613505', N'1106120388036902914', N'Y', N'删除', N'0', N'[0]', N'ENABLE', N'23333', N'', N'2019-03-14 17:12:36.000', N'2019-03-16 10:58:53.000', N'1', N'1')
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106120968910258177', N'1106120388036902914', N'N', N'未删除', N'0', N'[0]', N'ENABLE', N'1212211221', N'', N'2019-03-14 17:12:44.000', N'2019-03-16 10:59:03.000', N'1', N'1')
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106751061042974722', N'1106120322450571266', N'11212', N'122', N'0', N'[0]', N'ENABLE', N'1212', N'122112', N'2019-03-16 10:56:30.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_dict]  VALUES (N'1106751747772166145', N'1106120388036902914', N'12312', N'3123123', N'1106120968910258177', N'[0],[1106120968910258177]', N'ENABLE', N'123', N'', N'2019-03-16 10:59:14.000', NULL, N'1', NULL)
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_dict_type]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_dict_type]
GO

CREATE TABLE [dbo].[sys_dict_type] (
  [dict_type_id] bigint  NOT NULL,
  [code] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [description] varchar(1000) COLLATE Chinese_PRC_CI_AS  NULL,
  [system_flag] nvarchar(1) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [status] varchar(10) COLLATE Chinese_PRC_CI_AS DEFAULT ('ENABLE') NOT NULL,
  [sort] int  NULL,
  [create_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_time] datetime  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_dict_type] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_dict_type]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_dict_type]  VALUES (N'1106120208097067009', N'SEX', N'性别', N'', N'Y', N'ENABLE', N'4', N'2019-03-14 17:09:43.000', N'1', NULL, NULL)
GO

INSERT INTO [dbo].[sys_dict_type]  VALUES (N'1106120265689055233', N'STATUS', N'状态', N'', N'Y', N'ENABLE', N'3', N'2019-03-14 17:09:57.000', N'1', NULL, NULL)
GO

INSERT INTO [dbo].[sys_dict_type]  VALUES (N'1106120322450571266', N'ACCOUNT_STATUS', N'账号状态', N'', N'Y', N'ENABLE', N'21112', N'2019-03-14 17:10:10.000', N'1', N'2019-03-16 10:56:15.000', N'1')
GO

INSERT INTO [dbo].[sys_dict_type]  VALUES (N'1106120388036902914', N'DEL_FLAG', N'是否删除', N'', N'Y', N'ENABLE', N'2', N'2019-03-14 17:10:26.000', N'1', N'2019-03-27 16:26:31.000', N'1')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_file_info
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_file_info]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_file_info]
GO

CREATE TABLE [dbo].[sys_file_info] (
  [file_id] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [file_data] ntext COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_file_info] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_file_info]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_file_info]  VALUES (N'1', N'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', NULL, NULL, NULL, NULL)
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_login_log]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_login_log]
GO

CREATE TABLE [dbo].[sys_login_log] (
  [login_log_id] bigint  NOT NULL,
  [log_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [user_id] bigint  NULL,
  [create_time] datetime  NULL,
  [succeed] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [message] ntext COLLATE Chinese_PRC_CI_AS  NULL,
  [ip_address] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[sys_login_log] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_menu]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_menu]
GO

CREATE TABLE [dbo].[sys_menu] (
  [menu_id] bigint  NOT NULL,
  [code] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [pcode] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [pcodes] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [icon] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [url] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [sort] int  NULL,
  [levels] int  NULL,
  [menu_flag] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [status] varchar(32) COLLATE Chinese_PRC_CI_AS DEFAULT ('ENABLE') NULL,
  [new_page_flag] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [open_flag] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_menu] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_menu]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'105', N'system', N'0', N'[0],', N'系统管理', N'layui-icon layui-icon-set', N'#', N'20', N'1', N'Y', NULL, N'ENABLE', NULL, N'1', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'106', N'mgr', N'system', N'[0],[system],', N'用户管理', N'', N'/mgr', N'1', N'2', N'Y', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'107', N'mgr_add', N'mgr', N'[0],[system],[mgr],', N'添加用户', NULL, N'/mgr/add', N'1', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'108', N'mgr_edit', N'mgr', N'[0],[system],[mgr],', N'修改用户', NULL, N'/mgr/edit', N'2', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'109', N'mgr_delete', N'mgr', N'[0],[system],[mgr],', N'删除用户', NULL, N'/mgr/delete', N'3', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'110', N'mgr_reset', N'mgr', N'[0],[system],[mgr],', N'重置密码', NULL, N'/mgr/reset', N'4', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'111', N'mgr_freeze', N'mgr', N'[0],[system],[mgr],', N'冻结用户', NULL, N'/mgr/freeze', N'5', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'112', N'mgr_unfreeze', N'mgr', N'[0],[system],[mgr],', N'解除冻结用户', NULL, N'/mgr/unfreeze', N'6', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'113', N'mgr_setRole', N'mgr', N'[0],[system],[mgr],', N'分配角色', NULL, N'/mgr/setRole', N'7', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'114', N'role', N'system', N'[0],[system],', N'角色管理', NULL, N'/role', N'2', N'2', N'Y', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'115', N'role_add', N'role', N'[0],[system],[role],', N'添加角色', NULL, N'/role/add', N'1', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'116', N'role_edit', N'role', N'[0],[system],[role],', N'修改角色', NULL, N'/role/edit', N'2', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'117', N'role_remove', N'role', N'[0],[system],[role],', N'删除角色', NULL, N'/role/remove', N'3', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'118', N'role_setAuthority', N'role', N'[0],[system],[role],', N'配置权限', NULL, N'/role/setAuthority', N'4', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'119', N'menu', N'system', N'[0],[system],', N'菜单管理', NULL, N'/menu', N'4', N'2', N'Y', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'120', N'menu_add', N'menu', N'[0],[system],[menu],', N'添加菜单', NULL, N'/menu/add', N'1', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'121', N'menu_edit', N'menu', N'[0],[system],[menu],', N'修改菜单', NULL, N'/menu/edit', N'2', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'122', N'menu_remove', N'menu', N'[0],[system],[menu],', N'删除菜单', NULL, N'/menu/remove', N'3', N'3', N'N', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'128', N'log', N'system', N'[0],[system],', N'业务日志', NULL, N'/log', N'6', N'2', N'Y', NULL, N'ENABLE', NULL, N'0', NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'130', N'druid', N'system', N'[0],[system],', N'监控管理', NULL, N'/druid', N'7', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'131', N'dept', N'system', N'[0],[system],', N'部门管理', NULL, N'/dept', N'3', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'132', N'dict', N'system', N'[0],[system],', N'字典管理', N'', N'/dictType', N'4', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'133', N'loginLog', N'system', N'[0],[system],', N'登录日志', NULL, N'/loginLog', N'6', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'134', N'log_clean', N'log', N'[0],[system],[log],', N'清空日志', NULL, N'/log/delLog', N'3', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'135', N'dept_add', N'dept', N'[0],[system],[dept],', N'添加部门', NULL, N'/dept/add', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'136', N'dept_update', N'dept', N'[0],[system],[dept],', N'修改部门', NULL, N'/dept/update', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'137', N'dept_delete', N'dept', N'[0],[system],[dept],', N'删除部门', NULL, N'/dept/delete', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'138', N'dict_add', N'dict', N'[0],[system],[dict],', N'添加字典', NULL, N'/dictType/addItem', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'139', N'dict_update', N'dict', N'[0],[system],[dict],', N'修改字典', NULL, N'/dictType/editItem', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'140', N'dict_delete', N'dict', N'[0],[system],[dict],', N'删除字典', NULL, N'/dictType/delete', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'141', N'notice', N'system', N'[0],[system],', N'通知管理', NULL, N'/notice', N'9', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'142', N'notice_add', N'notice', N'[0],[system],[notice],', N'添加通知', NULL, N'/notice/add', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'143', N'notice_update', N'notice', N'[0],[system],[notice],', N'修改通知', NULL, N'/notice/update', N'2', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'144', N'notice_delete', N'notice', N'[0],[system],[notice],', N'删除通知', NULL, N'/notice/delete', N'3', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'145', N'sys_message', N'dashboard', N'[0],[dashboard],', N'消息页', N'layui-icon layui-icon-tips', N'/system/notice', N'30', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 17:30:28.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'149', N'api_mgr', N'dev_tools', N'[0],[dev_tools],', N'接口文档', N'fa-leaf', N'/swagger-ui.html', N'2', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:31:59.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'150', N'to_menu_edit', N'menu', N'[0],[system],[menu],', N'菜单编辑跳转', N'', N'/menu/menu_edit', N'4', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'151', N'menu_list', N'menu', N'[0],[system],[menu],', N'菜单列表', N'', N'/menu/list', N'5', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'152', N'to_dept_update', N'dept', N'[0],[system],[dept],', N'修改部门跳转', N'', N'/dept/dept_update', N'4', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'153', N'dept_list', N'dept', N'[0],[system],[dept],', N'部门列表', N'', N'/dept/list', N'5', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'154', N'dept_detail', N'dept', N'[0],[system],[dept],', N'部门详情', N'', N'/dept/detail', N'6', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'155', N'to_dict_edit', N'dict', N'[0],[system],[dict],', N'修改菜单跳转', N'', N'/dict/dict_edit', N'4', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'156', N'dict_list', N'dict', N'[0],[system],[dict],', N'字典列表', N'', N'/dict/list', N'5', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'157', N'dict_detail', N'dict', N'[0],[system],[dict],', N'字典详情', N'', N'/dict/detail', N'6', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'158', N'log_list', N'log', N'[0],[system],[log],', N'日志列表', N'', N'/log/list', N'2', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'159', N'log_detail', N'log', N'[0],[system],[log],', N'日志详情', N'', N'/log/detail', N'3', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'160', N'del_login_log', N'loginLog', N'[0],[system],[loginLog],', N'清空登录日志', N'', N'/loginLog/delLoginLog', N'1', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'161', N'login_log_list', N'loginLog', N'[0],[system],[loginLog],', N'登录日志列表', N'', N'/loginLog/list', N'2', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'162', N'to_role_edit', N'role', N'[0],[system],[role],', N'修改角色跳转', N'', N'/role/role_edit', N'5', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'163', N'to_role_assign', N'role', N'[0],[system],[role],', N'角色分配跳转', N'', N'/role/role_assign', N'6', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'164', N'role_list', N'role', N'[0],[system],[role],', N'角色列表', N'', N'/role/list', N'7', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'165', N'to_assign_role', N'mgr', N'[0],[system],[mgr],', N'分配角色跳转', N'', N'/mgr/role_assign', N'8', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'166', N'to_user_edit', N'mgr', N'[0],[system],[mgr],', N'编辑用户跳转', N'', N'/mgr/user_edit', N'9', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'167', N'mgr_list', N'mgr', N'[0],[system],[mgr],', N'用户列表', N'', N'/mgr/list', N'10', N'3', N'N', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:32:27.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'171', N'dev_tools', N'0', N'[0],', N'API管理', N'layui-icon layui-icon-app', N'#', N'30', N'1', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:31:59.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'172', N'dashboard', N'0', N'[0],', N'Dashboard', N'layui-icon layui-icon-home', N'#', N'10', N'1', N'Y', NULL, N'ENABLE', NULL, NULL, NULL, N'2019-03-29 16:26:22.000', NULL, N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1110777136265838594', N'demos_show', N'0', N'[0],', N'demos展示', N'layui-icon layui-icon-fire', N'#', N'40', N'1', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-27 13:34:41.000', N'2019-03-27 13:34:59.000', N'1', N'1')
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1110777366856089602', N'excel_import', N'demos_show', N'[0],[demos_show],', N'excel导入', N'', N'/excel/import', N'10', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-27 13:35:36.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1110777491464667137', N'excel_export', N'demos_show', N'[0],[demos_show],', N'excel导出', N'', N'/excel/export', N'20', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-27 13:36:06.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1110787391943098370', N'advanced_form', N'demos_show', N'[0],[demos_show],', N'高级表单', N'', N'/egForm', N'30', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-27 14:15:26.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1110839216310329346', N'pdf_view', N'demos_show', N'[0],[demos_show],', N'pdf预览', N'', N'/loadPdfFile', N'40', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-27 17:41:22.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1111545968697860098', N'console', N'dashboard', N'[0],[dashboard],', N'控制台', N'', N'/system/console', N'10', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-29 16:29:45.000', NULL, N'1', NULL)
GO

INSERT INTO [dbo].[sys_menu]  VALUES (N'1111546189892870145', N'console2', N'dashboard', N'[0],[dashboard],', N'分析页', N'', N'/system/console2', N'20', N'2', N'Y', NULL, N'ENABLE', NULL, NULL, N'2019-03-29 16:30:38.000', NULL, N'1', NULL)
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_notice]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_notice]
GO

CREATE TABLE [dbo].[sys_notice] (
  [notice_id] bigint  NOT NULL,
  [title] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [content] ntext COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_time] datetime  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_notice] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_notice]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_notice]  VALUES (N'6', N'欢迎', N'hi，Guns旗舰版发布了！', N'2017-01-11 08:53:20.000', N'1', N'2018-12-28 23:24:48.000', N'1')
GO

INSERT INTO [dbo].[sys_notice]  VALUES (N'8', N'你好', N'你好，世界！', N'2017-05-10 19:28:57.000', N'1', N'2018-12-28 23:28:26.000', N'1')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_operation_log]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_operation_log]
GO

CREATE TABLE [dbo].[sys_operation_log] (
  [operation_log_id] bigint  NOT NULL,
  [log_type] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [log_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [user_id] bigint  NULL,
  [class_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [method] ntext COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [succeed] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [message] ntext COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[sys_operation_log] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_relation]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_relation]
GO

CREATE TABLE [dbo].[sys_relation] (
  [relation_id] bigint  NOT NULL,
  [menu_id] bigint  NULL,
  [role_id] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_relation] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_relation]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922291826689', N'105', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922308603906', N'106', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922316992514', N'107', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922321186818', N'108', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922329575426', N'109', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922337964034', N'110', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922342158337', N'111', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922350546946', N'112', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922354741249', N'113', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922363129858', N'165', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922371518465', N'166', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922375712770', N'167', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922384101377', N'114', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922388295681', N'115', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922396684289', N'116', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922405072897', N'117', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922413461505', N'118', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922417655810', N'162', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922426044418', N'163', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922430238722', N'164', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922430238723', N'119', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922447015937', N'120', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922451210242', N'121', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922459598850', N'122', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922463793154', N'150', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922472181762', N'151', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922476376065', N'128', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922480570369', N'134', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922488958977', N'158', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922497347586', N'159', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922501541890', N'130', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922501541891', N'131', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922518319106', N'135', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922526707713', N'136', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922530902017', N'137', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922535096321', N'152', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922543484930', N'153', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922547679233', N'154', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922556067841', N'132', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922560262146', N'138', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922564456450', N'139', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922568650754', N'140', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922577039361', N'155', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922577039362', N'156', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922577039363', N'157', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922602205185', N'133', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922610593794', N'160', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922610593795', N'161', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922618982402', N'141', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922627371009', N'142', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922631565313', N'143', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1071348922639953922', N'144', N'5')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349351919618', N'105', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349364502529', N'106', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349381279746', N'107', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349393862658', N'108', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349410639873', N'109', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349427417089', N'110', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349440000001', N'111', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349460971521', N'112', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349473554433', N'113', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349490331650', N'165', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349502914561', N'166', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349519691778', N'167', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349532274689', N'114', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349544857601', N'115', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349557440514', N'116', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349570023425', N'117', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349586800641', N'118', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349599383554', N'162', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349616160769', N'163', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349628743682', N'164', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349645520897', N'119', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349662298113', N'120', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349679075329', N'121', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349700046849', N'122', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349716824065', N'150', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349737795586', N'151', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349758767106', N'128', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349779738626', N'134', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349800710146', N'158', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349821681666', N'159', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349846847490', N'130', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349863624706', N'131', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349884596226', N'135', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349901373442', N'136', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349922344962', N'137', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349939122178', N'152', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349960093697', N'153', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349976870914', N'154', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546349993648129', N'132', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350010425346', N'138', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350031396865', N'139', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350048174081', N'140', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350069145602', N'155', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350085922818', N'156', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350106894338', N'157', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350127865858', N'133', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350144643073', N'160', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350169808898', N'161', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350186586113', N'141', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350211751937', N'142', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350232723458', N'143', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350262083585', N'144', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350278860801', N'171', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350299832322', N'149', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350324998146', N'172', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350345969665', N'145', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350371135489', N'1111545968697860098', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350387912705', N'1111546189892870145', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350404689921', N'1110777136265838594', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350421467137', N'1110777366856089602', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350446632962', N'1110777491464667137', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350459215873', N'1110787391943098370', N'1')
GO

INSERT INTO [dbo].[sys_relation]  VALUES (N'1111546350471798786', N'1110839216310329346', N'1')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_role]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_role]
GO

CREATE TABLE [dbo].[sys_role] (
  [role_id] bigint  NOT NULL,
  [pid] bigint  NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [sort] int  NULL,
  [version] int  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_user] bigint  NULL
)
GO

ALTER TABLE [dbo].[sys_role] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_role]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_role]  VALUES (N'1', N'0', N'超级管理员', N'administrator', N'1', N'1', NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[sys_role]  VALUES (N'5', N'1', N'临时', N'temp', N'2', NULL, NULL, NULL, NULL, NULL)
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[sys_user]') AND type IN ('U'))
	DROP TABLE [dbo].[sys_user]
GO

CREATE TABLE [dbo].[sys_user] (
  [user_id] bigint  NOT NULL,
  [avatar] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [account] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [salt] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [birthday] datetime  NULL,
  [sex] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone] varchar(45) COLLATE Chinese_PRC_CI_AS  NULL,
  [role_id] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [dept_id] bigint  NULL,
  [status] varchar(32) COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [create_user] bigint  NULL,
  [update_time] datetime  NULL,
  [update_user] bigint  NULL,
  [version] int  NULL
)
GO

ALTER TABLE [dbo].[sys_user] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of [sys_user]
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[sys_user]  VALUES (N'1', N'1', N'admin', N'1d6b1208c7d151d335790276a18e3d99', N'q6taw', N'stylefeng', N'2018-11-16 00:00:00.000', N'M', N'sn93@qq.com', N'18200000000', N'1', N'27', N'ENABLE', N'2016-01-29 08:49:53.000', NULL, N'2018-12-28 22:52:24.000', N'24', N'25')
GO

COMMIT
GO


-- ----------------------------
-- Primary Key structure for table sys_dept
-- ----------------------------
ALTER TABLE [dbo].[sys_dept] ADD CONSTRAINT [sys_dept_PRIMARY] PRIMARY KEY NONCLUSTERED ([dept_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE [dbo].[sys_dict] ADD CONSTRAINT [sys_dict_PRIMARY] PRIMARY KEY NONCLUSTERED ([dict_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_dict_type
-- ----------------------------
ALTER TABLE [dbo].[sys_dict_type] ADD CONSTRAINT [sys_dict_type_PRIMARY] PRIMARY KEY NONCLUSTERED ([dict_type_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_file_info
-- ----------------------------
ALTER TABLE [dbo].[sys_file_info] ADD CONSTRAINT [sys_file_info_PRIMARY] PRIMARY KEY NONCLUSTERED ([file_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_login_log
-- ----------------------------
ALTER TABLE [dbo].[sys_login_log] ADD CONSTRAINT [sys_login_log_PRIMARY] PRIMARY KEY NONCLUSTERED ([login_log_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE [dbo].[sys_menu] ADD CONSTRAINT [sys_menu_PRIMARY] PRIMARY KEY NONCLUSTERED ([menu_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_notice
-- ----------------------------
ALTER TABLE [dbo].[sys_notice] ADD CONSTRAINT [sys_notice_PRIMARY] PRIMARY KEY NONCLUSTERED ([notice_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_operation_log
-- ----------------------------
ALTER TABLE [dbo].[sys_operation_log] ADD CONSTRAINT [sys_operation_log_PRIMARY] PRIMARY KEY NONCLUSTERED ([operation_log_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_relation
-- ----------------------------
ALTER TABLE [dbo].[sys_relation] ADD CONSTRAINT [sys_relation_PRIMARY] PRIMARY KEY NONCLUSTERED ([relation_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE [dbo].[sys_role] ADD CONSTRAINT [sys_role_PRIMARY] PRIMARY KEY NONCLUSTERED ([role_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE [dbo].[sys_user] ADD CONSTRAINT [sys_user_PRIMARY] PRIMARY KEY NONCLUSTERED ([user_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
ON [PRIMARY]
GO

