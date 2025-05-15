<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
  <script>
    alert("${message}");
  </script>
</c:if>
<c:choose>
  <c:when test="${ empty notice}">
    * No Data
  </c:when>
  <c:otherwise>
    <h2>${notice.title}</h2><br>
    ${notice.content}<br><br>
    <button onclick="location.href='${contextPath}/notice/modify.page?no=${notice.no}';">move to mod page</button>
  </c:otherwise>
</c:choose>
</body>
</html>
