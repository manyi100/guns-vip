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

layui.use(['form', 'admin', 'ax','element', 'laydate','upload','layer'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var element = layui.element;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;

    //让当前iframe弹层高度适应
    admin.iframeAuto();

    //一些事件监听
    element.on('tab(demo)', function(data){
        console.log(data);
        if(data.index==3)
        {
            $("#destterminalId").removeAttr("lay-verify");
            $("#content").removeAttr("lay-verify");
            $("#groupid").removeAttr("lay-verify");
            $("#contentID").attr("style","display: none");

        }else if(data.index==0)
        {
            $("#destterminalId").attr("lay-verify","required");
            $("#content").attr("lay-verify","required");
            $("#groupid").removeAttr("lay-verify");
            $("#contentID").removeAttr("style");
        }else if(data.index==1)
        {
            $("#destterminalId").removeAttr("lay-verify");
            $("#content").attr("lay-verify","required");
            $("#groupid").removeAttr("lay-verify");
            $("#contentID").removeAttr("style");
        }else if(data.index==2)
        {
            $("#destterminalId").removeAttr("lay-verify");
            $("#content").attr("lay-verify","required");
            $("#groupid").attr("lay-verify","required");
            $("#contentID").removeAttr("style");
        }
    });

    //立即发送或定时发送
    form.on('select(selectsubmitDate)', function(data){
        if(data.value=='0')
        {
            $("#submitDate").attr("style","display: none");

        }else if(data.value=='1')
        {
            $("#submitDate").removeAttr("style");
        }
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var index = layer.load(2);
        $("#btnSubmit").disabled=true;
        var ajax = new $ax(Feng.ctxPath + "/send/addItem", function (data) {
            layer.close(index);
            Feng.success("发送成功！");
            window.location.href = Feng.ctxPath + '/send'
        }, function (data) {
            Feng.error("发送失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //返回按钮
    $("#backupPage").click(function () {
        window.location.href = Feng.ctxPath + '/send'
    });
    //执行一个laydate实例
    laydate.render({
        elem: '#submitDate' //指定元素
        ,format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
        ,value: new Date()
        ,type: 'datetime'
        ,isInitValue: true //是否允许填充初始值，默认为 true
        // ,show: true //直接显示
    });

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

    // 执行实例-（个性化上传）
    var uploadInst = upload.render({
        elem: '#btnImp'
        , url: '/excel/uploadExcel'
        ,accept: 'file'
        , done: function (res) {
            // table.reload(SendInfoDlg.tableId, {url: Feng.ctxPath + "/excel/getUploadSendData"});
            Feng.success("上传成功！");
        }
        , error: function () {
            //请求异常回调
        }
    });
    // 执行实例（只传号码）
    var uploadInst1 = upload.render({
        elem: '#btnImp1'
        , url: '/excel/uploadExcel'
        ,accept: 'file'
        , done: function (res) {
            // table.reload(SendInfoDlg.tableId, {url: Feng.ctxPath + "/excel/getUploadSendData"});
            Feng.success("上传成功！");
        }
        , error: function () {
            //请求异常回调
        }
    });
    //字数统计
    window.wordLeg = function (obj) {
        var currleg = $(obj).val().length;
        var length = $(obj).attr('maxlength');
        var count=0;
        if(currleg>70) {
            count = Math.ceil(currleg / 67);
        }else {
            count=1
        }

        if (currleg > length) {
            layer.msg('字数请在' + length + '字以内');
        } else {
            $('.text_count').text(currleg);
            $('.count').text(count);
        }
    }

    //显示联系人分组
    activeDictSelect();
});