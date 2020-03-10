/**
 * 添加或者修改页面
 */
function  randomPassword(size){//size是生成随机密码的位数

    var seed=new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z',

        'a','b','c','d','e','f','g','h','i','j','k','m','n','p','Q','r','s','t','u','v','w','x','y','z','0','1',

        '2','3','4','5','6','7','8','9'

    );//数组

    var seedlength=seed.length;//数组长度

    var createPassword='';

    for(var i=0;i<size;i++){

        var a=Math.floor(Math.random()*seedlength);

        createPassword+=seed[a];

    }

    return createPassword;

}
var TGwSpConfigInfoDlg = {
    data: {
        protocolId: "",
        spId: "",
        entId: "",
        spnumIp: "",
        spnumPort: "",
        spnum: "",
        spnumBody: "",
        spnumPass: randomPassword(8),
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