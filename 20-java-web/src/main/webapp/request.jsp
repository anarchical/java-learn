<%--
  Created by IntelliJ IDEA.
  com.leaf.User: yeyaqiao
  Date: 2021/7/28
  Time: 20:39:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--获取 Servlet 中存入的信息--%>
<%--<%String result = String.valueOf(request.getAttribute("result"));%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>request.jsp</h1>
<%--页面展示获取的信息--%>
<%--<%=result%>--%>
<%--EL表达式--%>
<h1>${result}</h1>
</body>
</html>
