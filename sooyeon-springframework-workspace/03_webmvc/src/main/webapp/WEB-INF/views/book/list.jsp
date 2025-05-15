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

  <script>
    /**
     * 목록페이지에서 특정 row를 클릭하면 해당 book의 상세페이지로 이동
     * 1. /book/detail.do
     * 2. GET 요청
     * 3. /book/deatil/do?no=x 포워딩
     */
    const trList = document.querySelectorAll('#book_list > tbody > tr');

    trList.forEach((tr) => {
      tr.addEventListener('click', (evt) => {
        location.href = '${contextPath}/book/detail.do?no=x';
      });
    });
  </script>

</body>
</html>
