
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books and Authors</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
    <h1>Books and Their Authors</h1>
    <table>
        <thead>
            <tr>
                <th>Book Title</th>
                <th>Author Name</th>
                <th>Publication Date</th>
                <th>ISBN</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="detail" items="${bookAuthorDetails}">
                <tr>
                    <td><c:out value="${detail.title}"/></td>
                    <td><c:out value="${detail.authorName}"/></td>
                    <td><c:out value="${detail.publishedDate}"/></td>
                    <td><c:out value="${detail.isbn}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
