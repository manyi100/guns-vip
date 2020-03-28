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
            {field: 'entityName', sort: true, title: '用户名'},
            {field: 'srcId', sort: true, title: '源号码'},
            {field: 'destterminalId', sort: true, title: '目的号码'},
            {field: 'content', sort: true, title: '内容'},
            {field: 'msgId', sort: true, title: 'Msgid'},
            {field: 'result', sort: true, title: '网关状态'},
            {field: 'sequenceid', hide: true,sort: true, title: '序列号'},
            {field: 'linkId', hide:true,sort: true, title: 'linkId'},
            {field: 'msgsrc', sort: true, title: '接入号'},
            // {field: 'spid', sort: true, title: '运营商ID'},
            {
                field: 'spid', align: "center", sort: true, title: '运营商', templet: function (d) {
                    if (d.spid === 1) {
                        return "中国电信";
                    } else if (d.spid === 2){
                        return "中国网通";
                    }else if (d.spid === 3){
                        return "中国移动";
                    }else if (d.spid === 4){
                        return "中国联通";
                    }else {
                        return "未知";
                    }
                }
            },
            {field: 'province', sort: true, title: '省份'},
            {field: 'city', sort: true, title: '城市'},
            {field: 'areacode',hide:true, sort: true, title: '区号'},
            // {field: 'status', sort: true, title: '状态 0 未发送，己发送'},
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
            {field: 'entityid', sort: true, title: '发送网关'},
            {field: 'realmsgid', hide: true,sort: true, title: '返回id'},
            {field: 'realresult', sort: true, title: '返回状态'},
            {field: 'submitDate', sort: true, title: '提交时间'},
            {field: 'sendDate', sort: true, title: '处理时间'}
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
    Send.search = function () {
        var queryData = {};
        queryData['destterminalId'] = $("#destterminalId").val();
        queryData['submitDate'] = $("#submitDate").val();
        queryData['entityName'] = $("#entityName").val();
        table.reload(Send.tableId, {
            where: queryData, page: {curr: 1}
        });
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



    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Send.tableId,
        url: Feng.ctxPath + '/send/list',
        where:{"submitDate":Feng.currentDate},
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Send.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Send.search();
    });


    // 导出excel
    $('#btnExp').click(function () {
        Send.exportExcel();
    });


});
