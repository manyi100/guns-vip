layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 参数配置管理
     */
    var SConfig = {
        tableId: "sConfigTable"
    };

    /**
     * 初始化表格的列
     */
    SConfig.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'name', sort: true, title: '名称'},
            {field: 'code', sort: true, title: '属性编码标识'},
            {field: 'dictFlag', sort: true, title: '是否是字典中的值'},
            {field: 'dictTypeId', sort: true, title: '字典类型的编码'},
            {field: 'value', sort: true, title: '属性值，如果是字典中的类型，则为dict的code'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'createUser', sort: true, title: '创建人'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'updateUser', sort: true, title: '更新人'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    SConfig.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(SConfig.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    SConfig.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/sConfig/add';
    };

    /**
     * 导出excel按钮
     */
    SConfig.exportExcel = function () {
        var checkRows = table.checkStatus(SConfig.tableId);
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
    SConfig.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/sConfig/edit?id=' + data.id;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    SConfig.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/sConfig/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(SConfig.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + SConfig.tableId,
        url: Feng.ctxPath + '/sConfig/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: SConfig.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        SConfig.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        SConfig.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        SConfig.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + SConfig.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            SConfig.openEditDlg(data);
        } else if (layEvent === 'delete') {
            SConfig.onDeleteItem(data);
        }
    });
});
