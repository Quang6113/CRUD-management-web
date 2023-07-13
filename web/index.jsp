<%-- 
    Document   : index.jsp
    Created on : May 31, 2023, 9:50:28 AM
    Author     : QUANG
--%>
<%@page import="basicobject.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <a href="MainServlet?action=1">Item management</a>
        <br>
        <a href="MainServlet?action=8">FAQs management</a>
    </body>
</html>
