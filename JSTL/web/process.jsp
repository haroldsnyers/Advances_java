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
    <link rel='stylesheet' type='text/css' href='css/style.css'>
</head>
<body>
<c:set var="user" value="${param.user}"/>
<c:set var="pwd" value="${param.pwd}"/>
<c:choose>
    <c:when test="${user == 'test' and pwd == 'test'}">
        <h1> you are logged in as ${user} </h1>
    </c:when>
    <c:otherwise>
        <c:redirect url="login.jsp"/>
    </c:otherwise>
</c:choose>


<div class='button_form'>
    <form action="process.jsp" method="post">
        <input type="submit" name="user" value="${user}" hidden>
        <input type="submit" name="pwd" value="${pwd}" hidden>
        <input type="submit" value="continue" name="continue">
    </form>
    <form action="logout.jsp" method="post">
        <input type="submit" value="logout" name="logout">
    </form>
</div>

</body>
</html>
