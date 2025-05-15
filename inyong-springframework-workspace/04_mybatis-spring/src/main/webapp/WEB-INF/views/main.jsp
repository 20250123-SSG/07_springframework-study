<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>

</head>
<body>
<!-- http://localhost:8080/webmvc/  url 요청시 해당 /WEB-INF/views/main.jsp가 보여지도록 포워딩 -->

<h1>메인 페이지 입니다.</h1>

<!--
1) 목록 기능
/menu/list.page ==포워딩==> 메뉴 등록페이지 - /WEB-INF/views/menu/list.jsp(메뉴 목록데이터)
2) 등록기능
/menu/regist.page ==포워딩==> 메뉴 등록페이지 - /WEB-INF/views/menu/regist.jsp
/menu/regist.do ==redirect==> /menu/list.page url 재요청
3) 상세 기능
/menu/detail.page?code=xx ==포워딩==> 메뉴상세페이지 - /WEB-INF/views/menu/detail.jsp (메뉴 상세데이터 필요)
4) 수정 기능
/menu/modify.page?code=xx ==포워딩==> 메뉴수정페이지 - /WEB-INF/views/menu/modify.jsp (메뉴 상세데이터 필요)
/menu/modify.do   ==redirect==>  /menu/detail.page?code=xx url 재요청
-->






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
