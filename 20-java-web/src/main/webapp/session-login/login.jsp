<%--
  Created by IntelliJ IDEA.
  com.leaf.User: tyrion
  Date: 2021/8/2
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/sessionLogin" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <label>
                    <input type="text" name="username">
                </label>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
