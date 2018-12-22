<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>
            Welcome
        </title>
    </head>
    <body>
    <div>
    <jsp:include  page="header.jsp"/>

        <form  class="card-body">
        <h3>Welcome, ${sessionScope.login}</h3>
        <div>
        <h5> Conferences </h5>
        <table border="2">
        <thead>
            <tr>
                <td>ID</th>
                <td>NAME</td>
                <td>DATE</td>
                <td>PLACE</td>
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