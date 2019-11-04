layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 短信接收表管理
     */
    var Deliver = {
        tableId: "deliverTable"
    };

    /**
     * 初始化表格的列
     */
    Deliver.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'deliverId', hide: true, title: '主键ID'},
            {field: 'entityName', sort: true, title: '接入码'},
            {field: 'msgId', sort: true, title: 'Msgid'},
            {field: 'destid', sort: true, title: '源号码'},
            {field: 'srcterminalid', sort: true, title: '目的号码'},
            {field: 'msgContent', sort: true, title: '上行内容'},
            {field: 'sequenceId', sort: true, title: 'sequenceId'},
            {field: 'status', sort: true, title: '状态0,未发送，1己发送'},
            {field: 'submitDate', sort: true, title: '提交时间'},
            {field: 'dealDate', sort: true, title: '处理时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Deliver.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Deliver.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Deliver.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/deliver/add';
    };

    /**
     * 导出excel按钮
     */
    Deliver.exportExcel = function () {
        var checkRows = table.checkStatus(Deliver.tableId);
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
    Deliver.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/deliver/edit?deliverId=' + data.deliverId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Deliver.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/deliver/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Deliver.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deliverId", data.deliverId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Deliver.tableId,
        url: Feng.ctxPath + '/deliver/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Deliver.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Deliver.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Deliver.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Deliver.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Deliver.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Deliver.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Deliver.onDeleteItem(data);
        }
    });
});
