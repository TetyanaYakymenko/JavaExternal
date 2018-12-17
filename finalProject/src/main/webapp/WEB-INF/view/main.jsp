<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<sql:query var="rs" dataSource="jdbc/control_conferences">
select * from conferences
</sql:query>

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>
            Welcome
        </title>
    </head>
    <body>
    <div>
        <jsp:include page="header.jsp"/>
        <div class="card-body">
        <h3>Welcome</h3>


        <div>

        <table border="2">
        <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>DATE</td>
        <td>PLACE</td>
        </tr>
            <c:forEach var="row" items="${rs.rows}">
                        <tr>
                            <td class="center aligned">${row.id}</td>
                            <td class="center aligned">${row.name}</td>
                            <td class="center aligned">${row.date}</td>
                            <td class="center aligned">${row.place}</td>
                        </tr>
        </div>
        </div>
        <jsp:include page="footer.jsp"/>
       </div>dd
    </body>
</html>