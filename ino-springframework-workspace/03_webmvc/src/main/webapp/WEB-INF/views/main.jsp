<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${pageContext.request.contextPath}/resources/js/sample.js"></script>
</head>
<body>
<!-- http://localhost:8080/webmvc/ url 요청시 /WEB-INF/views/main.jsp 보여지도록 포워딩 -->
<h1>welcome page</h1>
<h3>1. check static data</h3>
<%--<img src="assets/image/flower1.jpg" width="640" height="960"> 상대 경로 : 현재 보이는 url 마지막 / 뒤에 붙음--%>
<img src="${contextPath}/assets/image/flower1.jpg" width="200" onclick="test()"> <!-- 절대 경로 방식 -->

<h3>2. response page forwarding / redirect </h3>
<a href="${contextPath}/book/list.do">move to book list page</a>
<hr>

<h3> 3. request param</h3>
<a href="${contextPath}/member/detail.do?no=1">member detail</a><br><br>
<form action="${contextPath}/member/regist1.do" method="POST">
  name: <input type="text" name="name"> <br>
  age: <input type="text" name="age"> <br>
  addr: <input type="text" name="addr"> <br>
  <input type="submit" value="submit">
</form>
<br><br>
<form action="${contextPath}/member/regist2.do" method="POST">
  name: <input type="text" name="name"> <br>
  age: <input type="text" name="age"> <br>
  addr: <input type="text" name="addr"> <br>
  <input type="submit" value="submit">
</form>

<form action="${contextPath}/member/regist3.do" method="POST">
  name: <input type="text" name="name"> <br>
  age: <input type="text" name="age"> <br>
  addr: <input type="text" name="addr"> <br>
  <input type="submit" value="submit">
</form>
<hr>
<h3>4.forwarding / redirect 시 데이터 담는 방법 </h3>
<a href="${contextPath}/notice/list.page">move to notice list page</a>
</body>
</html>
