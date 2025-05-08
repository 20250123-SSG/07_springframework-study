<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>수정페이지</h2>

  <form action="${contextPath}/book/modify.do" method="post">
    제목 : <input type="text" value="자바의정석" name="title"><br>
    저자 : <input type="text" value="수학귀신" name="author"><br>
    <button type="submit">수정</button>
  </form>
</body>
</html>
