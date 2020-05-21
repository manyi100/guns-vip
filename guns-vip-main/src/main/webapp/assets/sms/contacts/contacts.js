layui.use(['table', 'admin', 'ax','upload'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var upload=layui.upload;

    /**
     * 联系人管理
     */
    var Contacts = {
        tableId: "contactsTable"
    };

    /**
     * 初始化表格的列
     */
    Contacts.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'contactsid', hide: true, title: '主键ID'},
            {field: 'mobile', sort: true, title: '手机号'},
            {field: 'contactsname', sort: true, title: '姓名'},
            {field: 'sex', sort: true, title: '性别'},
            {field: 'email', sort: true, title: '邮箱'},
            {field: 'address', sort: true, title: '地址'},
            {field: 'qq', sort: true, title: 'qq'},
            {field: 'birthday', sort: true, title: '生日'},
            {field: 'groupid', sort: true, title: '组别'},
            {field: 'status', sort: true, title: '状态'},
            {field: 'entid', hide: true,sort: true, title: '企业ID'},
            {field: 'remark', sort: true, title: '备注'},
            {field: 'adddate', sort: true, title: '提交时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Contacts.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Contacts.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Contacts.openAddDlg = function () {
        window.location.href = Feng.ctxPath + '/contacts/add';
    };

    /**
     * 导出excel按钮
     */
    Contacts.exportExcel = function () {
        var checkRows = table.checkStatus(Contacts.tableId);
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
    Contacts.openEditDlg = function (data) {
        window.location.href = Feng.ctxPath + '/contacts/edit?contactsid=' + data.contactsid;
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Contacts.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/contacts/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Contacts.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("contactsid", data.contactsid);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Contacts.tableId,
        url: Feng.ctxPath + '/contacts/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Contacts.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Contacts.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Contacts.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Contacts.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Contacts.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Contacts.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Contacts.onDeleteItem(data);
        }
    });

    //执行实例
    var uploadInst = upload.render({
        elem: '#btnImp'
        , url: '/excel/uploadExcel'
        ,accept: 'file'
        , done: function (res) {
            table.reload(Contacts.tableId, {url: Feng.ctxPath + "/excel/getUploadContactsData"});
            Feng.success("上传成功！");
        }
        , error: function () {
            //请求异常回调
        }
    });
});
