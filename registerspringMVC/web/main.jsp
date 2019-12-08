<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/12/8
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a").click(function () {
                //获取当前对象的上一次标签的兄弟标签
               var $td = $(this).parent().prev();
               //html方法返回的是字符串 所以要强转为int
               $td.html(parseInt($td.html())+1);
            });
        });
    </script>
</head>
<body>
<table border="1px">
    <tr>
        <td>资料名称</td>
        <td>下载次数</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="file">
        <tr>
            <td>${file.name}</td>
            <td>${file.count}</td>
            <td><a href="download?id=${file.id}&name=${file.name}">下载</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
