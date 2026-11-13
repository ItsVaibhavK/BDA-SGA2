<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Edit Author</title>
    <link rel="stylesheet" href="/styles/styles.css" />
  </head>
  <body>
    <h1>Edit Author</h1>
    <c:if test="${not empty errorMessage}">
      <p style="color: red">
        <c:out value="${errorMessage}" />
      </p>
    </c:if>

    <form action="/authors/edit" method="post">
      <input type="hidden" name="authorId" value="${author.authorId}" />
      <label for="name">Author Name:</label>
      <input
        type="text"
        id="name"
        name="name"
        value="${author.name}"
        required
      /><br /><br />

      <label for="birthdate">Birthdate:</label>
      <input
        type="date"
        id="birthdate"
        name="birthdate"
        value="${author.birthdate}"
      />
      <br /><br />

      <button type="submit">Update Author</button>
    </form>
  </body>
</html>
