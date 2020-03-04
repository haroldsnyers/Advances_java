<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 02/03/2020
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' type='text/css' href='css/style.css'>
</head>
<body>
    <%
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
    %>

    <%
        if(user.equals("test") && pwd.equals("test")){
    %>
    <h1> you are logged in as <%= user %> </h1>
    <%
        }else{
            response.sendRedirect("login.jsp");
        }
    %>
    <div class='button_form'>
        <form action="process.jsp" method="post">
            <input type="submit" value="continue" name="continue">
        </form>
        <form action="logout.jsp" method="post">
            <input type="submit" value="logout" name="logout">
        </form>
    </div>

</body>
</html>
