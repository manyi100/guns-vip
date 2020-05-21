layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 号段配置表管理
     */
    var Mobile = {
        tableId: "mobileTable"
    };

    /**
     * 初始化表格的列
     */
    Mobile.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'mobileid', hide: true, title: '主键ID'},
            {field: 'prefix', sort: true, title: '前缀'},
            {field: 'mobile', sort: true, title: '号段'},
            {field: 'province', sort: true, title: '省份'},
            {field: 'city', sort: true, title: '城市'},
            // {field: 'corp', sort: true, title: '运营商'},
            {
                field: 'corp', align: "center", sort: true, title: '运营商', templet: function (d) {
                    if (d.corp == 1) {
                        return "中国电信";
                    } else if (d.corp == 2){
                        return "中国网通";
                    }else if (d.corp == 3){
                        return "中国移动";
                    }else if (d.corp == 4){
                        return "中国联通";
                    }else {
                        return "未知";
                    }
                }
            },
            {field: 'areacode', sort: true, title: '区号'},
            {field: 'postcode', sort: true, title: '邮编'},
            {field: 'admincode', sort: true, title: '管理号'},
            {field: 'adddate', sort: true, title: '添加时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Mobile.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Mobile.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Mobile.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/mobile/add';
    };

    /**
     * 导出excel按钮
     */
    Mobile.exportExcel = function () {
        var checkRows = table.checkStatus(Mobile.tableId);
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
    Mobile.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/mobile/edit?mobileid=' + data.mobileid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Mobile.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/mobile/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Mobile.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("mobileid", data.mobileid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Mobile.tableId,
        url: Feng.ctxPath + '/mobile/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Mobile.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Mobile.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Mobile.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Mobile.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Mobile.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Mobile.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Mobile.onDeleteItem(data);
        }
    });
});
