layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 日统计表管理
     */
    var Daystat = {
        tableId: "daystatTable"
    };

    /**
     * 初始化表格的列
     */
    Daystat.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'taskId', hide: true, title: '主键ID'},
            {field: 'statDate', sort: true, title: '统计日期'},
            {field: 'entityName', sort: true, title: '用户名'},
            {field: 'submitcnt', sort: true, title: '提交数量'},
            {field: 'submitsucccnt', sort: true, title: '提交成功'},
            {field: 'submitfailcnt', sort: true, title: '提交失败'},
            {field: 'submitsuccrate', sort: true, title: '提交成功率'},
            {field: 'reportcnt', sort: true, title: '报告数量'},
            {field: 'reportsucccnt', sort: true, title: '报告成功'},
            {field: 'reportfailcnt', sort: true, title: '报告成功'},
            {field: 'reportunknowcnt', sort: true, title: '报告未知'},
            {field: 'reportsuccrate', sort: true, title: '报告成功率'},
            {field: 'submitDate', sort: true, title: '创建时间'},
            {field: 'updateDate', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Daystat.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Daystat.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Daystat.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/daystat/add';
    };

    /**
     * 导出excel按钮
     */
    Daystat.exportExcel = function () {
        var checkRows = table.checkStatus(Daystat.tableId);
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
    Daystat.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/daystat/edit?taskId=' + data.taskId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Daystat.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/daystat/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Daystat.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("taskId", data.taskId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Daystat.tableId,
        url: Feng.ctxPath + '/daystat/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Daystat.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Daystat.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Daystat.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Daystat.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Daystat.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Daystat.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Daystat.onDeleteItem(data);
        }
    });
});
