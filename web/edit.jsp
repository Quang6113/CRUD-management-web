<%-- 
    Document   : edit
    Created on : Jul 10, 2023, 1:02:07 PM
    Author     : QUANG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Item Page</title>
    </head>
    <body>
        <c:set var="list" value="${applicationScope.CateList}"/>
        <c:set var="item" value="${requestScope.EditItem}"/>
        <c:set var="msg" value="${requestScope.Error}"/>
        <form action="MainServlet" method="post">
            <input type="hidden" name="action" value ="6">
            <input type="hidden" name="txtolditemid" value ="${item.itemId}">
            <table>
                <tr><td>ID: </td> 
                    <td><p><input text name="txtitemid" required value="${item.itemId}"></p></td></tr>
                <tr><td>Name: </td>
                    <td><p><input type="text" name="txtitemname" required value="${item.itemName}"></p></td></tr>
                <tr><td>Price: </td> 
                    <td><p><input type="number" name="txtitemprice" min="0" required value="${item.price}"></p></td></tr>
                <tr><td>Category: </td> 
                    <td><p><select name="txtitemcate" style="min-width: 70px">
                                <c:forEach var="cate" items="${list}">
                                    <option value="${cate.cateId}" <c:if test="${cate.cateId == item.itemId}">selected</c:if>>${cate.cateName}</option>
                                </c:forEach>
                            </select>
                        </p></td></tr>
                <tr><td><p><input type="submit" name="btn" value="Save"></p></td></tr>      
            </table>
        </form>    
        <h2 style='color: red;'>${msg}</h2>
    </body>
</body>
</html>
