layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 短信协议配置表管理
     */
    var TcGwProtocol = {
        tableId: "tcGwProtocolTable"
    };

    /**
     * 初始化表格的列
     */
    TcGwProtocol.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'protocolid', hide: true, title: '协议ID，1，SMPP，2，SMGP，3，CNGP，4，CMPP，5，SGIP'},
            {field: 'protocolname', sort: true, title: '协议名称'},
            {field: 'chsname', sort: true, title: '中文名称'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    TcGwProtocol.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(TcGwProtocol.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    TcGwProtocol.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/tcGwProtocol/add';
    };

    /**
     * 导出excel按钮
     */
    TcGwProtocol.exportExcel = function () {
        var checkRows = table.checkStatus(TcGwProtocol.tableId);
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
    TcGwProtocol.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/tcGwProtocol/edit?protocolid=' + data.protocolid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    TcGwProtocol.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/tcGwProtocol/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(TcGwProtocol.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("protocolid", data.protocolid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + TcGwProtocol.tableId,
        url: Feng.ctxPath + '/tcGwProtocol/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: TcGwProtocol.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TcGwProtocol.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        TcGwProtocol.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        TcGwProtocol.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + TcGwProtocol.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            TcGwProtocol.openEditDlg(data);
        } else if (layEvent === 'delete') {
            TcGwProtocol.onDeleteItem(data);
        }
    });
});
