<%--
  Created by IntelliJ IDEA.
  User: raghav
  Date: 21/06/20
  Time: 2:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>JSTL Demo</title>
</head>
<body>

    <%--
    this is the syntax of the expression language which helps us to use the parameters and attributes
    directly and we need not extract them from the request object by request.getAttribute().
    --%>
    ${student}

    <%--
    when we use use the scriptlet, it makes the code very complex and doesn't give the feel of html, so
    creates problem for the designer to understand.
    so, jstl - jsp standard tag library comes to the rescue.
    it provides the tags which work like java but look like html.
    there are multiple type of jstl tags -
    core tags, formatting tags, sql tags, xml tags and jstl functions.
    its not recommended to use the jstl sql tags as we must not access the db from the jsp.
    --%>
    <c:out value="raghav" /> <br>

    <c:forEach items="${students}" var="s" >
        ${s}
        <br>
    </c:forEach>

    <%--
    here, we see that how to use the jstl sql tags. and how to connect to the database using this.
    we need to provide all these attributes.
    rs means result set here. we can use any name. then we iterate over the rs.rows and then get the data.
    --%>
    <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/student" user="root"  />
        <sql:query var="rs" dataSource="${db}">select * from studmarks</sql:query>
        <c:forEach items="${rs.rows}" var="marks">
            <c:out value="${marks.name}"></c:out> :
            <c:out value="${marks.maths}"></c:out> :
            <c:out value="${marks.english}"></c:out> :
            <c:out value="${marks.hindi}"></c:out> <br>
        </c:forEach>


    <%-- lets see the JSTL FUNCTIONS. --%>
    <c:set var="str" value="Raghav Gupta is an IT aspirant. He is highly ambitious."></c:set>
    ${str}<br>

    <c:out value="================================="></c:out><br>

    ${fn:startsWith(str, "raghav")}<br>
    ${fn:startsWith(str, "Raghav")}<br>

    ${fn:contains(str, 'Garg')}<br>
    ${fn:contains(str, 'Gupta')}<br>

    ${fn:toUpperCase(str)}<br>

    ${fn:indexOf(str, "aspirant")}<br>

    ${fn:endsWith(str, "aspirant.")}<br>
    ${fn:endsWith(str, "aspiran")}<br>

    ${fn:length(str)}<br>

    <c:if test="${fn:contains(str, 'Raghav')}">
        Raghav is there in the string.
    </c:if>
    <br>
    <c:forEach items="${fn:split(str, ' ')}" var="word">
        ${word} :
    </c:forEach>



</body>
</html>
