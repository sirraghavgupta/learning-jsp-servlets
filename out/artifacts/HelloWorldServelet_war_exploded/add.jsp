<%--
  Created by IntelliJ IDEA.
  User: raghav
  Date: 20/06/20
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import='java.util.Scanner' %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
       int a = 100;
    %>
    <%
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 + num2;
    %>

    <%= a %>

    <h1><%
        out.println("Output : " + result);
    %></h1>

<%--
there are some implicit objects which are made available in a jsp file by default.
for some basic purposes, we can directly use jsps rather than the servlets.
--%>
</body>
</html>
    <%--
    HOW IT WORKS?
    the web servet like tomcat is a servlet container and it can only run servlets. so, jsp is also compiled
    to servlet in the end. we use that only for ease of writing. its very easy.
    now, the conversion works like this -
    the basic template of the servlet remains the same -- a class which extends HttpServlet and has the
    service method with takes 2 objects req and resp.
    now, the servlet created is named like addjsp.
    whatever we write between the
    <% %> goes directly inside the service method. [scriptlet]
    <%! %> goes directly inside the servlet class and above the service method. [declarative]
    <%= %> gets converted into out.print(). [expression]
    <%@ %> gets converted into import statements. [directive]

    we get some impicit objects inside a servlet like -
    response, request, session, application, config, page, pageContext, Exception
    --%>

    <%--
    DIRECTIVES IN JSP -
    there are 3 directives in jsp - page, include and taglib
    @ page - its used when we want to specify something for the whole page. it has multiple attributes -
        import - its the only attribute which can be used multiple times.
        extends - to extends some class in the servelet if required
        language - scripting language used, java here
        session - if we want to use the session in the jsp.
        [note - its not a good practice to use sql statements in jsp]
        autoFlush - if we have a buffer anf we want to clear that.
        contentType - like html/css etc.
        errorPage - indicate the url of the error page if any exception occurs.
        isErrorPage - if its an error page.
        isThreadSafe - to make it thread safe.
        etc etc.

    @ include - to include some additional file required in the code.
              - like includig the header and footer jsp in all the files.
              - <%@ include file="header.jsp" %>

    @ taglib - to include an additional tag library.
            <%@taglib uri="uri" prefix="fx" %>
            then we need to use the prefix to indicate that its an external tag.
            like - <fx:raghav>
    --%>

    <%--
    PAGE CONTEXT --------------- implicit object
    pageContext is an implicit object which can be used to declare something which is scoped within the
    current page only. its like the synonym of the this keyword. it refers to the current jsp page.

    pageContext.setAttribute("name", "navin");

    we can set the scope to a different one also. the available scopes are as follows -
    page scope - within the page
    session scope - among all the pages
    application scope - like the servlet context
    request scope - within the current page and the requested page.

    pageContext.setAttribute("name", "navin", PageContext.SESSION_SCOPE);

    The main difference between page scope and request scope(often confusing ) is that page scope
    attributes are no longer available if the request is forwarded to another JSP page where as request
    scope attributes are available.

    +-------------+------------------------------------------------------+
    | Scope       | Description                                          |
    +-------------+------------------------------------------------------+
    | page        | Objects can be accessed only within the JSP page     |
    |             | in which they are referenced.                        |
    +-------------+------------------------------------------------------+
    | request     | Objects can be accessed within all the pages that    |
    |             | serve the current request. These include pages       |
    |             | that are forwarded to, and included in, the original |
    |             | JSP page to which the request was routed.            |
    +-------------+------------------------------------------------------+
    | session     | Objects can only be accessed within the JSP pages    |
    |             | accessed within the session for which the objects    |
    |             | are defined.                                         |
    +-------------+------------------------------------------------------+
    | application | Application scope objects can be accessed by all     |
    |             | JSP pages in a given context.                        |
    +-------------+------------------------------------------------------+

    --%>


