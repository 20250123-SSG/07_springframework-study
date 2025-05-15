<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2>공지사항 수정</h2>

<form action="${contextPath}/notice/modify.do" method="POST">
  <input type="hidden" name="no" value="${notice.no}">
  제목 : <input type="text" name="title" value="${notice.title}"> <br>
  내용 : <textarea name="content">${notice.content}</textarea>
  <br>
  <button type="submit">수정</button>
</form>

</body>
</html>