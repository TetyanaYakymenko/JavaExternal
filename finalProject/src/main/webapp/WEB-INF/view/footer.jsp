<!DOCTYPE html>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<fmt:setLocale value="${locale}"/>
    <fmt:setBundle basename="localization"/>
    <div class="card-footer text-muted  bg-light">
        <div class="row text-primary">
            <div class="col-sm">
                <p id = "skype"> Skype :conference </p>
             </div>
            <div class="col-sm">
                <p id = "email"> Email : conference@gmail.com</p>
            </div>
            <div class="col-sm">
                <p id = "phone"> <fmt:message key="footer_phone"/> : +380991234567 </p>
            </div>
        </div>
   </div>
</body>
</html>