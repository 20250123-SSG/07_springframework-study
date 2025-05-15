<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>book list page</h2>
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
      <td>mathBook</td>
      <td>kimMath</td>
    </tr>
    <tr>
      <td>2</td>
      <td>javaBook</td>
      <td>kimJava</td>
    </tr>
    <tr>
      <td>3</td>
      <td>SpringBook</td>
      <td>SpringPark</td>
    </tr>
    </tbody>
  </table>
<script>
  const trList = document.querySelectorAll('#book_list>tbody>tr');
  trList.forEach( ele => {
    ele.addEventListener("click", (evt) => {
      location.href = '${contextPath}/book/detail.do?no=x';
    })
  })
</script>
</body>
</html>
