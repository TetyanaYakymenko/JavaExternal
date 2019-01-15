<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
    <title> Login
    </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
    <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="localization"/>
        <form name = "LoginForm" class="px-4 py-3 mx-auto"  method = "POST" action = "main"  >

            <div class="form-group mx-auto ">
                <label for="login" style="width: 100px;">Login:</label>
                <input type = "text" style="width: 300px;"  id="login" required="required" name = "login" value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="login" style="width: 100px;">Password :</label>
                <input type = "password"  style="width: 300px;"  name = "password" required="required"  value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto ">
                <label for="login" style="width: 100px;">Name:</label>
                <input type = "text" style="width: 300px;" id="name"  name = "name" value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="login" style="width: 100px;">Surname :</label>
                <input type = "text"  style="width: 300px;" name = "surname" value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto ">
                <label for="login" style="width: 100px;">Email:</label>
                <input type = "text" style="width: 300px;" id="email"  name = "email" value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="login" style="width: 100px;">Phone :</label>
                <input type = "text"  style="width: 300px;" name = "phone" value ="" />
                <br/>
            </div>

           ${errorLoginPassMessage}
            <br/>
           ${wrongAction}
            <br/>
           ${nullPage}
            <br/>
            <div>
                <input type = "hidden" name = "command"  value = "register" />
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>
        <jsp:include page="footer.jsp"/>

    </body>
</html>