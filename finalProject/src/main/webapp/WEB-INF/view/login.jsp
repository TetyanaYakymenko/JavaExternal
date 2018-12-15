<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
    <jsp:include page="header.jsp"/>
        <form name = "LoginForm" class="px-4 py-3 mx-auto"  method = "POST" action = "controller">
            <input type = "hidden" name = "command" value = "login" />
            <div class="form-group mx-auto ">
                <label for="login" style="width: 100px;">Login:</label>
                <input type = "text" style="width: 300px;" placeholder="email@example.com" id="login" name = "login" value ="" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="login" style="width: 100px;">Password :</label>
                <input type = "password"  style="width: 300px;" name = "password"  placeholder="Password"value ="" />
                <br/>
            </div>

           <!-- ${errorLoginPassMessage}-->
            <br/>
           <!-- ${wrongAction}-->
            <br/>
           <!-- ${nullPage}-->
            <br/>
            <button type="submit" class="btn btn-primary">Login in</button>
        </form>
        <jsp:include page="footer.jsp"/>

    </body>
</html>