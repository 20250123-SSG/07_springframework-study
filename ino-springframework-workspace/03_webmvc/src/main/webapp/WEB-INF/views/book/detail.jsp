<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>book detail view</h2>
  <div>
    title: xxxx <br>
    author: xxxx
  </div>
<button onclick="location.href='${contextPath}/book/modifyForm.do';">move to edit page</button>
</body>
</html>
