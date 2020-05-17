layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 网关配置表管理
     */
    var TGwSpConfig = {
        tableId: "tGwSpConfigTable"
    };

    /**
     * 初始化表格的列
     */
    TGwSpConfig.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'spnumId', hide: false, title: 'spnumId'},
            {
                field: 'entmsnUse', sort: true, title: '用途', templet: function (d) {
                    if (d.entmsnUse == 0) {
                        return "服务端";
                    } else {
                        return "客户端";
                    }
                }
            },
            {
                field: 'protocolId', sort: true, title: '短信协议', templet: function (d) {
                    if (d.protocolId == 1) {
                        return "SMPP";
                    } else  if (d.protocolId == 2){
                        return "SMGP";
                    }else  if (d.protocolId == 3){
                        return "CNGP";
                    }else  if (d.protocolId == 4){
                        return "CMPP";
                    }else  if (d.protocolId == 5){
                        return "SGIP";
                    }
                }
            },
            {
                field: 'spId', sort: true, title: '运营商', templet: function (d) {
                    if (d.spId == 1) {
                        return "中国电信";
                    } else  if (d.spId == 2){
                        return "中国网通";
                    }else  if (d.spId == 3){
                        return "中国移动";
                    }else  if (d.spId == 4){
                        return "中国联通";
                    }
                }
            },
            {field: 'entId', sort: true, title: '通道类型'},
            {field: 'spnumIp', sort: true, title: '接入号IP'},
            {field: 'spnumPort', sort: true, title: '端口号'},
            {field: 'spnum', sort: true, title: 'SP号码'},
            {
                field: 'online', sort: true, title: '是否在线', templet: function (d) {
                    if (d.online == 1) {
                        return "在线";
                    } else {
                        return "断线";
                    }
                }
            },
            {field: 'spnumBody', sort: true, title: '帐号'},
            {field: 'spnumPass', sort: true, title: '密码'},
            {field: 'sendSpeed', sort: true, title: '发送速率'},
            {field: 'balance', sort: true, title: '余额(条)'},
            {field: 'price', sort: true, title: '单价(分)'},
            {field: 'channelNum', sort: true, title: '通道数量'},
            // {field: 'version', sort: true, title: '版本号'},
            {
                field: 'version', sort: true, title: '版本号', templet: function (d) {
                    if (d.version == '0x20') {
                        return "0x20";
                    } else {
                        return "0x30";
                    }
                }
            },
            {
                field: 'status', sort: true, title: '状态', templet: function (d) {
                    if (d.status == 0) {
                        return "启用";
                    } else {
                        return "禁用";
                    }
                }
            },
            {field: 'gwStation', sort: true, title: '网关标记'},
            {field: 'province', sort: true, title: '通道号/落地'},
            {field: 'blockarea', sort: true, title: '屏蔽区域'},
            {field: 'clientIp', sort: true, title: '客户端IP'},
            {field: 'limitime', sort: true, title: '时间限制'},
            {field: 'frequency', sort: true, title: '频次限制'},
            {
                field: 'issignname', sort: true, title: '签名限制', templet: function (d) {
                    if (d.issignname == 1) {
                        return "启用";
                    } else {
                        return "禁用";
                    }
                }
            },
            {
                field: 'istemplate', sort: true, title: '内容审核', templet: function (d) {
                    if (d.istemplate == 1) {
                        return "启用";
                    } else {
                        return "禁用";
                    }
                }
            },
            {field: 'remark', sort: true, title: '备注'},
            {field: 'submitdate', sort: true, title: '提交时间'},
            {field: 'dealdate', sort: true, title: '修改时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    TGwSpConfig.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(TGwSpConfig.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    TGwSpConfig.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/tGwSpConfig/add';
    };

    /**
     * 导出excel按钮
     */
    TGwSpConfig.exportExcel = function () {
        var checkRows = table.checkStatus(TGwSpConfig.tableId);
        if (checkRows.data.length == 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    TGwSpConfig.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/tGwSpConfig/edit?spnumId=' + data.spnumId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    TGwSpConfig.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/tGwSpConfig/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(TGwSpConfig.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("spnumId", data.spnumId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + TGwSpConfig.tableId,
        url: Feng.ctxPath + '/tGwSpConfig/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: TGwSpConfig.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TGwSpConfig.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        TGwSpConfig.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        TGwSpConfig.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + TGwSpConfig.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            TGwSpConfig.openEditDlg(data);
        } else if (layEvent === 'delete') {
            TGwSpConfig.onDeleteItem(data);
        }
    });
});
