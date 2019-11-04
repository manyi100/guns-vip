/**
 * 详情对话框
 */
var MenuInfoDlg = {
    data: {
        pid: "",
        pcodeName: ""
    }
};

layui.use(['layer', 'form', 'admin', 'laydate', 'ax', 'iconPicker'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;
    var iconPicker = layui.iconPicker;

    //获取菜单信息
    var ajax = new $ax(Feng.ctxPath + "/menu/getMenuInfo?menuId=" + Feng.getUrlParam("menuId"));
    var result = ajax.start();
    form.val('menuForm', result.data);

    // 点击父级菜单
    $('#pcodeName').click(function () {
        var formName = encodeURIComponent("parent.MenuInfoDlg.data.pcodeName");
        var formId = encodeURIComponent("parent.MenuInfoDlg.data.pid");
        var treeUrl = encodeURIComponent("/menu/selectMenuTreeList");

        layer.open({
            type: 2,
            title: '父级菜单',
            area: ['300px', '400px'],
            content: Feng.ctxPath + '/system/commonTree?formName=' + formName + "&formId=" + formId + "&treeUrl=" + treeUrl,
            end: function () {
                $("#pid").val(MenuInfoDlg.data.pid);
                $("#pcodeName").val(MenuInfoDlg.data.pcodeName);
            }
        });
    });

    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/menu/edit", function (data) {
            Feng.success("修改成功！");

            //跳转列表页面并刷新
            window.location.href = Feng.ctxPath + "/menu";

        }, function (data) {
            Feng.error("修改失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        //添加 return false 可成功跳转页面
        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + "/menu";
    });

    //初始化图标选择
    iconPicker.render({
        elem: '#icon',
        type: 'fontClass',
        search: true,
        page: true,
        limit: 12,
        click: function (data) {

        }
    });

    iconPicker.checkIcon('iconPicker', result.data.icon);
});