layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 余额变更表管理
     */
    var Balance = {
        tableId: "balanceTable"
    };

    /**
     * 初始化表格的列
     */
    Balance.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'balanceid', hide: true, title: '主键ID'},
            {field: 'spnumid', sort: true, title: 'spnumid'},
            // {field: 'balancetype', sort: true, title: '操作类型(自动补返,补款,扣款)'},
            {
                field: 'balancetype', align: "center", sort: true, title: '操作类型', templet: function (d) {
                    if (d.balancetype == 0) {
                        return "自动补返";
                    } else if (d.balancetype == 1){
                        return "补款";
                    }else if (d.balancetype == 2){
                        return "扣款";
                    }else{
                        return "其它";
                    }
                }
            },
            {field: 'optcount', sort: true, title: '操作条数'},
            {field: 'beforecount', sort: true, title: '操作前条数'},
            {field: 'curcount', sort: true, title: '操作后条数'},
            {field: 'entid',  hide: true,sort: true, title: '企业ID'},
            {field: 'userid',  hide: true,sort: true, title: '操作人ID'},
            {field: 'username', sort: true, title: '操作人'},

            {field: 'remark', sort: true, title: '备注'},
            {field: 'status', hide: true, sort: true, title: '状态'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Balance.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Balance.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Balance.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/balance/add';
    };

    /**
     * 导出excel按钮
     */
    Balance.exportExcel = function () {
        var checkRows = table.checkStatus(Balance.tableId);
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
    Balance.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/balance/edit?balanceid=' + data.balanceid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Balance.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/balance/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Balance.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("balanceid", data.balanceid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Balance.tableId,
        url: Feng.ctxPath + '/balance/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Balance.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Balance.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Balance.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Balance.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Balance.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Balance.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Balance.onDeleteItem(data);
        }
    });
});
