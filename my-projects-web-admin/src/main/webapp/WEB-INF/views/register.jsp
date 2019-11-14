<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form>
    <p id="xinxi"></p>
    <label>登录名</label>
    <input name="nickname" id="nickname" type="text"><br>
    <label>密码</label>
    <input name="password" id="password" type="password"><br>
    <label>确认密码</label>
    <input name="password1" id="password1" type="password"><br>
    <label>电话号码</label>
    <input name="tel" id="tel" type="text"><br>
    <label>地址</label>
    <input name="address" id="address" type="text"><br>
    <input id="avatar" type="file" name="avatar" placeholder="上传头像"><br>
    <button type="button" id="zhuce">注册</button>
    <button type="button" id="fanhui">返回</button>
</form>
<!-- 引入jQuery -->
<script src="/static/assets/js/jquery.min.js"></script>
<!-- 用于头像上传的js脚本 -->
<script src="/static/assets/js/ajaxfileupload.js"></script>

<script>

    jQuery(document).ready(function($) {
        $("#zhuce").click(function () {
            var nickname=$("#nickname").val();
            var password=$("#password").val();
            var password1=$("#password1").val();
            var tel=$("#tel").val();
            var address=$("#address").val();
            var avatar = document.getElementById('avatar');
            if(!avatar.value || nickname=="" || password=="" || password1=="" || tel=="" || address==""){
                $("#xinxi").html("请填完您的注册信息：");
            }else{
                if (password!=password1){
                    $("#xinxi").html("两次密码输入不一致，请重新输入：");
                }else{
                    $.ajaxFileUpload({
                        url:"/user/registers?nickname="+nickname+"&password="+password+"&tel="+tel+"&address="+address,
                        type:"post",
                        //data:{"name":name,"loginName":loginName,"pwd":pwd},
                        fileElementId : "avatar",
                        dataType:"json",
                        success:function (msg) {
                            if (msg.code!=1){
                                $("#xinxi").html(msg.data);
                            }else{
                                location.href = "${pageContext.request.contextPath }/route/index?page=login";
                            }
                        }
                    });
                }
            }
        });

        /**
         * 返回按钮
         */
        $("#fanhui").click(function () {
            location.href = "/route/index?page=login";
        });
    })

</script>

</body>
</html>
