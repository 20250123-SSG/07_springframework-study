<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${contextPath}/resources/js/sample.js"></script>
</head>
<body>
  <!--http"//localhost:8080/webmvc URL 요청시 해당 /WEB_INF/views/,ain./jsp가 보여지도록 포워딩-->
  <h1>메인 페이지 입니다.</h1>

  <h3>1.정적 자원(이미지) 확인</h3>
  <img src="${contextPath}/assets/image/flower1.jpg" width="200" onclick="test();">

  <hr>
  <h3>2. 응답페이지 포워딩 또는 redirect 처리</h3>
  <!--/book/list.do -> get 요청 -> 목록페이지(~/book/list.jsp) ======> 포워딩-->
  <a href="${contextPath}/book/list.do">도서 목록 페이지로 이동</a>


  <h3>3. 요청파라미터(request param) 처리 연습</h3>
  <a href="${contextPath}/member/detail.do?no=1">1번회원상세조회</a>

  <br><br>
  HttpServletRequest
  <form action="${contextPath}/member/regist1.do" method="POST">
    이름 : <input type="text" name="name"><br>
    나이 : <input type="number" name="age"><br>
    주소 : <input type="text" name="address">
    <button type="submit">등록</button>
  </form>

  <br><br>
  RequestParam
  <form action="${contextPath}/member/regist2.do" method="POST">
    이름 : <input type="text" name="name"><br>
    나이 : <input type="number" name="age"><br>
    주소 : <input type="text" name="address">
    <button type="submit">등록</button>
  </form>

  <br><br>
  RequestParam
  <form action="${contextPath}/member/regist3.do" method="POST">
    이름 : <input type="text" name="name"><br>
    나이 : <input type="number" name="age"><br>
    주소 : <input type="text" name="address">
    <button type="submit">등록</button>
  </form>

  <hr>

  <h3>4. 포워딩 또는 redirect시 필요한 데이터 담는 방법</h3>
  <a href="${contextPath}/notice/list.page">공지사항 목록페이지로 이동을 할까요 말까요? 알아맞춰 보세요 ^^!</a>





</body>
</html>
