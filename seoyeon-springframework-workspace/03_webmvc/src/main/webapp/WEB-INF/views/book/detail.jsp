<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>x번 도서 상세페이지</h2>
  하단에는 현재 클릭된 도서에 대한 정보를 db로부터 조회해서 출력해야됨

  <div>
    제목 : xxxxx <br>
    저자 : xxxx
  </div>

  <!-- /book/modifyForm.do =GET요청=> 수정페이지(/WEB-INF/views/book/modify.jsp) 포워딩 -->
  <button onclick="location.href='${contextPath}/book/modifyForm.do';">수정하기 페이지로 이동</button>

</body>
</html>
