<%--
  Created by IntelliJ IDEA.
  User: raghav
  Date: 20/06/20
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/ErrorPage.jsp" %>
<html>
<head>
    <title>Exception Handling Demo</title>
</head>
<body>
    <%
        // its not preferred to use try catch in jsp because its better to show a proper error page
        // with error styling for proper indication for user.
//        try {
            int a = 9/0;
//        }catch(ArithmeticException ae){
//            out.println("divide by 0 error");
//        }
    %>
</body>
</html>


    <%--
        whenever an exception occurs in a jsp page, the errorpage is loaded. its specified by the
        error page attribute of the @page directive.
    --%>