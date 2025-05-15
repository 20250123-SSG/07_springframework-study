<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>menu modify</h2>
<form action="${contextPath}/menu/modify.do" method="post">
  <input type="hidden" name="menuCode" value="${menu.menuCode}">
  menu name: <input type="text" name="menuName" value="${menu.menuName}"><br>
  menu price: <input type="number" name="menuPrice" value="${menu.menuPrice}"><br>
  categoryCode: <input type="number" name="categoryCode" value="${menu.categoryCode}"><br>
  orderable status:
  <input type="radio" name="orderableStatus" value="Y"> 판매
  <input type="radio" name="orderableStatus" value="N"> 미판매
  <button type="submit">regist</button>
</form>
<script>
  document.querySelector('input[value=${menu.orderableStatus}]').setAttribute('checked', 'checked');
</script>
</body>
</html>
