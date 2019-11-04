/**
 * 添加或者修改页面
 */
var DeliverInfoDlg = {
    data: {
        entityName: "",
        msgId: "",
        destid: "",
        srcterminalid: "",
        msgContent: "",
        sequenceId: "",
        status: "",
        submitDate: "",
        dealDate: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //让当前iframe弹层高度适应
    admin.iframeAuto();

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/deliver/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/deliver'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/deliver'
    });

});