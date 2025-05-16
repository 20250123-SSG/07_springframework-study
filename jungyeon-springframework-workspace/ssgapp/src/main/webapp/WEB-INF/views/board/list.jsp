<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
  <style>
    #boardList th, #boardList td:not(:nth-child(2)){text-align: center;}
    #boardList>tbody>tr:hover{cursor:pointer;}

    .page-link {
      color: #6c757d;
      background-color: #fff;
      border: 1px solid #ccc;
    }
    .page-item.active .page-link {
      z-index: 1;
      color: #555;
      font-weight:bold;
      background-color: #f1f1f1;
      border-color: #ccc;
    }
    .page-link:focus, .page-link:hover {
      color: #000;
      background-color: #fafafa;
      border-color: #ccc;
    }
  </style>
</head>
<body>

<div class="container p-3">

  <!-- Header, Nav start -->
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <!-- Header, Nav end -->

  <!-- Section start -->
  <section class="row m-3" style="min-height: 500px">

    <div class="container border p-5 m-4 rounded">
      <h2 class="m-4">게시글 목록</h2>
      <br>

      <!-- 로그인후 상태일 경우만 보여지는 글쓰기 버튼-->
      <c:if test="${not empty loginUser}">
        <a class="btn btn-secondary" style="float:right" href="${contextPath}/board/regist.page">글쓰기</a>
        <br>
      </c:if>

      <br>
      <table id="boardList" class="table table-hover" align="center">
        <thead>
        <tr>
          <th width="100px">번호</th>
          <th width="400px">제목</th>
          <th width="120px">작성자</th>
          <th>조회수</th>
          <th>작성일</th>
          <th>첨부파일</th>
        </tr>
        </thead>
        <tbody>
        <!--현재요청한페이지에 보여져야될 게시글목록데이터 출력 (현재는 임의의 tr요소)-->
        <c:forEach var="board" items="${list}">
          <tr onclick="location.href='${contextPath}/board/detail.page?no=${board.boardNo}';">
            <td>${board.boardNo}</td>
            <td>${board.boardTitle}</td>
            <td>${board.boardWriter}</td>
            <td>${board.readCount}</td>
            <td>${board.registDate}</td>
            <td>${board.attachCount == 0 ? '' : '📎'}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <br>

      <!--현재보고있는 페이지에 따라 동적으로 페이징바도 제작해야됨-->
      <ul id="paging_area" class="pagination d-flex justify-content-center">

        <li class="page-item ${page == 1 ? 'disabled' : ''}">
          <a class="page-link" href="${contextPath}/board/list.page?page=${page-1}">Previous</a>
        </li>

        <c:forEach var="p" begin="${beginPage}" end="${endPage}">
          <li class="page-item ${p == page ? 'active' : ''}">
            <a class="page-link" href="${contextPath}/board/list.page?page=${p}">${p}</a>
          </li>
        </c:forEach>

        <li class="page-item ${page == totalPage ? 'disabled' : ''}">
          <a class="page-link" href="${contextPath}/board/list.page?page=${page+1}">Next</a>
        </li>

      </ul>

      <br clear="both"><br>

      <form id="search_form" action="검색요청url" method="GET" class="d-flex justify-content-center">
        <div class="select" >
          <select class="custom-select" name="">
            <option value="">작성자</option>
            <option value="">제목</option>
            <option value="">내용</option>
          </select>
        </div>
        <div class="text">
          <input type="text" class="form-control" name="">
        </div>
        <button type="submit" class="search_btn btn btn-secondary">검색</button>
      </form>

    </div>
  </section>
  <!-- Section end -->

  <!-- Footer start -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- Footer end -->

</div>

</body>
</html>