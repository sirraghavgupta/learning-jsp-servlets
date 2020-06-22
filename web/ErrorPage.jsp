<%--
  Created by IntelliJ IDEA.
  User: raghav
  Date: 20/06/20
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body  bgcolor="red">
    <%= exception.getMessage() %>
</body>
</html>


<%--
    we cant access the exception object here unless we set isErrorPage to true.
--%>