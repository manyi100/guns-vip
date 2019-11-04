/**
 * 添加或者修改页面
 */
var TGwSpConfigInfoDlg = {
    data: {
        protocolId: "",
        spId: "",
        entId: "",
        spnumIp: "",
        spnumPort: "",
        spnum: "",
        spnumBody: "",
        spnumPass: "",
        sendSpeed: "",
        balance: "",
        price: "",
        province: "",
        channelNum: "",
        entmsnUse: "",
        gwStation: "",
        blockarea: "",
        remark: "",
        clientIp: "",
        version: "",
        status: "",
        submitdate: "",
        dealdate: ""
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
        var ajax = new $ax(Feng.ctxPath + "/tGwSpConfig/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/tGwSpConfig'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/tGwSpConfig'
    });

    form.on('select(protocolId)', function(data){
        console.log(data.elem); //得到select原始DOM对象
        console.log(data.value); //得到被选中的值]
        $("#protocolId").val(data.value)//赋值
        console.log(data.othis); //得到美化后的DOM对象
    });


});