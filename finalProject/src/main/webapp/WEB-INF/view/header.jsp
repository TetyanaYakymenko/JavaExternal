<!DOCTYPE html>
<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<fmt:setLocale value="${locale}"/>
		<fmt:setBundle basename="localization"/>
		<div class="card-header bg-light">
			<ul class="nav nav-pills card-header-pills text-primary">
				<li class="nav-item">
					<form name="Reports" method="POST" action="main">
						<input type="hidden" name="command" value="reports"/>
						<button type="submit" class="btn btn-primary">
							<fmt:message key="head_home"/>
						</button>
					</form>
				</li>
				
				<c:if test="${sessionScope.role == 'admin'}">
					<li class="nav-item">
						<form name="Admin panel" method="POST" action="">
							<input type="hidden" name="command" value="admin"/>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="head_users"/>
							</button>
						</form>
					</li>
				</c:if>
				<c:if test="${sessionScope.role == 'speaker'}">
					<li class="nav-item">
						<form name="Admin panel" method="POST" action="">
							<input type="hidden" name="command" value="addreport"/>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="head_add_report"/>
							</button>
						</form>
					</li>
				</c:if>
				<li class="nav-item">
					<form name="Logout" method="POST" action="">
						<input type="hidden" name="command" value="logout"/>
						<button type="submit" class="btn btn-primary">
							<fmt:message key="head_logout"/>
						</button>
					</form>
				</li>
			</ul>
		</div>
	
	
	</body>
</html>