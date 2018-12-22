<!DOCTYPE html>
<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div class="card-header bg-light">
        <ul class="nav nav-pills card-header-pills text-primary">
              <li class="nav-item" >
                <form name = "Logout"  method = "POST" action = "main" >
                    <input type = "hidden" name = "command"  value = "main" />
                    <button type="submit" class="btn btn-primary">Home</button>
                </form>
              </li>
              <li class="nav-item">
                 <form name = "Logout"  method = "POST" action = ""  >
                    <input type = "hidden" name = "command"  value = "logout" />
                    <button type="submit" class="btn btn-primary">Logout</button>
                  </form>
              </li>
              <c:if test="${sessionScope.role != null}">
                <li class="nav-item">
                    <form name = "Admin panel"  method = "POST" action = ""  >
                        <input type = "hidden" name = "command"  value = "admin" />
                         <button type="submit" class="btn btn-primary">Users</button>
                    </form>
                </li>
                </c:if>
            </ul>
          </div>
    </div>
</body>
</html>