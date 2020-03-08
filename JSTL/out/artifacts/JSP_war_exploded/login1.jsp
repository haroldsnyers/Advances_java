<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: victorsmits
  Date: 07/03/2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<c:if test="${param.state == 'flase'}">
    <p>Username or password incorrect</p>
</c:if>


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

</body>
</html>
