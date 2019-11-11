layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 运营商配置表管理
     */
    var TcGwSp = {
        tableId: "tcGwSpTable"
    };

    /**
     * 初始化表格的列
     */
    TcGwSp.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'spid', title: '协议ID'},
            {field: 'spname', sort: true, title: '名称'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    TcGwSp.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(TcGwSp.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    TcGwSp.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/tcGwSp/add';
    };

    /**
     * 导出excel按钮
     */
    TcGwSp.exportExcel = function () {
        var checkRows = table.checkStatus(TcGwSp.tableId);
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
    TcGwSp.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/tcGwSp/edit?spid=' + data.spid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    TcGwSp.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/tcGwSp/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(TcGwSp.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("spid", data.spid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + TcGwSp.tableId,
        url: Feng.ctxPath + '/tcGwSp/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: TcGwSp.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TcGwSp.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        TcGwSp.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        TcGwSp.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + TcGwSp.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            TcGwSp.openEditDlg(data);
        } else if (layEvent === 'delete') {
            TcGwSp.onDeleteItem(data);
        }
    });
});
