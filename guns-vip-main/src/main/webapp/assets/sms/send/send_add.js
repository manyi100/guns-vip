/**
 * 添加或者修改页面
 */
var SendInfoDlg = {
    data: {
        content: "",
        srcId: "",
        destterminalId: "",
        entityName: "",
        submitDate: "",
    }
};

layui.use(['form', 'admin', 'ax','element', 'laydate'], function () {
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

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/send'
    });

    //日期
    laydate.render({
        elem: '#submitDate'
        , type: 'datetime'
    });



    //执行实例
    var uploadInst = upload.render({
        elem: '#btnImp'
        , url: '/excel/uploadExcel'
        ,accept: 'file'
        , done: function (res) {
            table.reload(SendInfoDlg.tableId, {url: Feng.ctxPath + "/excel/getUploadBlockData"});
        }
        , error: function () {
            //请求异常回调
        }
    });
});