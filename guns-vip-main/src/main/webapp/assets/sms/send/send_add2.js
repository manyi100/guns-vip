/**
 * 添加或者修改页面
 */
var SendInfoDlg = {
    data: {
        content: "",
        srcId: "",
        destterminalId: "",
        entityName: "",
        msgId: "",
        result: "",
        sequenceid: "",
        linkId: "",
        msgsrc: "",
        spid: "",
        province: "",
        city: "",
        areacode: "",
        status: "",
        entityid: "",
        realmsgid: "",
        realresult: "",
        submitDate: "",
        sendDate: ""
    }
};

layui.use(['form', 'admin', 'ax','element', 'laydate','upload'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var element = layui.element;
    var laydate = layui.laydate;
    var upload = layui.upload;
    //让当前iframe弹层高度适应
    admin.iframeAuto();

    //一些事件监听
    element.on('tab(demo)', function(data){
        console.log(data);
    });
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/send/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/send'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#submitDate' //指定元素
        ,format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
        ,value: new Date()
        ,isInitValue: true //是否允许填充初始值，默认为 true
        // ,show: true //直接显示
    });
    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/send'
    });


    // 执行实例
    var uploadInst = upload.render({
        elem: '#btnImp'
        , url: '/excel/uploadExcel'
        ,accept: 'file'
        , done: function (res) {
            table.reload(SendInfoDlg.tableId, {url: Feng.ctxPath + "/excel/getUploadSendData"});
        }
        , error: function () {
            //请求异常回调
        }
    });

});