layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 联系人分组表管理
     */
    var Contactsgroup = {
        tableId: "contactsgroupTable"
    };

    /**
     * 初始化表格的列
     */
    Contactsgroup.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'groupid', hide: true, title: '分组ID'},
            {field: 'groupname', sort: true, title: '联系人组名'},
            {field: 'orderid', sort: true, title: '序列 '},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Contactsgroup.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Contactsgroup.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Contactsgroup.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/contactsgroup/add';
    };

    /**
     * 导出excel按钮
     */
    Contactsgroup.exportExcel = function () {
        var checkRows = table.checkStatus(Contactsgroup.tableId);
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
    Contactsgroup.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/contactsgroup/edit?groupid=' + data.groupid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Contactsgroup.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/contactsgroup/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Contactsgroup.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("groupid", data.groupid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Contactsgroup.tableId,
        url: Feng.ctxPath + '/contactsgroup/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Contactsgroup.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Contactsgroup.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Contactsgroup.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Contactsgroup.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Contactsgroup.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Contactsgroup.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Contactsgroup.onDeleteItem(data);
        }
    });
});
