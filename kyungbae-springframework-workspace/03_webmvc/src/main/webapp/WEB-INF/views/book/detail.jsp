<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>book detail</title>
</head>
<body>
  <h2>[x]번 도서 상세페이지</h2>
  하단에는 현재 클릭된 도서의 상세 내용 조회

  <div>
    제목 : [조회된 제목] <br>
    저자 : [조회된 저자] <br>
  </div>

  <button onclick="location.href='${contextPath}/book/modifyForm.do'">수정하기</button>
</body>
</html>
