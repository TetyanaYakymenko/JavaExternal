<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
			  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
			  crossorigin="anonymous">
		<title>
			Welcome
		</title>
	</head>
	<body>
		<fmt:setLocale value="${locale}"/>
		<fmt:setBundle basename="localization"/>
		<div>
			<jsp:include page="header.jsp"/>

			<form class="card-body">
				<div>
					<h5>
						<fmt:message key="reports_head"/>
					</h5>
					<table border="2">
						<thead>
							<tr>
								<td>
									<fmt:message key="reports_name"/>
								</th>
								<td>
									<fmt:message key="reports_speaker"/>
								</td>
								<td>
									<fmt:message key="reports_conference_name"/>
								</td>
								<td>
									<fmt:message key="reports_date"/>
								</td>
								<td>
									<fmt:message key="reports_place"/>
								</td>
								<c:if test="${sessionScope.role == 'moderator'}">
									<td></td>
								</c:if>
							</tr>
						</thead>
						<c:forEach var="r" items="${reports}">
							<tr>
								<td> ${r.getReportName()}</td>
								<td> ${r.getSpeaker()}</td>
								<td> ${r.getConferenceName()}</td>
								<td>
									<fmt:formatDate value="${r.getDate().getTime()}" type="date"/>
								</td>
								<td> ${r.getPlace()}</td>
								<c:if test="${sessionScope.role == 'moderator'}">
									<td>
										<form method="POST" action="main">
											<input type="hidden" name="reportId" value="${r.id}">
											<input type="hidden" name="command" value="editreport">
											<button type="submit" class="btn btn-primary">
												<fmt:message key="reports_edit"/>
											</button>
										</form>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
					<form class="px-1 py-3 mx-auto" method="POST" action="">
						<div>
							<input type="hidden" name="command" value="reports"/>
							<input type="hidden" name="past" value="true"/>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="reports_past"/>
							</button>
						</div>
					</form>
					<form class="px-1 py-3 mx-auto" method="POST" action="main">
						<div>
							<input type="hidden" name="command" value="reports"/>
							<input type="hidden" name="upcoming" value="true"/>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="reports_upcoming"/>
							</button>
						</div>
					</form>
					<form class="px-1 py-3 mx-auto" method="POST" action="main">
						<div>
							<input type="hidden" name="command" value="reports"/>
							<button type="submit" class="btn btn-primary">
								<fmt:message key="reports_all_reports"/>
							</button>
						</div>
					</form>
				</div>
			</form>
			<jsp:include page="footer.jsp"/>
		</div>
	</body>
</html>