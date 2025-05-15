<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <h1>main page</h1>

<%--
/menu/list.page --forwarding--> menulistpage - /WEB-INF/views/menu/list.jsp

/menu/regist.page --forwarding--> menuregistpage - /WEB-INF/views/menu/regist.jsp
/menu/regist.do --redirect--> menu/list.page url redirect

/menu/detail.page?code=xx --forwarding--> menudtatil page - /WEB-INF/views/menu/detail.jsp(detail data required)

/menu/modify.page --forwarding--> menu mod page - /WEB-INF/views/menu/modify.jsp
/menu/modify.do --redirect--> /menu/detail.page?code=xx url redirect
--%>
<a href="${contextPath}/menu/list.page">menu list</a>
</body>
</html>
