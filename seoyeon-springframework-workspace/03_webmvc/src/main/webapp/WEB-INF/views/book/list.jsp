<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
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
      <td>1</td>
      <td>수학의 정석</td>
      <td>김수학</td>
    </tr>
    <tr>
      <td>2</td>
      <td>장바의 정석</td>
      <td>강자바</td>
    </tr>
    <tr>
      <td>3</td>
      <td>스프링의 정석</td>
      <td>이봄</td>
    </tr>
    </tbody>
  </table>

  <!-- /book/detail.do = GET요청=> 상세페이지(/WEB-INF/views/book/detail.jsp) 포워딩 -->
  <script>
    const trList = document.querySelectorAll('#book_list>tbody>tr'); // [tr, tr, tr]
    trList.forEach((tr) => {
      tr.addEventListener('click', (evt) => {
          const bookNo = tr.querySelector('td').textContent.trim(); // 첫 번째 <td>의 값
          location.href = '${contextPath}/book/detail.do?no=x'
      });
    });
  </script>

</body>
</html>