/**
 * 添加或者修改页面
 */
var ContactsInfoDlg = {
    data: {
        mobile: "",
        contactsname: "",
        sex: "",
        email: "",
        address: "",
        qq: "",
        birthday: "",
        groupid: "",
        status: "",
        entid: "",
        remark: "",
        adddate: ""
    }
};

layui.use(['form', 'admin', 'ax','upload'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var upload=layui.upload;
    //让当前iframe弹层高度适应
    admin.iframeAuto();


    //初始化联系人分组
    var activeDictSelect = function () {
        //初始化所有字典类型
        $("#groupid").html('<option value="">请选择联系人分组</option>');
        var ajax = new $ax(Feng.ctxPath + "/contacts/gen", function (data) {

            for (var i = 0; i < data.data.length; i++) {
                var dictTypeId = data.data[i].groupid;
                var name = data.data[i].groupname;
                $("#groupid").append('<option value="' + dictTypeId + '">' +  name + '</option>');
            }
            form.render();

        }, function (data) {
        });
        ajax.start();
    };


    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {

        if (!$("#groupid").val()) {
            Feng.error("请选择具体联系人分组！");
            return false;
        }
        var ajax = new $ax(Feng.ctxPath + "/contacts/addItem", function (data) {
            Feng.success("添加成功！");
            window.location.href = Feng.ctxPath + '/contacts'
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //显示联系人分组
    activeDictSelect();
});