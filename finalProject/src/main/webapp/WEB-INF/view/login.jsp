<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title> Login
		</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
			  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
			  crossorigin="anonymous">
	</head>
	<body>

		<fmt:setLocale value="${locale}"/>
		<fmt:setBundle basename="localization"/>
		<div class="card-header bg-light text-right">
			<ul class="nav nav-pills card-header-pills text-primary">

				<li class="nav-item">
					<form name="Logout" method="POST" action="language">
						<input type="hidden" name="command" value="language"/>
						<input type="hidden" name="locale" value="ru"/>
						<button type="submit" class="btn btn-primary">
							<fmt:message key="login_RU"/>
						</button>
					</form>
				</li>
				<li class="nav-item">
					<form name="Logout" method="POST" action="language">
						<input type="hidden" name="command" value="language"/>
						<input type="hidden" name="locale" value="eng"/>
						<button type="submit" class="btn btn-primary">
							<fmt:message key="login_ENG"/>
						</button>
					</form>
				</li>
			</ul>
		</div>
		<form name="LoginForm" class="px-4 py-3 mx-auto" method="POST" action="main">

			<div class="form-group mx-auto ">
				<label for="login" style="width: 100px;">
					<fmt:message key="login_login_label"/>
					:</label>
				<input type="text" style="width: 300px;" placeholder="login" id="login" name="login" value=""/>
				<br/>
			</div>
			<div class="form-group mx-auto">
				<label for="login" style="width: 100px;">
					<fmt:message key="login_pass_label"/>
					:</label>
				<input type="password" style="width: 300px;" name="password" placeholder="Password" value=""/>
				<br/>
			</div>

			${errorLoginPassMessage}
			<br/>
			${wrongAction}
			<br/>
			${nullPage}
			<br/>
			<div>
				<input type="hidden" name="command" value="login"/>
				<button type="submit" class="btn btn-primary">
					<fmt:message key="login_login"/>
				</button>
			</div>
		</form>
		<form class="px-4 py-3 mx-auto" method="POST" action="main">
			<div>
				<input type="hidden" name="command" value="register"/>
				<button type="submit" class="btn btn-primary">
					<fmt:message key="login_register"/>
				</button>
			</div>
		</form>
		<jsp:include page="footer.jsp"/>

	</body>
</html>