<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>首页</title>
</head>
<body>
afsadfsadf
<h1 id="bbb"></h1>
<%--<a href="/shop/good?goodstypeids=1">aaa</a>--%>
<a href="/store/storeid?storeid=1">商家</a>

<form name="form1" id="form1" method="post">
    <label>商家id</label>
    <input type="text" name="storeid" id="storeid"><br>
    <label>用户id</label>
    <input type="text" name="userid" id="userid"><br>
    <label>评论内容</label>
    <input type="text" name="text" id="text"><br>
    <label>满意度</label>
    <input type="radio" value="满意" name="rateType">满意<br>
    <input type="radio" value="不满意" name="rateType">不满意<br>
    <label>评分</label>
    <input type="text" name="score" id="score"><br>
    <label>推荐</label>
    <input type="text" name="recommend" id="recommend"><br>
    <button type="button" name="tijiao" id="tijiao">提交</button>

</form>

<script src="/static/assets/js/jquery.min.js"></script>

<script>
    /*jQuery(document).ready(function ($) {
        function loadDict(goodstypeids) {
            $.ajax({
                url : "/shop/good",
                type : "post",
                data : {"goodstypeids":goodstypeids},
                dataType : "json",
                success : function(msg){
                    if(msg.code != 1){
                        return;
                    }
                    var goods = msg.data;

                    var str ='';
                    for(var i = 0; i < goods.length; i++){
                        var good = goods[i];
                        str += '<li><b >' + good.goodsname + '</b></li>';
                    }
                    $("#bbb").html(str);
                }
            });
        }
    })*/
    jQuery(document).ready(function ($) {
        $("#tijiao").click(function () {
            $.ajax({
                url:"/storereview/add",
                type:"post",
                data:$("#form1").serialize(),
                dataType:"json",
                success:function (msg) {
                    if (msg.code != 1){
                        $("#bbb").html("添加失败！");
                    }
                    $("#bbb").html(msg.message);
                }
            })
        })
    })
</script>
</body>
</html>
