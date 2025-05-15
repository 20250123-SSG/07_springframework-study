<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h2> 첨부파일 업로드 테스트</h2>
  <h3> 1. 한 개의 첨부파일 업로드 테스트</h3>
  <form action="${contextPath}/board/regist1.do" method="POST">
    게시글 제목 : <input type="text" name="boardTitle"> <br>
    게시글 내용 : <textarea name="boardContent"></textarea> <br>
    첨부파일: <input type="file" name=uploadFile"" accept="image/*">
    <input type="submit">
  </form>
</body>
</html>
