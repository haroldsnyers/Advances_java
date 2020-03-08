<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
</head>
<body>
<c:set var="attributes" value="${pageContext.session.attributeNames}"/>
<c:set var="cookies" value="${pageContext.request.cookies}"/>

<c:forEach var="c" items="${cookies}">
    <c:if test="${c.name =='user'}">
        <c:set var="user" value="${c.value}"/>
    </c:if>
</c:forEach>

    <p> session ID: ${pageContext.session.id} </p>
    <h1> you are logged in as ${user} </h1>

    <form action="home" method="post">
        Attribute : <input type='text' name='attribute'/>
        Value : <input type='text' name='value'/>
        <input type='submit' value='Add' name='add'/>
        <input type='submit' value='Remove' name='remove'/>
        <input type="submit" value="logout" name="logout">
    </form>

    <ul>
      <c:forEach var="att" items="${attributes}">
        <li> ${att} : ${pageContext.session.getAttribute(att)}</li>
      </c:forEach>

    </ul>
</body>
</html>
