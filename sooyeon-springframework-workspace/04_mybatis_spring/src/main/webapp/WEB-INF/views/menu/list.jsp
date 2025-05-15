<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>메뉴목록페이지</title>
</head>
<body>

  <c:if test="${not empty message}">
    <script>alert('${message}');</script>
  </c:if>



  <h2>판매중인 메뉴 목록</h2>

  <button onclick="location.href = '${contextPath}/menu/regist.page';">신규메뉴등록</button>

  <form action="${contextPath}/menu/remove.do" method="POST">
    <button type="submit">일괄삭제</button>

    <table border="1">
      <thead>
      <tr>
        <th></th>
        <th>번호</th>
        <th>메뉴명</th>
        <th>메뉴가격</th>
        <th>카테고리번호</th>
      </tr>
      </thead>
      <tbody>
      <!--메뉴 목록이 존재하지 않을 경우-->
      <c:choose>
        <c:when test="${empty menuList}">
          <tr>
            <td colspan="5" style="text-align: center;">판매가능한 메뉴가 존재하지 않습니다.</td>
          </tr>
        </c:when>
        <c:otherwise>
          <c:forEach var="menu" items="${menuList}">
            <tr>
              <td><input type="checkbox" name="code" value="${menu.menuCode}"></td>
              <td>${menu.menuCode}</td>
              <td>
                <a href="${contextPath}/menu/detail.page?menuCode=${menu.menuCode}">
                    ${menu.menuName}
                </a>
              </td>
              <td>${menu.menuPrice}</td>
              <td>${menu.categoryCode}</td>
            </tr>
          </c:forEach>
        </c:otherwise>
      </c:choose>
      </tbody>
    </table>
  </form>

</body>
</html>
