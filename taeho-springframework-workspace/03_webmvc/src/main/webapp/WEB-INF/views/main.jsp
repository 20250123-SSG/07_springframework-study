<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1> 메인임</h1>
  <h3> 이미지 확인 </h3>
  <!-- http:localhost:8080/webmvc/assets/image/flower1.jpg -->
<%--  <img src="/webmvc/assets/image/flower1.jpg" width="200">--%>
  <img src="${pageContext.request.contextPath}/assets/image/flower1.jpg" width="200">
</body>
</html>
