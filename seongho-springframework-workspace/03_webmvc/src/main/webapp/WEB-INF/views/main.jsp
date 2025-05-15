<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${contextPath}/resources/js/sample.js"></script>
</head>
<body>
  <!--
  http://localhost:8080/webmvc/  url요청시 해당 /WEB-INF/views/main.jsp 가 보여지도록 포워뒹
  -->
  <h1>메인 페이지</h1>

  <h3>정적 자원 확인</h3>
  <img src="${contextPath}/assets/image/flower1.jpg" width="200" onclick="test();">
  <hr>

<h3>응답 페이지 포워딩 또는 redirect 처리</h3>
  <a href="${contextPath}/book/list.do">도서목록페이지</a>

  <hr>

<h3>3.요청 파라미터어워 </h3>
  <a href="${contextPath}/member/detail.do?no=1">회원상크세 조회</a>


  <br><br>

  <form action="${contextPath}/member/regist1.do" method="post">
    이름: <input type="text" name="name"><br>
    나이: <input type="number" name="age"><br>
    주소: <input type="text" name="add"><br>
    <input type="submit" value="등로크">
  </form>
</body>
</html>
