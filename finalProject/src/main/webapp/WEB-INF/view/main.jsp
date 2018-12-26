<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>
            Welcome
        </title>
    </head>
    <body>
    <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="localization"/>
    <div>
    <jsp:include  page="header.jsp"/>

        <form  class="card-body">
        <h3><fmt:message key="main_welcome"/>, ${sessionScope.login}</h3>
        <div>
        <h5> <fmt:message key="main_conferences"/> </h5>
        <table border="2">
        <thead>
            <tr>
                <td><fmt:message key="main_table_id"/></th>
                <td><fmt:message key="main_table_name"/></td>
                <td><fmt:message key="main_table_date"/></td>
                <td><fmt:message key="main_table_place"/></td>
            </tr>
        </thead>
        <c:forEach var="c" items="${conferences}">
                <tr>
                    <td> ${c.getId()} </td>
                    <td> ${c.getName()} </td>
                    <td>  <fmt:formatDate value="${c.getDate().getTime()}" type="date"/></td>
                    <td> ${c.getPlace()} </td>
                </tr>
        </c:forEach>
        </table>
        </div>
        </form>
        <jsp:include page="footer.jsp"/>
       </div>
    </body>
</html>