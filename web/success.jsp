<%-- 
    Document   : success
    Created on : Jun 23, 2012, 3:41:56 PM
    Author     : TATARAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%= (String)session.getAttribute("Action") %> Operation Successfull <br></br>
        <html:link action="/home" >Home</html:link>
    </center>
    </body>
</html>
