<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
  <script>alert('${message}');</script>
</c:if>
<c:choose>
  <c:when test="${empty menu}">
    <h1>404</h1>
  </c:when>
  <c:otherwise>
    <table border="1">
      <thead>
      <tr>
        <th>code</th>
        <th>name</th>
        <th>price</th>
        <th>catecode</th>
        <th>os</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>${menu.menuCode}</td>
        <td>${menu.menuName}</td>
        <td>${menu.menuPrice}</td>
        <td>${menu.categoryCode}</td>
        <td>${menu.orderableStatus}</td>
      </tr>
      </tbody>
    </table>
    <button onclick="location.href='${contextPath}/menu/modify.page?code=${menu.menuCode}';">edit page</button>
    <button onclick="location.href='${contextPath}/menu/list.page';">list page</button>
  </c:otherwise>
</c:choose>
</body>
</html>
