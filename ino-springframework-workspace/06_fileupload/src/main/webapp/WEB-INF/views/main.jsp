<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>attachment test</h1>
<form action="${contextPath}/board/regist1.do" method="post" enctype="multipart/form-data" >
  title: <input type="text" name="boardTitle"><br>
  content: <textarea name="boardContent"></textarea><br>
  file attach<input type="file" accept="image/*" name="mpf">
  <button type="submit">submit</button>
</form>

</body>
</html>
