<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="container p-3">

  <!-- header, nav start -->
  <jsp:include page="/WEB-INF/views/common/header.jsp"/> <!-- 현재파일위치가 달라질 수 있어서 상대경로가 아닌 webinfo 기준으로 절대경로로 작성하는 것이 좋음 -->
  <!-- header, nav start -->

  <!-- Section start -->
  <section class="row m-3" style="min-height: 500px">

    <div class="container border p-5 m-4 rounded">

      <h2 class="m-4">해당 페이지의 내용이 보여져야되는 자리</h2>


    </div>

  </section>
  <!-- Section end -->

  <!-- Footer start -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- Footer end -->

</div>
</body>
</html>
