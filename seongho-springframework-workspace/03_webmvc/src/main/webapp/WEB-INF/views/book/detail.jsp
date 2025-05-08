<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>x번 도서 상세 페이지</h2>
현재 클릭된 도서에 대한 정보를 db로부터 출력

<div>
  제목:asdf <br>
  저자:xx
</div>
<button onclick="location.href='${contextPath}/book/modifyForm.do';">수정하기</button>
</body>
</html>
