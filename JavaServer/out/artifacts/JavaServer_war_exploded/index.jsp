<%--
  Created by IntelliJ IDEA.
  User: Harold
  Date: 02/03/2020
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Hello World!<br/>
  <%
    for(int i = 0; i < 10; i++) {
      out.println(i);
    }
  %>
  <jsp:scriptlet>
    out.println("Your IP address is " + request.getRemoteAddr());
  </jsp:scriptlet>
  <p>Today's date: <jsp:expression> (new java.util.Date()).toLocaleString()</jsp:expression></p>
  </body>
</html>
