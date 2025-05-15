<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>메인</h1>
<!-- forwarding 과 redirect 잘 알아보기 -->
  <a href="${contextPath}/menu/list.page"></a>

</body>
</html>
