
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
    <h1>Edit Book</h1>
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">
            <c:out value="${errorMessage}"/>
        </p>
    </c:if>

    <form action="/books/edit" method="post">
        <input type="hidden" name="bookId" value="${book.bookId}">
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title" value="${book.title}" required><br><br>

        <label for="publishedDate">Publication Date:</label>
        <input type="date" id="publishedDate" name="publishedDate" value="${book.publishedDate}"><br><br>

        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${book.isbn}" maxlength="13"><br><br>

        <label>Select Author(s):</label><br>
        <c:forEach var="author" items="${authors}">
            <c:set var="selected" value="false"/>
            <c:forEach var="existingAuthor" items="${book.authors}">
                <c:if test="${existingAuthor.authorId eq author.authorId}">
                    <c:set var="selected" value="true"/>
                </c:if>
            </c:forEach>
            <input type="checkbox"
                   name="authorIds"
                   value="${author.authorId}"
                   id="author-${author.authorId}"
                   <c:if test="${selected}">checked</c:if>>

            <label for="author-${author.authorId}">
                <c:out value="${author.name}"/>
            </label><br>
        </c:forEach><br>

        <button type="submit">Update Book</button>
    </form>
</body>
</html>
