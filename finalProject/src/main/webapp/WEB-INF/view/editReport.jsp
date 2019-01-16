<%@ page language="java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
    <title> User
    </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
     <jsp:include  page="header.jsp"/>

    <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="localization"/>
        <form name = "EditForm" class="px-4 py-3 mx-auto"  method = "POST" action = "edit"  >

            <div class="form-group mx-auto ">
                <label for="EditForm" style="width: 100px;"><fmt:message key="edit_name"/>:</label>
                <input type = "text" style="width: 300px;"  name = "name" value ="${reportDisplay.getReportName()}" />
                <br/>
            </div>
            ${reportDisplay.getReportName()}
            <div class="form-group mx-auto">
                <label for="EditForm" style="width: 100px;"><fmt:message key="edit_speaker"/> :</label>
                <input type = "text"  style="width: 300px;" name = "speaker"   value ="${reportDisplay.getSpeaker()}" />
                <br/>
            </div>
            <div class="form-group mx-auto ">
                <label for="EditForm" style="width: 100px;"><fmt:message key="edit_conference_name"/>:</label>
                <input type = "text" style="width: 300px;"  name = "conference" value ="${reportDisplay.getConferenceName()}" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="EditForm" style="width: 100px;"><fmt:message key="edit_date"/> :</label>

                <input type = "date" style="width: 300px;" name = "date" value ="<fmt:formatDate pattern='yyyy-MM-dd' value ='${reportDisplay.getDate().getTime()}'/>" />
                <br/>
            </div>
            <div class="form-group mx-auto">
                <label for="EditForm" style="width: 100px;"><fmt:message key="edit_place"/> :</label>
                <input type = "text"  style="width: 300px;" name = "place"   value ="${reportDisplay.getPlace()}" />
                <br/>
            </div>


            <div>
             <input type = "hidden" name = "command"  value = "editreport" />
             <input type = "hidden" name = "reportId"  value = "${reportDisplay.getId()}" />
            <button type="submit" class="btn btn-primary"><fmt:message key="edit_edit"/></button>
            </div>
            </form>
             ${errorMessage}
             <br/>
            <form  name = "EditForm" class="px-4 py-3 mx-auto"  method = "POST" action = ""  >
            <div>
            <input type = "hidden" name = "command"  value = "reports" />
             <button type="submit" class="btn btn-primary"><fmt:message key="edit_cancel"/></button>
             </div>
        </form>
        <jsp:include page="footer.jsp"/>

    </body>
</html>