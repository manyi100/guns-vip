layui.use(['table', 'admin', 'ax','laydate'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laydate = layui.laydate;

    /**
     * 发送表管理
     */
    var Send = {
        tableId: "sendTable"
    };

    /**
     * 初始化表格的列
     */
    Send.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'taskId', hide: true, title: '主键ID'},
            {field: 'content', sort: true, title: '内容'},
            {field: 'srcId', sort: true, title: '源号码'},
            {field: 'destterminalId', sort: true, title: '目的号码'},
            {field: 'entityName', sort: true, title: '接入码'},
            {field: 'msgId', sort: true, title: 'Msgid'},
            {field: 'result', sort: true, title: '网关返回状态'},
            {field: 'sequenceid', sort: true, title: '网关返回序列号'},
            {field: 'linkId', hide:true,sort: true, title: 'linkId'},
            {field: 'msgsrc', sort: true, title: '接入号'},
            {field: 'spid', sort: true, title: '运营商ID'},
            {field: 'province', sort: true, title: '省份'},
            {field: 'city', sort: true, title: '城市'},
            {field: 'areacode', sort: true, title: '区号'},
            // {field: 'status', sort: true, title: '状态 0 未发送，己发送'},
            {
                field: 'status', align: "center", sort: true, title: '状态', templet: function (d) {
                    if (d.status === 0) {
                        return "未发送";
                    } else {
                        return "己发送";
                    }
                }
            },
            {field: 'entityid', sort: true, title: '发送网关'},
            {field: 'realmsgid', sort: true, title: '真实网关返回id'},
            {field: 'realresult', sort: true, title: '真实网关返回状态'},
            {field: 'submitDate', sort: true, title: '提交时间'},
            {field: 'sendDate', sort: true, title: '处理时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Send.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        queryData['senddate'] = $("#senddate").val();
        table.reload(Send.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Send.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/send/add';
    };

    /**
     * 导出excel按钮
     */
    Send.exportExcel = function () {
        var checkRows = table.checkStatus(Send.tableId);
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
    Send.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/send/edit?taskId=' + data.taskId;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Send.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/send/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Send.tableId);
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
        elem: '#' + Send.tableId,
        url: Feng.ctxPath + '/send/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Send.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Send.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Send.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Send.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Send.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Send.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Send.onDeleteItem(data);
        }
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#senddate' //指定元素
        ,format: 'yyyy-MM-dd' //可任意组合
        // ,value: new Date().toString()
        // ,isInitValue: true //是否允许填充初始值，默认为 true
    });
});
