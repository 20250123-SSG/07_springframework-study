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
      alert("${message}")
    </script>
  </c:if>
  <h2>공지사항 상세 정보</h2>

  <c:choose>
    <c:when test="${empty notice}">
      * 조회된 공지사항 없음
    </c:when>
    <c:otherwise>
      * 조회된 공지사항 정보<br>

      번호 : ${notice.no}<br>
      제목 : ${notice.title}<br>
      내용 : ${notice.content}

      <br><br>
      <button onclick="location.href='${contextPath}/notice/modify.page?no=${notice.no}';">수정하기 페이지로 이동</button>
    </c:otherwise>
  </c:choose>

</body>
</html>
