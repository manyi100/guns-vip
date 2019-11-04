/*
 Navicat Premium Data Transfer

 Source Server         : testpg
 Source Server Type    : PostgreSQL
 Source Server Version : 100006
 Source Host           : pgm-m5e7738wqsn0aa88jo.pg.rds.aliyuncs.com:3433
 Source Catalog        : guns
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100006
 File Encoding         : 65001

 Date: 02/04/2019 15:44:21
*/


-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS "sys_dept";
CREATE TABLE "sys_dept" (
  "dept_id" int8 NOT NULL,
  "pid" int8 DEFAULT '0'::bigint,
  "pids" varchar(512) COLLATE "pg_catalog"."default",
  "simple_name" varchar(45) COLLATE "pg_catalog"."default",
  "full_name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "sort" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_user" int8,
  "update_user" int8
)
;
ALTER TABLE "sys_dept" OWNER TO "guns";

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
BEGIN;
INSERT INTO "sys_dept" VALUES (24, 0, '[0],', '总公司', '总公司', '', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO "sys_dept" VALUES (25, 24, '[0],[24],', '开发部', '开发部', '', NULL, 2, NULL, NULL, NULL, NULL);
INSERT INTO "sys_dept" VALUES (26, 24, '[0],[24],', '运营部', '运营部', '', NULL, 3, NULL, NULL, NULL, NULL);
INSERT INTO "sys_dept" VALUES (27, 24, '[0],[24],', '战略部', '战略部', '', NULL, 4, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS "sys_dict";
CREATE TABLE "sys_dict" (
  "dict_id" int8 NOT NULL,
  "dict_type_id" int8 NOT NULL,
  "code" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" int8 NOT NULL,
  "parent_ids" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'ENABLE'::character varying,
  "sort" int4,
  "description" varchar(1000) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_user" int8,
  "update_user" int8
)
;
ALTER TABLE "sys_dict" OWNER TO "guns";

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
BEGIN;
INSERT INTO "sys_dict" VALUES (1106120532442595330, 1106120208097067009, 'M', '男', 0, '[0]', 'ENABLE', NULL, '', '2019-03-14 17:11:00', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106120574163337218, 1106120208097067009, 'F', '女', 0, '[0]', 'ENABLE', NULL, '', '2019-03-14 17:11:10', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106120645697191938, 1106120265689055233, 'ENABLE', '启用', 0, '[0]', 'ENABLE', NULL, '', '2019-03-14 17:11:27', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106120699468169217, 1106120265689055233, 'DISABLE', '禁用', 0, '[0]', 'ENABLE', NULL, '', '2019-03-14 17:11:40', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106120784318939137, 1106120322450571266, 'ENABLE', '启用', 0, '[0]', 'ENABLE', NULL, '', '2019-03-14 17:12:00', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106120825993543682, 1106120322450571266, 'FREEZE', '冻结', 0, '[0]', 'ENABLE', 1, '', '2019-03-14 17:12:10', '2019-03-16 10:56:36', 1, 1);
INSERT INTO "sys_dict" VALUES (1106120875872206849, 1106120322450571266, 'DELETED', '已删除', 0, '[0]', 'ENABLE', -1221, '', '2019-03-14 17:12:22', '2019-03-16 10:56:53', 1, 1);
INSERT INTO "sys_dict" VALUES (1106120935070613505, 1106120388036902914, 'Y', '删除', 0, '[0]', 'ENABLE', 23333, '', '2019-03-14 17:12:36', '2019-03-16 10:58:53', 1, 1);
INSERT INTO "sys_dict" VALUES (1106120968910258177, 1106120388036902914, 'N', '未删除', 0, '[0]', 'ENABLE', 1212211221, '', '2019-03-14 17:12:44', '2019-03-16 10:59:03', 1, 1);
INSERT INTO "sys_dict" VALUES (1106751061042974722, 1106120322450571266, '11212', '122', 0, '[0]', 'ENABLE', 1212, '122112', '2019-03-16 10:56:30', NULL, 1, NULL);
INSERT INTO "sys_dict" VALUES (1106751747772166145, 1106120388036902914, '12312', '3123123', 1106120968910258177, '[0],[1106120968910258177]', 'ENABLE', 123, '', '2019-03-16 10:59:14', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS "sys_dict_type";
CREATE TABLE "sys_dict_type" (
  "dict_type_id" int8 NOT NULL,
  "code" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(1000) COLLATE "pg_catalog"."default",
  "system_flag" char(1) COLLATE "pg_catalog"."default" NOT NULL,
  "status" varchar(10) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'ENABLE'::character varying,
  "sort" int4,
  "create_time" timestamp(6),
  "create_user" int8,
  "update_time" timestamp(6),
  "update_user" int8
)
;
ALTER TABLE "sys_dict_type" OWNER TO "guns";

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO "sys_dict_type" VALUES (1106120208097067009, 'SEX', '性别', '', 'Y', 'ENABLE', 4, '2019-03-14 17:09:43', 1, NULL, NULL);
INSERT INTO "sys_dict_type" VALUES (1106120265689055233, 'STATUS', '状态', '', 'Y', 'ENABLE', 3, '2019-03-14 17:09:57', 1, NULL, NULL);
INSERT INTO "sys_dict_type" VALUES (1106120322450571266, 'ACCOUNT_STATUS', '账号状态', '', 'Y', 'ENABLE', 21112, '2019-03-14 17:10:10', 1, '2019-03-16 10:56:15', 1);
INSERT INTO "sys_dict_type" VALUES (1106120388036902914, 'DEL_FLAG', '是否删除', '', 'Y', 'ENABLE', 2, '2019-03-14 17:10:26', 1, '2019-03-27 16:26:31', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_file_info
-- ----------------------------
DROP TABLE IF EXISTS "sys_file_info";
CREATE TABLE "sys_file_info" (
  "file_id" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "file_data" text COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_user" int8,
  "update_user" int8
)
;
ALTER TABLE "sys_file_info" OWNER TO "guns";

-- ----------------------------
-- Records of sys_file_info
-- ----------------------------
BEGIN;
INSERT INTO "sys_file_info" VALUES ('1', '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', NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS "sys_login_log";
CREATE TABLE "sys_login_log" (
  "login_log_id" int8 NOT NULL,
  "log_name" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" int8,
  "create_time" timestamp(6),
  "succeed" varchar(255) COLLATE "pg_catalog"."default",
  "message" text COLLATE "pg_catalog"."default",
  "ip_address" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "sys_login_log" OWNER TO "guns";

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "sys_menu";
CREATE TABLE "sys_menu" (
  "menu_id" int8 NOT NULL,
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "pcode" varchar(255) COLLATE "pg_catalog"."default",
  "pcodes" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "icon" varchar(255) COLLATE "pg_catalog"."default",
  "url" varchar(255) COLLATE "pg_catalog"."default",
  "sort" int4,
  "levels" int4,
  "menu_flag" varchar(32) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(32) COLLATE "pg_catalog"."default" DEFAULT 'ENABLE'::character varying,
  "new_page_flag" varchar(32) COLLATE "pg_catalog"."default",
  "open_flag" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_user" int8,
  "update_user" int8
)
;
ALTER TABLE "sys_menu" OWNER TO "guns";

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO "sys_menu" VALUES (105, 'system', '0', '[0],', '系统管理', 'layui-icon layui-icon-set', '#', 20, 1, 'Y', NULL, 'ENABLE', NULL, '1', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (106, 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', 1, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (107, 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', NULL, '/mgr/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (108, 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', NULL, '/mgr/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (109, 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', NULL, '/mgr/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (110, 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', NULL, '/mgr/reset', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (111, 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', NULL, '/mgr/freeze', 5, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (112, 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', NULL, '/mgr/unfreeze', 6, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (113, 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', NULL, '/mgr/setRole', 7, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (114, 'role', 'system', '[0],[system],', '角色管理', NULL, '/role', 2, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (115, 'role_add', 'role', '[0],[system],[role],', '添加角色', NULL, '/role/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (116, 'role_edit', 'role', '[0],[system],[role],', '修改角色', NULL, '/role/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (117, 'role_remove', 'role', '[0],[system],[role],', '删除角色', NULL, '/role/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (118, 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', NULL, '/role/setAuthority', 4, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (119, 'menu', 'system', '[0],[system],', '菜单管理', NULL, '/menu', 4, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (120, 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', NULL, '/menu/add', 1, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (121, 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', NULL, '/menu/edit', 2, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (122, 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', NULL, '/menu/remove', 3, 3, 'N', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (128, 'log', 'system', '[0],[system],', '业务日志', NULL, '/log', 6, 2, 'Y', NULL, 'ENABLE', NULL, '0', NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (130, 'druid', 'system', '[0],[system],', '监控管理', NULL, '/druid', 7, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (131, 'dept', 'system', '[0],[system],', '部门管理', NULL, '/dept', 3, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (132, 'dict', 'system', '[0],[system],', '字典管理', '', '/dictType', 4, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (133, 'loginLog', 'system', '[0],[system],', '登录日志', NULL, '/loginLog', 6, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (134, 'log_clean', 'log', '[0],[system],[log],', '清空日志', NULL, '/log/delLog', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (135, 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', NULL, '/dept/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (136, 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', NULL, '/dept/update', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (137, 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', NULL, '/dept/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (138, 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', NULL, '/dictType/addItem', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (139, 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', NULL, '/dictType/editItem', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (140, 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', NULL, '/dictType/delete', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (141, 'notice', 'system', '[0],[system],', '通知管理', NULL, '/notice', 9, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (142, 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', NULL, '/notice/add', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (143, 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', NULL, '/notice/update', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (144, 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', NULL, '/notice/delete', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (145, 'sys_message', 'dashboard', '[0],[dashboard],', '消息页', 'layui-icon layui-icon-tips', '/system/notice', 30, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 17:30:28', NULL, 1);
INSERT INTO "sys_menu" VALUES (149, 'api_mgr', 'dev_tools', '[0],[dev_tools],', '接口文档', 'fa-leaf', '/swagger-ui.html', 2, 2, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:31:59', NULL, 1);
INSERT INTO "sys_menu" VALUES (150, 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (151, 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (152, 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (153, 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (154, 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (155, 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', 4, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (156, 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (157, 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (158, 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (159, 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', 3, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (160, 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', 1, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (161, 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', 2, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (162, 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', 5, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (163, 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', 6, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (164, 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', 7, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (165, 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', 8, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (166, 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', 9, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (167, 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', 10, 3, 'N', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:32:27', NULL, 1);
INSERT INTO "sys_menu" VALUES (171, 'dev_tools', '0', '[0],', 'API管理', 'layui-icon layui-icon-app', '#', 30, 1, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:31:59', NULL, 1);
INSERT INTO "sys_menu" VALUES (172, 'dashboard', '0', '[0],', 'Dashboard', 'layui-icon layui-icon-home', '#', 10, 1, 'Y', NULL, 'ENABLE', NULL, NULL, NULL, '2019-03-29 16:26:22', NULL, 1);
INSERT INTO "sys_menu" VALUES (1110777136265838594, 'demos_show', '0', '[0],', 'demos展示', 'layui-icon layui-icon-fire', '#', 40, 1, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-27 13:34:41', '2019-03-27 13:34:59', 1, 1);
INSERT INTO "sys_menu" VALUES (1110777366856089602, 'excel_import', 'demos_show', '[0],[demos_show],', 'excel导入', '', '/excel/import', 10, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-27 13:35:36', NULL, 1, NULL);
INSERT INTO "sys_menu" VALUES (1110777491464667137, 'excel_export', 'demos_show', '[0],[demos_show],', 'excel导出', '', '/excel/export', 20, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-27 13:36:06', NULL, 1, NULL);
INSERT INTO "sys_menu" VALUES (1110787391943098370, 'advanced_form', 'demos_show', '[0],[demos_show],', '高级表单', '', '/egForm', 30, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-27 14:15:26', NULL, 1, NULL);
INSERT INTO "sys_menu" VALUES (1110839216310329346, 'pdf_view', 'demos_show', '[0],[demos_show],', 'pdf预览', '', '/loadPdfFile', 40, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-27 17:41:22', NULL, 1, NULL);
INSERT INTO "sys_menu" VALUES (1111545968697860098, 'console', 'dashboard', '[0],[dashboard],', '控制台', '', '/system/console', 10, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-29 16:29:45', NULL, 1, NULL);
INSERT INTO "sys_menu" VALUES (1111546189892870145, 'console2', 'dashboard', '[0],[dashboard],', '分析页', '', '/system/console2', 20, 2, 'Y', NULL, 'ENABLE', NULL, NULL, '2019-03-29 16:30:38', NULL, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS "sys_notice";
CREATE TABLE "sys_notice" (
  "notice_id" int8 NOT NULL,
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "create_user" int8,
  "update_time" timestamp(6),
  "update_user" int8
)
;
ALTER TABLE "sys_notice" OWNER TO "guns";

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
INSERT INTO "sys_notice" VALUES (6, '欢迎', 'hi，Guns旗舰版发布了！', '2017-01-11 08:53:20', 1, '2018-12-28 23:24:48', 1);
INSERT INTO "sys_notice" VALUES (8, '你好', '你好，世界！', '2017-05-10 19:28:57', 1, '2018-12-28 23:28:26', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS "sys_operation_log";
CREATE TABLE "sys_operation_log" (
  "operation_log_id" int8 NOT NULL,
  "log_type" varchar(32) COLLATE "pg_catalog"."default",
  "log_name" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" int8,
  "class_name" varchar(255) COLLATE "pg_catalog"."default",
  "method" text COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "succeed" varchar(32) COLLATE "pg_catalog"."default",
  "message" text COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "sys_operation_log" OWNER TO "guns";

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS "sys_relation";
CREATE TABLE "sys_relation" (
  "relation_id" int8 NOT NULL,
  "menu_id" int8,
  "role_id" int8
)
;
ALTER TABLE "sys_relation" OWNER TO "guns";

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
BEGIN;
INSERT INTO "sys_relation" VALUES (1071348922291826689, 105, 5);
INSERT INTO "sys_relation" VALUES (1071348922308603906, 106, 5);
INSERT INTO "sys_relation" VALUES (1071348922316992514, 107, 5);
INSERT INTO "sys_relation" VALUES (1071348922321186818, 108, 5);
INSERT INTO "sys_relation" VALUES (1071348922329575426, 109, 5);
INSERT INTO "sys_relation" VALUES (1071348922337964034, 110, 5);
INSERT INTO "sys_relation" VALUES (1071348922342158337, 111, 5);
INSERT INTO "sys_relation" VALUES (1071348922350546946, 112, 5);
INSERT INTO "sys_relation" VALUES (1071348922354741249, 113, 5);
INSERT INTO "sys_relation" VALUES (1071348922363129858, 165, 5);
INSERT INTO "sys_relation" VALUES (1071348922371518465, 166, 5);
INSERT INTO "sys_relation" VALUES (1071348922375712770, 167, 5);
INSERT INTO "sys_relation" VALUES (1071348922384101377, 114, 5);
INSERT INTO "sys_relation" VALUES (1071348922388295681, 115, 5);
INSERT INTO "sys_relation" VALUES (1071348922396684289, 116, 5);
INSERT INTO "sys_relation" VALUES (1071348922405072897, 117, 5);
INSERT INTO "sys_relation" VALUES (1071348922413461505, 118, 5);
INSERT INTO "sys_relation" VALUES (1071348922417655810, 162, 5);
INSERT INTO "sys_relation" VALUES (1071348922426044418, 163, 5);
INSERT INTO "sys_relation" VALUES (1071348922430238722, 164, 5);
INSERT INTO "sys_relation" VALUES (1071348922430238723, 119, 5);
INSERT INTO "sys_relation" VALUES (1071348922447015937, 120, 5);
INSERT INTO "sys_relation" VALUES (1071348922451210242, 121, 5);
INSERT INTO "sys_relation" VALUES (1071348922459598850, 122, 5);
INSERT INTO "sys_relation" VALUES (1071348922463793154, 150, 5);
INSERT INTO "sys_relation" VALUES (1071348922472181762, 151, 5);
INSERT INTO "sys_relation" VALUES (1071348922476376065, 128, 5);
INSERT INTO "sys_relation" VALUES (1071348922480570369, 134, 5);
INSERT INTO "sys_relation" VALUES (1071348922488958977, 158, 5);
INSERT INTO "sys_relation" VALUES (1071348922497347586, 159, 5);
INSERT INTO "sys_relation" VALUES (1071348922501541890, 130, 5);
INSERT INTO "sys_relation" VALUES (1071348922501541891, 131, 5);
INSERT INTO "sys_relation" VALUES (1071348922518319106, 135, 5);
INSERT INTO "sys_relation" VALUES (1071348922526707713, 136, 5);
INSERT INTO "sys_relation" VALUES (1071348922530902017, 137, 5);
INSERT INTO "sys_relation" VALUES (1071348922535096321, 152, 5);
INSERT INTO "sys_relation" VALUES (1071348922543484930, 153, 5);
INSERT INTO "sys_relation" VALUES (1071348922547679233, 154, 5);
INSERT INTO "sys_relation" VALUES (1071348922556067841, 132, 5);
INSERT INTO "sys_relation" VALUES (1071348922560262146, 138, 5);
INSERT INTO "sys_relation" VALUES (1071348922564456450, 139, 5);
INSERT INTO "sys_relation" VALUES (1071348922568650754, 140, 5);
INSERT INTO "sys_relation" VALUES (1071348922577039361, 155, 5);
INSERT INTO "sys_relation" VALUES (1071348922577039362, 156, 5);
INSERT INTO "sys_relation" VALUES (1071348922577039363, 157, 5);
INSERT INTO "sys_relation" VALUES (1071348922602205185, 133, 5);
INSERT INTO "sys_relation" VALUES (1071348922610593794, 160, 5);
INSERT INTO "sys_relation" VALUES (1071348922610593795, 161, 5);
INSERT INTO "sys_relation" VALUES (1071348922618982402, 141, 5);
INSERT INTO "sys_relation" VALUES (1071348922627371009, 142, 5);
INSERT INTO "sys_relation" VALUES (1071348922631565313, 143, 5);
INSERT INTO "sys_relation" VALUES (1071348922639953922, 144, 5);
INSERT INTO "sys_relation" VALUES (1111546349351919618, 105, 1);
INSERT INTO "sys_relation" VALUES (1111546349364502529, 106, 1);
INSERT INTO "sys_relation" VALUES (1111546349381279746, 107, 1);
INSERT INTO "sys_relation" VALUES (1111546349393862658, 108, 1);
INSERT INTO "sys_relation" VALUES (1111546349410639873, 109, 1);
INSERT INTO "sys_relation" VALUES (1111546349427417089, 110, 1);
INSERT INTO "sys_relation" VALUES (1111546349440000001, 111, 1);
INSERT INTO "sys_relation" VALUES (1111546349460971521, 112, 1);
INSERT INTO "sys_relation" VALUES (1111546349473554433, 113, 1);
INSERT INTO "sys_relation" VALUES (1111546349490331650, 165, 1);
INSERT INTO "sys_relation" VALUES (1111546349502914561, 166, 1);
INSERT INTO "sys_relation" VALUES (1111546349519691778, 167, 1);
INSERT INTO "sys_relation" VALUES (1111546349532274689, 114, 1);
INSERT INTO "sys_relation" VALUES (1111546349544857601, 115, 1);
INSERT INTO "sys_relation" VALUES (1111546349557440514, 116, 1);
INSERT INTO "sys_relation" VALUES (1111546349570023425, 117, 1);
INSERT INTO "sys_relation" VALUES (1111546349586800641, 118, 1);
INSERT INTO "sys_relation" VALUES (1111546349599383554, 162, 1);
INSERT INTO "sys_relation" VALUES (1111546349616160769, 163, 1);
INSERT INTO "sys_relation" VALUES (1111546349628743682, 164, 1);
INSERT INTO "sys_relation" VALUES (1111546349645520897, 119, 1);
INSERT INTO "sys_relation" VALUES (1111546349662298113, 120, 1);
INSERT INTO "sys_relation" VALUES (1111546349679075329, 121, 1);
INSERT INTO "sys_relation" VALUES (1111546349700046849, 122, 1);
INSERT INTO "sys_relation" VALUES (1111546349716824065, 150, 1);
INSERT INTO "sys_relation" VALUES (1111546349737795586, 151, 1);
INSERT INTO "sys_relation" VALUES (1111546349758767106, 128, 1);
INSERT INTO "sys_relation" VALUES (1111546349779738626, 134, 1);
INSERT INTO "sys_relation" VALUES (1111546349800710146, 158, 1);
INSERT INTO "sys_relation" VALUES (1111546349821681666, 159, 1);
INSERT INTO "sys_relation" VALUES (1111546349846847490, 130, 1);
INSERT INTO "sys_relation" VALUES (1111546349863624706, 131, 1);
INSERT INTO "sys_relation" VALUES (1111546349884596226, 135, 1);
INSERT INTO "sys_relation" VALUES (1111546349901373442, 136, 1);
INSERT INTO "sys_relation" VALUES (1111546349922344962, 137, 1);
INSERT INTO "sys_relation" VALUES (1111546349939122178, 152, 1);
INSERT INTO "sys_relation" VALUES (1111546349960093697, 153, 1);
INSERT INTO "sys_relation" VALUES (1111546349976870914, 154, 1);
INSERT INTO "sys_relation" VALUES (1111546349993648129, 132, 1);
INSERT INTO "sys_relation" VALUES (1111546350010425346, 138, 1);
INSERT INTO "sys_relation" VALUES (1111546350031396865, 139, 1);
INSERT INTO "sys_relation" VALUES (1111546350048174081, 140, 1);
INSERT INTO "sys_relation" VALUES (1111546350069145602, 155, 1);
INSERT INTO "sys_relation" VALUES (1111546350085922818, 156, 1);
INSERT INTO "sys_relation" VALUES (1111546350106894338, 157, 1);
INSERT INTO "sys_relation" VALUES (1111546350127865858, 133, 1);
INSERT INTO "sys_relation" VALUES (1111546350144643073, 160, 1);
INSERT INTO "sys_relation" VALUES (1111546350169808898, 161, 1);
INSERT INTO "sys_relation" VALUES (1111546350186586113, 141, 1);
INSERT INTO "sys_relation" VALUES (1111546350211751937, 142, 1);
INSERT INTO "sys_relation" VALUES (1111546350232723458, 143, 1);
INSERT INTO "sys_relation" VALUES (1111546350262083585, 144, 1);
INSERT INTO "sys_relation" VALUES (1111546350278860801, 171, 1);
INSERT INTO "sys_relation" VALUES (1111546350299832322, 149, 1);
INSERT INTO "sys_relation" VALUES (1111546350324998146, 172, 1);
INSERT INTO "sys_relation" VALUES (1111546350345969665, 145, 1);
INSERT INTO "sys_relation" VALUES (1111546350371135489, 1111545968697860098, 1);
INSERT INTO "sys_relation" VALUES (1111546350387912705, 1111546189892870145, 1);
INSERT INTO "sys_relation" VALUES (1111546350404689921, 1110777136265838594, 1);
INSERT INTO "sys_relation" VALUES (1111546350421467137, 1110777366856089602, 1);
INSERT INTO "sys_relation" VALUES (1111546350446632962, 1110777491464667137, 1);
INSERT INTO "sys_relation" VALUES (1111546350459215873, 1110787391943098370, 1);
INSERT INTO "sys_relation" VALUES (1111546350471798786, 1110839216310329346, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "sys_role";
CREATE TABLE "sys_role" (
  "role_id" int8 NOT NULL,
  "pid" int8,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "sort" int4,
  "version" int4,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "create_user" int8,
  "update_user" int8
)
;
ALTER TABLE "sys_role" OWNER TO "guns";

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO "sys_role" VALUES (1, 0, '超级管理员', 'administrator', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO "sys_role" VALUES (5, 1, '临时', 'temp', 2, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "sys_user";
CREATE TABLE "sys_user" (
  "user_id" int8 NOT NULL,
  "avatar" varchar(255) COLLATE "pg_catalog"."default",
  "account" varchar(45) COLLATE "pg_catalog"."default",
  "password" varchar(45) COLLATE "pg_catalog"."default",
  "salt" varchar(45) COLLATE "pg_catalog"."default",
  "name" varchar(45) COLLATE "pg_catalog"."default",
  "birthday" timestamp(6),
  "sex" varchar(32) COLLATE "pg_catalog"."default",
  "email" varchar(45) COLLATE "pg_catalog"."default",
  "phone" varchar(45) COLLATE "pg_catalog"."default",
  "role_id" varchar(255) COLLATE "pg_catalog"."default",
  "dept_id" int8,
  "status" varchar(32) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "create_user" int8,
  "update_time" timestamp(6),
  "update_user" int8,
  "version" int4
)
;
ALTER TABLE "sys_user" OWNER TO "guns";

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO "sys_user" VALUES (1, '1', 'admin', '1d6b1208c7d151d335790276a18e3d99', 'q6taw', 'stylefeng', '2018-11-16 00:00:00', 'M', 'sn93@qq.com', '18200000000', '1', 27, 'ENABLE', '2016-01-29 08:49:53', NULL, '2018-12-28 22:52:24', 24, 25);
COMMIT;

-- ----------------------------
-- Primary Key structure for table sys_dept
-- ----------------------------
ALTER TABLE "sys_dept" ADD CONSTRAINT "sys_dept_pkey" PRIMARY KEY ("dept_id");

-- ----------------------------
-- Primary Key structure for table sys_dict
-- ----------------------------
ALTER TABLE "sys_dict" ADD CONSTRAINT "sys_dict_pkey" PRIMARY KEY ("dict_id");

-- ----------------------------
-- Primary Key structure for table sys_dict_type
-- ----------------------------
ALTER TABLE "sys_dict_type" ADD CONSTRAINT "sys_dict_type_pkey" PRIMARY KEY ("dict_type_id");

-- ----------------------------
-- Primary Key structure for table sys_file_info
-- ----------------------------
ALTER TABLE "sys_file_info" ADD CONSTRAINT "sys_file_info_pkey" PRIMARY KEY ("file_id");

-- ----------------------------
-- Primary Key structure for table sys_login_log
-- ----------------------------
ALTER TABLE "sys_login_log" ADD CONSTRAINT "sys_login_log_pkey" PRIMARY KEY ("login_log_id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "sys_menu" ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("menu_id");

-- ----------------------------
-- Primary Key structure for table sys_notice
-- ----------------------------
ALTER TABLE "sys_notice" ADD CONSTRAINT "sys_notice_pkey" PRIMARY KEY ("notice_id");

-- ----------------------------
-- Primary Key structure for table sys_operation_log
-- ----------------------------
ALTER TABLE "sys_operation_log" ADD CONSTRAINT "sys_operation_log_pkey" PRIMARY KEY ("operation_log_id");

-- ----------------------------
-- Primary Key structure for table sys_relation
-- ----------------------------
ALTER TABLE "sys_relation" ADD CONSTRAINT "sys_relation_pkey" PRIMARY KEY ("relation_id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("user_id");
