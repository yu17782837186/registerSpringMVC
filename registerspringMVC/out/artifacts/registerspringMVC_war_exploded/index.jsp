<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/12/8
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function () {
          var username = false;
          var password = false;
          var passwordSure = false;
          //用户名的验证
          $(":text:eq(0)").blur(function () {
              if ($(this).val()=="") {
                  $(this).next().css("color","red").html("x");
                  username = false;
              }else {
                  $(this).next().css("color","green").html("√");
                  username = true;
              }
          });
          //密码的验证
          $(":password:eq(0)").blur(function () {
              //在js中要求正则两侧//
             if (!$(this).val().match(/^\w{6,12}$/)) {
                 $(this).next().css("color","red").html("x");
                 password = false;
             }else {
                 $(this).next().css("color","green").html("√");
                 password = true;
             }
          });
          //确认密码
          $(":password:eq(1)").blur(function () {
              if ($(this).val()==""||$(this).val()!=$(":password:eq(0)").val()) {
                  $(this).next().css("color","red").html("x");
                  passwordSure = false;
              }else {
                  $(this).next().css("color","green").html("√");
                  passwordSure = true;
              }
          });
          $(":submit").click(function () {
              if (username==false||password==false||passwordSure==false||$(":file:eq(0)").val()=="") {
                  alert("请添加完整信息")
                  return false;
              }
          });
      });
    </script>
  </head>
  <body>
  <form action="register" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"/><span></span><br/>
    密码：<input type="password" name="password"/><span></span><br/>
    确认密码：<input type="password" name="passwordSure"/><span></span><br/>
    头像：<input type="file" name="file"/><br/>
    <input type="submit" value="注册"/>
  </form>
  </body>
</html>
