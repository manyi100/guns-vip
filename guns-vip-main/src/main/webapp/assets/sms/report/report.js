layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 回执表管理
     */
    var Report = {
        tableId: "reportTable"
    };

    /**
     * 初始化表格的列
     */
    Report.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'reportId', hide: true, title: '主键ID'},
            {field: 'entityName', sort: true, title: '接入码'},
            {field: 'msgId', sort: true, title: 'Msgid'},
            {field: 'srcmsgId', sort: true, title: '原Msgid和send表中msgid对应'},
            {field: 'stat', sort: true, title: '回执状态'},
            {field: 'err', sort: true, title: '错误代码表'},
            {field: 'destid', sort: true, title: '源号码'},
            {field: 'srcterminalid', sort: true, title: '目的号码'},
            {field: 'linkId', sort: true, title: 'linkId'},
            {field: 'serverid', sort: true, title: 'serverid'},
            {field: 'status', sort: true, title: '状态0,未发送，1己发送'},
            {field: 'submitDate', sort: true, title: '提交时间'},
            {field: 'dealDate', sort: true, title: '处理时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Report.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Report.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Report.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/report/add';
    };

    /**
     * 导出excel按钮
     */
    Report.exportExcel = function () {
        var checkRows = table.checkStatus(Report.tableId);
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
    Report.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/report/edit?reportId=' + data.reportId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Report.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/report/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Report.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("reportId", data.reportId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Report.tableId,
        url: Feng.ctxPath + '/report/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Report.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Report.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Report.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Report.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Report.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Report.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Report.onDeleteItem(data);
        }
    });
});
