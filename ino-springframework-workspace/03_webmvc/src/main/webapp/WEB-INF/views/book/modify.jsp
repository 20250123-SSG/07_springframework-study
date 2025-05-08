<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>no. x book edit page</h2>
<form action="${contextPath}/book/modify.do" method="post">
  title: <input type="text" value="JavaBook" name="title"> <br>
  author: <input type="text" value="mathKim" name="author"> <br>
  <button type="submit">edit</button>
</form>
</body>
</html>
