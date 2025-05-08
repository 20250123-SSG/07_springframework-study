<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>도서 전체 목록 페이지</h2>
  하단에는 db에서 조회된 목록들

  <table border="1" id="book_list">
    <thead>
      <tr>
        <th>ㅂㅎ</th>
        <th>ㅈㅁ</th>
        <th>ㅈㅈ</th>
      </tr>
    </thead>
    <tbody>
    <tr>
      <td>1</td>
      <td>good</td>
      <td>asd</td>
    </tr>
    <tr>
      <td>2</td>
      <td>good2</td>
      <td>aqw</td>
    </tr>
    <tr>
      <td>3</td>
      <td>good3</td>
      <td>vvv</td>
    </tr>
    </tbody>
  </table>

  <script>
    const trList = document.querySelectorAll('#book_list>tbody>tr')
    trList.forEach((tr) => {
      // tr.addEventListener('이벤트명', 이벤트핸들러)
      tr.addEventListener('click', (evt) => {
        location.href='${contextPath}/book/detail.do?no=x'
      });
    });
  </script>
</body>
</html>
