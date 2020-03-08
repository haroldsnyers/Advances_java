<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <p> form with redirection </p>
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

    <p> form with forward </p>
    <form action="login.jsp" method='POST' >
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

    <p> form with cookies and session </p>
    <form action="home" method='POST' >
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

    <c:if test="${not empty param}">
        <jsp:forward page="process.jsp">
            <jsp:param name="user" value= "${param.user}"/>
            <jsp:param name="pwd" value= "${param.pwd}"/>
        </jsp:forward>
    </c:if>

</body>
</html>
