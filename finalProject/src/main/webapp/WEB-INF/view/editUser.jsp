<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title> User
		</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
			  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
			  crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<fmt:setLocale value="${locale}"/>
		<fmt:setBundle basename="localization"/>
		<form name="EditForm" class="px-4 py-3 mx-auto" method="POST" action="">

			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_surname"/>
					:</label>
				<input type="text" style="width: 300px;" name="surname" value="${user.surname}"/>
				<br/>
			</div>
			<div class="form-group mx-auto">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_name"/>
					:</label>
				<input style="width: 300px;" name="name" value="${user.name}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_login"/>
					:</label>
				<input type="text" style="width: 300px;" id="login" name="login" value="${user.login}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_password"/>
					:</label>
				<input type="text" style="width: 300px;" name="password" value="${user.password}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_email"/>
					:</label>
				<input type="text" style="width: 300px;" name="email" value="${user.email}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_phone"/>
					:</label>
				<input type="text" style="width: 300px;" name="phone" value="${user.phone}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_rating"/>
					:</label>
				<input type="text" style="width: 300px;" name="rating" value="${user.rating}"/>
				<br/>
			</div>
			<div class="form-group mx-auto ">
				<label for="EditForm" style="width: 100px;">
					<fmt:message key="edit_salary"/>
					:</label>
				<input type="text" style="width: 300px;" name="salary" value="${user.salary}"/>
				<br/>
			</div>
			${error}
			<br/>
			<div>
				<input type="hidden" name="command" value="edituser"/>
				<input type="hidden" name="userId" value="${user.id}"/>
				<button type="submit" class="btn btn-primary">Edit</button>
			</div>
		</form>
		<form class="px-4 py-3 mx-auto" method="POST" action="">
			<div>
				<input type="hidden" name="command" value="admin"/>
				<input type="hidden" name="user" value="${user}"/>
				<button type="submit" class="btn btn-primary">Cancel</button>
			</div>
		</form>
		<jsp:include page="footer.jsp"/>

	</body>
</html>