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
</head>
<body>
    <form action="process.jsp" method='POST' >
        <label>
            Login:
            <input type='text' name='user'/>
        </label>
        <label>
            Password:
            <input type='password' name='pwd' />
        </label>
        <input type='submit' value='Log in' />
    </form>

</body>
</html>
