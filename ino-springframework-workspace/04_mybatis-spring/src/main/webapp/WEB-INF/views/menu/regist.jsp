<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>menu info regist</h2>
<form action="${contextPath}/menu/regist.do" method="post">
  menu name: <input type="text" name="menuName"><br>
  menu price: <input type="number" name="menuPrice"><br>
  categoryCode: <input type="number" name="categoryCode"><br>
  orderable status:
  <input type="radio" name="orderableStatus" value="Y" checked> 판매
  <input type="radio" name="orderableStatus" value="N"> 미판매
  <button type="submit">regist</button>
</form>

</body>
</html>
