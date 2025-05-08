<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${contextPath}/resources/js/sample.js"></script>
</head>
<body>
  <!--http"//localhost:8080/webmvc URL 요청시 해당 /WEB_INF/views/,ain./jsp가 보여지도록 포워딩-->
  <h1>메인 페이지 입니다.</h1>

  <h3>1.정적 자원(이미지) 확인</h3>
  <img src="${contextPath}/assets/image/flower1.jpg" width="200" onclick="test();">

  <hr>
  <h3>2. 응답페이지 포워딩 또는 redirect 처리</h3>
  <!--/book/list.do -> get 요청 -> 목록페이지(~/book/list.jsp) ======> 포워딩-->
  <a href="${contextPath}/book/list.do">도서 목록 페이지로 이동</a>

</body>
</html>
