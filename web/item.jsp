<%-- 
    Document   : index.jsp
    Created on : May 31, 2023, 9:50:28 AM
    Author     : QUANG
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Page</title>
        <style>
        .item-list-table {
            border-collapse: collapse;
            width: 100%;
        }
        .item-list-table th,
        .item-list-table td {
            padding: 4px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .item-list-table th {
            background-color: #f2f2f2;
        }
        .item-list-table tr:hover {
            background-color: #f5f5f5;
        }

        p {
            margin: 0 auto;
        }
    </style>
    </head>
    <body>
        <c:set var="list" value="${requestScope.ItemList}"/>
        <c:if test="${not empty list}">
            <table class="item-list-table">
            <thead><tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Category Id</th>
                    <th>Action</th>
                </tr></thead>
            <tbody>
                <c:forEach var="item" items="${list}">
                <tr>
                <form action="MainServlet">
                    <input type="hidden" name="action" value ="3"> 
                    <input type="hidden" name="txtitemid" value ="${item.itemId}">
                    <td>${item.itemId}</td>
                    <td>${item.itemName}</td>
                    <td>${item.price}</td>
                    <td>${item.cateId}</td>
                    <td><input type="submit" value="Edit"></td>
                    </form>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        <c:if test="${list!=null && empty list}">Item list is empty!</c:if>
    </body>
</html>
