<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>회원가입페이지</title>
  <!-- Bootstrap 사용을 위한 CDN -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <!-- ------------------------- -->
  <style>
    .uncheck {
      display: none;
    }

    .smallfont {
      font-size: 0.8em;
    }

    .usable {
      color: green;
    }

    .unusable {
      color: red;
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
      <h2 class="m-4">회원가입</h2>
      <br>

      <form action="${contextPath}/user/signup.do" method="POST" id="signup_form">
        <div class="form-group">
          <label for="userId">* ID :</label>
          <input type="text" class="form-control" id="userId" name="userId" placeholder="Please Enter ID" required>
          <div id="idcheck_result" class="uncheck smallfont"></div>

          <br>

          <label for="userPwd">* Password :</label>
          <input type="password" class="form-control" id="userPwd" name="userPwd" placeholder="Please Enter Password"
                 required><br>

          <label for="checkPwd">* Password Check :</label>
          <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required><br>

          <label for="userName">* Name :</label>
          <input type="text" class="form-control" id="userName" name="userName" placeholder="Please Enter Name"
                 required><br>

          <label for="email"> &nbsp; Email :</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="Please Enter Email"><br>

          <label for="phone"> &nbsp; Phone :</label>
          <input type="tel" class="form-control" id="phone" name="phone" placeholder="Please Enter Phone (-포함)"><br>

          <label for="address"> &nbsp; Address :</label>
          <input type="text" class="form-control" id="address" name="address" placeholder="Please Enter Address"><br>

          <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp;
          <input type="radio" name="" id="Male" value="M">
          <label for="Male">남자</label> &nbsp;&nbsp;
          <input type="radio" name="" id="Female" value="F">
          <label for="Female">여자</label><br>
        </div>
        <br>
        <div class="btns" align="center">
          <button type="submit" class="btn btn-primary" disabled>회원가입</button>
          <button type="reset" class="btn btn-danger"> 초기화</button>
        </div>
      </form>

      <script>
        // dynamic element
        const mesResult = document.querySelector('#signup_form #idcheck_result'); // div box
        const submitBtn = document.querySelector('#signup_form [type=submit]'); // register btn

        function statusChange(flag) { // 1: usable 2: unusable
          if (flag == 1) {
            msgResult.classList.remove('unusable')
            msgResult.classList.add('usable');
            submitBtn.removeAttribute('disabled');
          } else if (flag == 2) {
            msgResult.classList.add('unusable')
            msgResult.classList.remove('usable');
            submitBtn.setAttribute('disabled', 'disabled');
          }
        }

        document.addEventListener('DOMContentLoaded', () => {
          submitBtn.setAttribute('disabled', 'disabled'); // 페이지 로딩 시 버튼 비활성화 (초기 상태)
        });

        document.querySelector('#signup_form #userId').addEventListener('keyup', evt => {
          const userIdInput = evt.target; // id Input element
          if (userIdInput.value.trim().length == 0) { // 값이 다 지워지면
            mesResult.className = 'uncheck smallfont'; // 초기상태로
            submitBtn.setAttribute('disabled', 'disabled'); // 값 없어지면 버튼 비활성화
          } else {
            mesResult.classList.remove('uncheck');

            const regExp = /^[a-z\d]{5,12}$/;
            if (regExp.test(userIdInput.value)) { // satisfy pattern -> query (async)
              fetch('${contextPath}/user/idcheck.do?checkId=' + userIdInput.value)
                .then(response => response.text())
                .then(data => {
                  if (data === 'NOTUSED') { // 컨트롤러 반환 값과 일치
                    msgResult.textContent = 'good';
                    statusChange(1);
                  } else { // 'USED'인 경우
                    msgResult.textContent = '이미 사용 중인 아이디입니다.';
                    statusChange(2);
                  }
                })
                .catch(error => {
                  console.error('아이디 중복 확인 요청 실패:', error);
                  msgResult.textContent = '아이디 중복 확인에 실패했습니다.';
                  statusChange(2);
                });
            } else { // do not satisfy pattern -> not query
              msgResult.textContent = '영문, 숫자 포함 5~12자리로 작성해주세요';
              statusChange(2);
            }
          }
        });
      </script>

    </div>

  </section>
  <!-- Section end -->

  <!-- Footer start -->
  <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
  <!-- Footer end -->

</div>


</body>
</html>
