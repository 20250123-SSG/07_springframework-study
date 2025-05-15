<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>modify book</title>
</head>
<body>
  <h2>[x]번 도서 수정페이지</h2>

  <%-- /book/modify.do =post방식=> 상세페이지 redirect (/book/detail.do) --%>
  <form action="${contextPath}/book/modify.do" method="post">
    제목 : <input type="text" value="선택된 제목" name="title"> <br>
    저자 : <input type="text" value="해당작가" name="author"> <br>
    <button type="submit">수정</button>
  </form>

</body>
</html>
