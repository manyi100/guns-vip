layui.use(['table', 'admin', 'ax','laydate'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laydate = layui.laydate;

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
            {field: 'entityName', sort: true, title: '用户名'},
            {field: 'destid', sort: true, title: '源号码'},
            {field: 'srcterminalid', sort: true, title: '目的号码'},
            {field: 'stat', sort: true, title: '回执状态'},
            {field: 'err', sort: true, title: '错误代码'},
            {field: 'msgId', sort: true, title: 'Msgid'},
            {field: 'srcmsgId', sort: true, title: '原Msgid'},
            {field: 'linkId',  hide: true,sort: true, title: 'linkId'},
            {field: 'serverid', hide: true, sort: true, title: 'serverid'},
            // {field: 'status', sort: true, title: '状态0,未发送，1己发送'},
            {
                field: 'status', align: "center", sort: true, title: '状态', templet: function (d) {
                    if (d.status === 0) {
                        return "未发送";
                    } else if (d.status === 1){
                        return "己发送";
                    }else if (d.status === 2){
                        return "发送失败";
                    }
                }
            },
            {field: 'submitDate', sort: true, title: '提交时间'},
            {field: 'dealDate', sort: true, title: '处理时间'}
        ]];
    };
//执行一个laydate实例
    laydate.render({
        elem: '#submitDate' //指定元素
        ,format: 'yyyy-MM-dd' //可任意组合
        ,value: new Date()
        ,isInitValue: true //是否允许填充初始值，默认为 true
        // ,show: true //直接显示
    });
    /**
     * 点击查询按钮
     */
    Report.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        queryData['submitDate'] = $("#submitDate").val();
        queryData['entityName'] = $("#entityName").val();
        queryData['stat'] = $("#stat").val();
        table.reload(Report.tableId, {
            where: queryData, page: {curr: 1}
        });
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



    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Report.tableId,
        url: Feng.ctxPath + '/report/list',
        where:{"submitDate":Feng.currentDate},
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Report.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Report.search();
    });


    // 导出excel
    $('#btnExp').click(function () {
        Report.exportExcel();
    });



});
