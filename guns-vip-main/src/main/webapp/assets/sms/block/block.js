layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 黑名单表管理
     */
    var Block = {
        tableId: "blockTable"
    };

    /**
     * 初始化表格的列
     */
    Block.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'blockid', hide: true, title: '主键ID'},
            {field: 'blockmobile', sort: true, title: '黑名单号码'},
            {field: 'entid', sort: true, title: '企业ID'},
            {field: 'blocktype', sort: true, title: '黑名单类型'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'status', sort: true,templet: '#statusTpl', title: '状态0,可用，1不可用'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Block.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Block.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Block.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/block/add';
    };

    /**
     * 导出excel按钮
     */
    Block.exportExcel = function () {
        var checkRows = table.checkStatus(Block.tableId);
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
    Block.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/block/edit?blockid=' + data.blockid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Block.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/block/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Block.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("blockid", data.blockid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Block.tableId,
        url: Feng.ctxPath + '/block/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Block.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Block.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Block.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Block.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Block.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Block.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Block.onDeleteItem(data);
        }
    });


    /**
     * 修改黑名单状态
     *
     * @param userId blockid
     * @param checked 是否选中（true,false），选中就是解锁用户，未选中就是锁定用户
     */
    Block.changeBlockStatus = function (blockid, checked) {
        if (checked==0) {
            var ajax = new $ax(Feng.ctxPath + "/block/unfreeze", function (data) {
                Feng.success("解除冻结成功!");
            }, function (data) {
                Feng.error("解除冻结失败!");
                table.reload(Block.tableId);
            });
            ajax.set("blockid", blockid);
            ajax.start();
        } else {
            var ajax = new $ax(Feng.ctxPath + "/block/freeze", function (data) {
                Feng.success("冻结成功!");
            }, function (data) {
                Feng.error("冻结失败!" + data.responseJSON.message + "!");
                table.reload(Block.tableId);
            });
            ajax.set("blockid", blockid);
            ajax.start();
        }
    };

    // 修改user状态
    form.on('switch(status)', function (obj) {

        var blockid = obj.elem.value;
        var checked = obj.elem.checked ? 0 : 1;

        Block.changeBlockStatus(blockid, checked);
    });
});
