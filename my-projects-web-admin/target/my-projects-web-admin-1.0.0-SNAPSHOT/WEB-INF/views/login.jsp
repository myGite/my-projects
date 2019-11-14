<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form>
    <p id="xinxi"></p>
    <label>用户名</label>
    <input type="text" name="nickname" id="nickname"/>
    <label>密码</label>
    <input type="password" name="password" id="password"/>
    <input type="button" id="btn" value="登录">
</form>

<script src="/static/assets/js/jquery.min.js"></script>

<script>
    jQuery(document).ready(function($) {
        $("#btn").click(function () {
            var nickname=$("#nickname").val();
            var password=$("#password").val();
            if (nickname=="" || password==""){
                $("#xinxi").html("用户名或者密码不能为空！ 请输入用户名或密码：");
            }else{
                $.ajax({
                    url:"/user/login",
                    type:"post",
                    data:{"nickname":nickname,"password":password},
                    dataType:"json",
                    success:function (msg) {
                        if (msg.code!=1){
                            $("#xinxi").html(msg.data);
                        }else{
                            location.href = "/route/index?page=main";
                        }
                    }
                })
            }
        })
    });
</script>
</body>
</html>
