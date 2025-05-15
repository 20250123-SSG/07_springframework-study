<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>x번 도서 수정페이지</h2>

<!-- /book/modify.do =POST요청=> 상세페이지(/book/detail.do url) redirect -->
<form action="${contextPath}/book/modify.do" method="post">
  제목 : <input type="text" value="자바의 정석" name="title"> <br>
  저자 : <input type="text" value="김수학" name="author"> <br>
  <button type="submit">수정</button>
</form>

</body>
</html>