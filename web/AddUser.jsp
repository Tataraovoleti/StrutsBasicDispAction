<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
    <center>  
        <h3><bean:message key="welcome.heading.add"/></h3><br>
        <html:form action="/controller" >
            <bean:message key="form.id" /><html:text property="id" /><br>
            <bean:message key="form.pass" /><html:password property="pass" />
            </br>
            <html:submit value="Add User" />
            <html:hidden property="function" value="insert" />
        </html:form>
    </center>
</body>
</html:html>