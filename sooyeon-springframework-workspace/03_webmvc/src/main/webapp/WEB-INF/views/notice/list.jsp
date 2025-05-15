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
    <!--조회된 공지사항 길이만큼 테이블 row 추가됨-->
    <tbody>
    <c:forEach var="notice" items="${noticeList}">
      <tr>
        <td>${notice.no}</td>
        <td><a href="${contextPath}/notice/detail.page?no=${notice.no}">${notice.title}</a></td>
        <td>${notice.content}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

</body>
</html>
