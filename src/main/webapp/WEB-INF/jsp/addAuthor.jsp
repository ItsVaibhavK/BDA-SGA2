<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Add Author</title>
    <link rel="stylesheet" href="/styles/styles.css" />
  </head>
  <body>
    <h1>Add a New Author</h1>
    <c:if test="${not empty errorMessage}">
      <p style="color: red">
        <c:out value="${errorMessage}" />
      </p>
    </c:if>

    <form action="/authors/add" method="post">
      <label for="name">Author Name:</label>
      <input type="text" id="name" name="name" required /> <br /><br />

      <label for="birthdate">Birthdate:</label>
      <input type="date" id="birthdate" name="birthdate" /> <br /><br />

      <button type="submit">Add Author</button>
    </form>
  </body>
</html>
