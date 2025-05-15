<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>menu list</h2>
<c:if test="${ not empty message}">
  <script>alert('${message}');</script>
</c:if>
<button onclick="location.href='${contextPath}/menu/regist.page';">register menu page</button>
<form action="${contextPath}/menu/remove.do" method="post">
  <button type="submit">delete</button>
  <table border="1">
    <thead>
    <tr>
      <th></th>
      <th>번호</th>
      <th>메뉴명</th>
      <th>메뉴가격</th>
      <th>카테고리번호</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${empty list}">
        <tr>
          <td colspan="5">no menus</td>
        </tr>
      </c:when>
      <c:otherwise>
        <c:forEach var="menu" items="${list}">
          <tr>
            <td><input type="checkbox" name="code" value="${menu.menuCode}"></td>
            <td>${menu.menuCode}</td>
            <td><a href='${contextPath}/menu/detail.page?code=${menu.menuCode}'>${menu.menuName}</a></td>
            <td>${menu.menuPrice}</td>
            <td>${menu.categoryCode}</td>
          </tr>
        </c:forEach>
      </c:otherwise>
    </c:choose>

    </tbody>
  </table>
</form>
</body>
</html>
