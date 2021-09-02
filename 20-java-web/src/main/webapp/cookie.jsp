<%--
  Created by IntelliJ IDEA.
  com.leaf.User: maqianhui
  Date: 2021/8/1，第32周
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("name", "cookie");
    cookie.setValue("cookie value");
    response.addCookie(cookie);
%>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<h1>Cookie</h1>

</body>
</html>
