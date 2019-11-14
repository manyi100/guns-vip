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
            {field: 'protocolId', sort: true, title: '协议ID'},
            {field: 'spId', sort: true, title: '运营商ID'},
            {field: 'entId', sort: true, title: '企业ID'},
            {field: 'spnumIp', sort: true, title: '接入号IP'},
            {field: 'spnumPort', sort: true, title: '端口号'},
            {field: 'spnum', sort: true, title: 'SP号码'},
            {field: 'spnumBody', sort: true, title: '帐号'},
            {field: 'spnumPass', sort: true, title: '密码'},
            {field: 'sendSpeed', sort: true, title: '发送速率'},
            {field: 'balance', sort: true, title: '余额'},
            {field: 'price', sort: true, title: '单价，分'},
            {field: 'province', sort: true, title: '落地省份'},
            {field: 'channelNum', sort: true, title: '通道数量'},
            {field: 'entmsnUse', sort: true, title: '用途：0,管理员，1，客户端'},
            {field: 'gwStation', sort: true, title: '网关标记'},
            {field: 'blockarea', sort: true, title: '屏蔽区域'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'clientIp', sort: true, title: '客户端IP'},
            {field: 'version', sort: true, title: '版本号'},
            // {field: 'status', sort: true, title: '状态'},
            {
                field: 'status', sort: true, title: '状态', templet: function (d) {
                    if (d.status === 0) {
                        return "启用";
                    } else {
                        return "禁用";
                    }
                }
            },
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
        if (checkRows.data.length === 0) {
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
