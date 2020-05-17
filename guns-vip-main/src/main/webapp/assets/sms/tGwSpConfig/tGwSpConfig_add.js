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
        limitime: "",
        clientIp: "",
        version: "",
        status: "",
        online: "",
        frequency: "",
        issignname: "",
        istemplate: "",
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

    //生成8位随机密码
    $("#randomPassButton").click(function () {
        var randompassword=Feng.randompassword(8);
        $("#spnumPass").val(randompassword);
    });

    //通道类型(仅服务端使用)
    form.on('checkbox(channeltype)', function(data){
        //将页面全部复选框选中的值拼接到一个数组中
        var arr_box = [];
        $('input[type=checkbox]:checked').each(function() {
            arr_box.push($(this).val());
        });
        //数组
        console.log(arr_box)

        channeltype=arr_box.join("");
        console.log("type:"+channeltype)
        $("#entId").val(channeltype);
    });


    form.on('select(entmsnUse)', function(data){
        if(data.value=='0')//服务端
        {
            console.log("服务端")
            $("#serverpanel").removeAttr("style");
            $("#entId").attr("lay-verify","required");

        }else if (data.value=='1')//客户端
        {
            $("#serverpanel").attr("style","display: none");
            $("#entId").removeAttr("lay-verify");
            $("#entId").val("1");
        }
    });

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

});