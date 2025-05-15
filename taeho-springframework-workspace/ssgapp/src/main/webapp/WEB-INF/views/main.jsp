<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>

<div class="container p-3">

  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <!-- Header, Nav start -->
  <section class="row m-3" style="min-height: 500px">

    <div class="container border p-5 m-4 rounded">

      <h2 class="m-4">해당 페이지의 내용이 보여져야되는 자리</h2>
    </div>

  </section>
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</div>

</body>
</html>
