<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<style>
  #profileImg {
    width: 250px;
    height: 250px;
    border: 1px solid lightgray;
    border-radius: 50%;
  }
</style>
<body>
<div class="container p-3">

  <!-- Header, Nav start -->
  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
  <!-- Header, Nav end -->

  <!-- Section start -->
  <section class="row m-3" style="min-height: 500px">

    <div class="container border p-5 m-4 rounded">
      <h2 class="m-4">마이페이지</h2>
      <br>

      <div align="center">
        <%--        <img id="profileImg" src="${contextPath}/resources/images/defaultProfile.png"--%>
        <%--             onclick="document.getElementById('profileImgFile').click();">--%>
        <img id="profileImg"
             src="${contextPath}${loginUser.profileURL == null ? '/resources/images/defaultProfile.png' : loginUser.profileURL}"
             onclick="document.getElementById('profileImgFile').click();">
        <input type="file" class="file" id="profileImgFile" style="display:none;">
      </div>

      <script>
        document.getElementById('profileImgFile').addEventListener('change', evt => {
          const fileInput = evt.target; // input type = file element object
          // 접근시 FileList객체 [File, File, File, File, ...]
          // length를 통해 개수 접근 가능, 취소 누르면 0됨
          // fileInput.files[0] : 선택 객체
          if (fileInput.files.length != 0) {
            // File -> FormData Object
            let formData = new FormData();
            formData.append('uploadFile', fileInput.files[0]);
            fetch("${contextPath}/user/modifyProfile.do", {
              method: 'POST',
              body: formData // formData 객체 전송시, 헤더에 전송 데이터 타입 지정x(default multipart/form-data)
            })
              .then(response => response.text())
              .then(data => {
                if (data === 'SUCCESS') {
                  alert("success");
                  location.reload();
                  // 방법1. 각각 이미지를 바꾸기
                  // 방법2. location.reload() 함수를 통해 변경(내가 보던 url 재요청)
                }
              })
          }
        })
      </script>

      <form action="정보수정요청url" method="POST">
        <div class="form-group">
          <label for="userId">* ID :</label>
          <input type="text" class="form-control" id="userId" name="" value="${loginUser.userId}" readonly><br>

          <label for="userName">* Name :</label>
          <input type="text" class="form-control" id="userName" name="" value="${loginUser.userName}"><br>

          <label for="email"> &nbsp; Email :</label>
          <input type="email" class="form-control" id="email" name="" value="${loginUser.email}"><br>

          <label for="phone"> &nbsp; Phone :</label>
          <input type="tel" class="form-control" id="phone" name="" value="${loginUser.phone}"><br>

          <label for="address"> &nbsp; Address :</label>
          <input type="text" class="form-control" id="address" name="" value="${loginUser.address}"><br>

          <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp;
          <input type="radio" name="" id="Male" value="M">
          <label for="Male">남자</label> &nbsp;&nbsp;
          <input type="radio" name="" id="Female" value="F">
          <label for="Female">여자</label><br>


          <script>
            document.querySelector('#modify_form input[value=${loginUser.gender}]').checked = true;
          </script>
        </div>
        <br>
        <div class="btns" align="center">
          <button type="submit" class="btn btn-primary">수정하기</button>
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
        </div>
      </form>

    </div>

  </section>
  <!-- Section end -->

  <!-- Footer start -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- Footer end -->

</div>

<!-- 회원탈퇴 버튼 클릭시 보여질 Modal -->
<div class="modal" id="deleteForm">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">회원탈퇴</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" align="center">

        <b>
          탈퇴 후 복구가 불가능합니다. <br>
          정말로 탈퇴 하시겠습니까?
        </b>

        <form action="탈퇴요청url" method="POST">
          비밀번호 :
          <input type="password" name="" required>

          <button type="submit" class="btn btn-danger">탈퇴하기</button>
        </form>

      </div>

    </div>
  </div>
</div>
</body>
</html>