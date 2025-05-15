<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h2>공지사항 목록페이지</h2>

<table border="1">
  <thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>내용</th>
  </tr>
  </thead>
  <tbody>
  <!--조회된 공지사항의 수 만큼 tr 요소 만들어져야됨 => list 어트리뷰트 꺼내서 화면구현-->
  <c:forEach var="n" items="${list}">
    <tr>
      <td>${n.no}</td>
      <td><a href="${contextPath}/notice/detail.page?no=${n.no}">${n.title}</a></td>
      <td>${n.content}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>


</body>
</html>