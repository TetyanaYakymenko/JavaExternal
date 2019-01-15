<!DOCTYPE html>
<html lang<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>="en">
          <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="localization"/>
 <jsp:include page="header.jsp"/>
 <form>
 <h5> <fmt:message key="admin_users"/> </h5>
        <table border="2">
        <thead>
            <tr>
                <td><fmt:message key="admin_table_id"/></th>
                <td><fmt:message key="admin_table_name"/></td>
                <td><fmt:message key="admin_table_surname"/></td>
                <td><fmt:message key="admin_table_password"/></td>
                <td><fmt:message key="admin_table_email"/></th>
                <td><fmt:message key="admin_table_phone"/></td>
                <td><fmt:message key="admin_table_rating"/></td>
                <td><fmt:message key="admin_table_salary"/></td>
                <td></td>
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
                        <input type="hidden" name="userId" value="${u.id}">
                        <input type="hidden" name="command" value="edituser">
                        <button type="submit" class="btn btn-primary"><fmt:message key="admin_edit"/></button>
                    </form>
                    </td>
                    <td>
                    <form method="POST" action="main">
                        <input type="hidden" name="userId" value="${u.id}">
                        <input type="hidden" name="command" value="mail">
                        <button type="submit" class="btn btn-primary"><fmt:message key="admin_mail"/></button>
                    </form>
                    </td>
                </tr>
        </c:forEach>

        </table>
 </form>
 <jsp:include page="footer.jsp"/>
</body>
</html>