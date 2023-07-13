<%-- 
    Document   : faq
    Created on : Jul 9, 2023, 9:10:02 PM
    Author     : trong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item FAQ Page</title>
                <style>
        .FAQ-list-table {
            border-collapse: collapse;
            width: 100%;
        }
        .FAQ-list-table th,
        .FAQ-list-table td {
            padding: 4px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .FAQ-list-table th {
            background-color: #f2f2f2;
        }
        .FAQ-list-table tr:hover {
            background-color: #f5f5f5;
        }

        p {
            margin: 0 auto;
        }
    </style>
    </head>
    <body>
        <c:set var="itemList" value="${requestScope.ItemList}"/>
        <h1>FAQs management</h1>
        <form action="MainServlet">
            <input hidden name="action" value="9">
            <label>Choose the item to get FAQs</label>
            <select name="txtid">
                <c:forEach var="item" items="${itemList}">
                    <option value="${item.itemId}">${item.itemName}</option>
                </c:forEach>
            </select>
            <input type="submit" value="View">
        </form>
        <br>
        <c:set var="list" value="${requestScope.FAQsList}"/>
        <c:if test="${not empty list}">
            <table class="FAQ-list-table">
            <thead><tr>
                    <th>Id</th>
                    <th>Customer Name</th>
                    <th>Customer content</th>
                    <th>Item Id</th>
                </tr></thead>
            <tbody>
                <c:forEach var="FAQ" items="${list}">
                <tr>
                    <td>${FAQ.id}</td>
                    <td>${FAQ.custName}</td>
                    <td>${FAQ.custContent}</td>
                    <td>${FAQ.itemId}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        <c:if test="${list!=null && empty list}">FAQ list is empty!</c:if>
    </body>
</html>
