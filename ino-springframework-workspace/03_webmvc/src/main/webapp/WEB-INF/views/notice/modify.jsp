<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
no: ${notice.no}<br>
<form action="${contextPath}/notice/modify.do" method="post">
  <input type="hidden" name="no" value="${notice.no}">
  title: <input type="text" name="title" value="${notice.title}"><br>
  content: <textarea name="content">${notice.content}</textarea><br>
  <input type="submit"/>
</form>
</body>
</html>
