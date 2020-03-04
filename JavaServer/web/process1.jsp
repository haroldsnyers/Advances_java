<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 04/03/2020
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String user = "";
        Cookie[] cookies = request.getCookies();
        for(Cookie c: cookies) {
            if (c.getName().equals("user")) {
                user = c.getValue();
            }
        }
    %>
    <h1> you are logged in as <%= user %> </h1>
    <div class='button_form'>
        <form action="home" method="post">
            <input type="submit" value="continue" name="continue">
        </form>
        <form action="home" method="post">
            <input type="submit" value="logout" name="logout">
        </form>
    </div>
</body>
</html>
