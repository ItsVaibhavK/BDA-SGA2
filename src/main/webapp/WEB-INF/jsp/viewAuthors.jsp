
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Authors</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
    <h1>All Authors</h1>
    <table>
        <thead>
            <tr>
                <th>Author ID</th>
                <th>Name</th>
                <th>Birthdate</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td><c:out value="${author.authorId}"/></td>
                    <td><c:out value="${author.name}"/></td>
                    <td><c:out value="${author.birthdate}"/></td>
                    <td><a href="/authors/edit/${author.authorId}">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
