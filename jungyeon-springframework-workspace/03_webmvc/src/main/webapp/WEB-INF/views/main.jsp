<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <script src="${contextPath}/resources/js/sample.js"></script>
</head>
<body>
<!-- http://localhost:8080/webmvc/  url 요청시 해당 /WEB-INF/views/main.jsp가 보여지도록 포워딩 -->

<h1>메인 페이지 입니다.</h1>

<h3>1. 정적 자원(이미지 등) 확인</h3>
<!-- http://localhost:8080/webmvc/book/assets/image/flower1.jpg -->
<!-- <img src="assets/image/flower1.jpg" width="200">  상대경로 : 현재 보여지는 url의 마지막 / 뒤에 붙음 -->

<!-- http://localhost:8080/webmvc/assets/image/flower1.jpg -->
<img src="${contextPath}/assets/image/flower1.jpg" width="200" onclick="test();"> <!-- 절대경로 : url의 포트번호 뒤에 붙음 -->

<hr>

<h3>2. 응답페이지 포워딩 또는 redirect 처리</h3>
<!-- /book/list.do ==Get요청==> 목록페이지(/WEB-INF/views/book/list.jsp) 포워딩 -->
<a href="${contextPath}/book/list.do">도서목록페이지로 이동</a>

<hr>

<h3>3. 요청파라미터(request param) 처리 연습</h3>

<a href="${contextPath}/member/detail.do?no=1">1번 회원상세조회</a>
<br><br>

<form action="${contextPath}/member/regist1.do" method="POST">
  이름 : <input type="text" name="name"> <br>
  나이 : <input type="number" name="age"> <br>
  주소 : <input type="text" name="address"> <br>
  <input type="submit" value="등록">
</form>
<br>

<form action="${contextPath}/member/regist2.do" method="POST">
  이름 : <input type="text" name="name"> <br>
  나이 : <input type="number" name="age"> <br>
  주소 : <input type="text" name="address"> <br>
  <input type="submit" value="등록">
</form>
<br>

<form action="${contextPath}/member/regist3.do" method="POST">
  이름 : <input type="text" name="name"> <br>
  나이 : <input type="number" name="age"> <br>
  주소 : <input type="text" name="addr"> <br>
  <input type="submit" value="등록">
</form>

<hr>

<h3>4. 포워딩 또는 redirect시 필요한 데이터 담는 방법</h3>

<a href="${contextPath}/notice/list.page">공지사항 목록페이지로 이동</a>

<!--
  ## url 패턴 ##
  1. REST 방식 개발
     1) 프론트엔드와 백엔드를 완벽하게 분리
     2) 백엔드에서는 요청에 따라 페이지 forwarding 또는 redirect가 아닌
        요청에 필요한 데이터(자원,리소스)만을 응답하는 방식
     3) url 패턴 : 리소스(자원) 중심, 복수형 명사로 표현
        → 조회(GET)     : /books, /books/1
        → 생성(POST)    : /books
        → 수정(PUT)     : /books/1
        → 삭제(DELETE)  : /books/1

  2. REST 방식 개발 x
     1) 프론트엔드와 백엔드를 함께 개발 (모노리틱 구조)
     2) 백엔드에서는 요청에 따라 응답페이지로 forwarding 또는 redirect 진행
     3) url 패턴 : 행위(동작) 중심, 동사형으로 표현
        → /login.do
        → /getUserList.do
        → /user_list.do
        → /user/modify.do, /user/regist.do

        조회요청(페이지이동)           : *.page
        추가/수정/삭제요청(데이터변경) : *.do
-->




</body>
</html>