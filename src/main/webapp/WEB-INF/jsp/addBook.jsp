<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Add Book</title>
    <link rel="stylesheet" href="/styles/styles.css" />
  </head>
  <body>
    <h1>Add a New Book</h1>

    <c:if test="${not empty errorMessage}">
      <p style="color: red">
        <c:out value="${errorMessage}" />
      </p>
    </c:if>

    <form action="/books/add" method="post">
      <label for="title">Book Title:</label>
      <input type="text" id="title" name="title" required /><br /><br />

      <label for="publishedDate">Publication Date:</label>
      <input type="date" id="publishedDate" name="publishedDate" /><br /><br />

      <label for="isbn">ISBN:</label>
      <input type="text" id="isbn" name="isbn" maxlength="13" /><br /><br />

      <label>Select Author(s):</label><br>

        <c:forEach var="author" items="${authors}">
            <input type="checkbox"
                name="authorIds"
                value="${author.authorId}"
                id="author-${author.authorId}">

            <label for="author-${author.authorId}">
                <c:out value="${author.name}"/>
            </label><br>
        </c:forEach><br>

      <button type="submit">Add Book</button>
    </form>
  </body>
</html>
