layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 充值记录表管理
     */
    var Recharge = {
        tableId: "rechargeTable"
    };

    /**
     * 初始化表格的列
     */
    Recharge.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'rechargeid', hide: true, title: '主键ID'},
            {field: 'spnumid', sort: true, title: 'spnumid'},
            {field: 'cnt', sort: true, title: '条数'},
            {field: 'entid', sort: true, title: '企业ID'},
            {field: 'userid', sort: true, title: '操作人'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Recharge.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Recharge.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Recharge.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/recharge/add';
    };

    /**
     * 导出excel按钮
     */
    Recharge.exportExcel = function () {
        var checkRows = table.checkStatus(Recharge.tableId);
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
    Recharge.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/recharge/edit?rechargeid=' + data.rechargeid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Recharge.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/recharge/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Recharge.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("rechargeid", data.rechargeid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Recharge.tableId,
        url: Feng.ctxPath + '/recharge/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Recharge.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Recharge.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Recharge.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Recharge.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Recharge.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Recharge.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Recharge.onDeleteItem(data);
        }
    });
});
