<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>book list</title>
</head>
<body>
  <h2>도서 전체 목록 페이지</h2>
  하단에는 db로부터 조회된 도서 목록들이 보여져야됨
  <table border="1" id="book_list">
    <thead>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>저자</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th>1</th>
      <th>수학의 정석</th>
      <th>김수학</th>
    </tr>
    <tr>
      <th>2</th>
      <th>자바의 정석</th>
      <th>강자바</th>
    </tr>
    <tr>
      <th>3</th>
      <th>스프링의 정석</th>
      <th>이봄</th>
    </tr>
    </tbody>
  </table>

  <%-- /book/detail.do : GET 요청 --%>
  <script>
    const trList = document.querySelectorAll('#book_list>tbody>tr');
    trList.forEach(function (tr) {
      tr.addEventListener('click', function (evt) {
        location.href = '${contextPath}/book/detail.do?no=x';
      })
    })

  </script>

</body>
</html>
