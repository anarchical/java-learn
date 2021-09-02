<%--
  Created by IntelliJ IDEA.
  com.leaf.User: tyrion
  Date: 2021/8/2
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("session-login/login.jsp");
    }
%>
<html>
<head>
    <title>首页</title>
</head>
<body>

<h1>欢迎回来</h1>
<%=username%>

<a href="/sessionLogout">退出登录</a>

</body>
</html>
