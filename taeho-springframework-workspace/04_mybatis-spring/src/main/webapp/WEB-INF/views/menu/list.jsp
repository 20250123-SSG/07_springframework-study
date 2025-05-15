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

<h2> 판매 중 목록</h2>
  <button onclick="location.href='${contextPath}/menu/regist.page';">신규 메뉴 등록 페이지 이동</button>
<table border="1">
  <thead>
  <tr>
    <th></th>
    <th>번호</th>
    <th>메뉴명</th>
    <th>카테고리</th>
    <th>판매가능여부</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${empty list}">
      <tr>
        <td colspan="5" style="text-align: center;"> 판매가능한 메뉴가 없음</td>
      </tr>
    </c:when>
    <c:otherwise>
      <c:forEach var="menu" items="${list}">
        <tr>
          <td></td>
          <td>${menu.menuCode}</td>
          <td><a href="${contextPath}/menu/detail.page?id=${menu.menuCode}">${menu.menuName}</a></td>
          <td>${menu.menuPrice}</td>
          <td>${menu.categoryCode}</td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
</body>
</html>
