<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2>수정 페이지</h2>

  <form action="${contextPath}/notice/modify.do" method="POST">
    <!-- Modle로 NoticeDto를 보냈어도 view에서 name을 한번 더 지정해줘야 다음 controller로 넘길 수 있다-->
    <input type="hidden" name="no" value="${notice.no}"/> <!--사용자에게는 보여지지 않음-->
    제목 : <input type="text" name="title" value="${notice.title}"><br>
    내용 : <textarea name="content">${notice.content}</textarea>

    <button type="submit">수정</button>
  </form>
</body>
</html>
