<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>notice list</title>
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
