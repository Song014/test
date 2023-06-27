<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-06-27
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>sql</title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/oracle">
    SELECT * FROM MVCREGISTER
</sql:query>

<table border="1" align="center">
    <tr>
        <c:forEach items="${rs.columnNames}" var="cn">
            <th><c:out value="${cn}"/></th>
        </c:forEach>
    </tr>
    <c:forEach var="row" items="${rs.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}" varStatus="i">
                <td>
                    <c:if test="${ column ne null}">
                        <c:out value="${column}"/>
                    </c:if>
                    <c:if test="${ column eq null}">
                        &nbsp;
                    </c:if>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>


</body>
</html>
