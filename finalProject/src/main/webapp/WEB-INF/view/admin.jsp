<!DOCTYPE html>
<html lang<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
 <jsp:include page="header.jsp"/>
 <form>
 <h5> Users </h5>
        <table border="2">
        <thead>
            <tr>
                <td>ID</th>
                <td>NAME</td>
                <td>SURNAME</td>
                <td>PASSWORD</td>
                <td>EMAIL</th>
                <td>PHONE</td>
                <td>RATING</td>
                <td>SALARY</td>
                <td></td>

            </tr>
        </thead>
        <c:forEach var="u" items="${users}">
                <tr>
                   <td> ${u.getId()} </td>
                    <td> ${u.getName()} </td>
                    <td> ${u.surname}</td>
                    <td> ${u.password} </td>
                    <td> ${u.email}</td>
                    <td> ${u.phone} </td>
                    <td> ${u.rating}</td>
                    <td> ${u.salary}</td>
                    <td>
                    <form method="POST" action="main">
                        <input type="hidden" name="user" value="${u}">
                        <input type="hidden" name="command" value="edit">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </form>
                    </td>
                </tr>
        </c:forEach>

        </table>
 </form>
 <jsp:include page="footer.jsp"/>
</body>
</html>