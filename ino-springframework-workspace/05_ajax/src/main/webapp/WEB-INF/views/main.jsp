<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h3>1. GET요청(파라미터-쿼리스트링), 문자열 응답</h3>
아이디 : <input type="text" id="input1_1"> <br>
비번 : <input type="text" id="input1_2"> <br>
<button id="btn1">요청</button>
<br>
응답 : <span id="result1">요청1의 결과가 보여지는 영역</span>

<script>
  document.getElementById("btn1").addEventListener("click", (evt) => {
    console.log(evt);
    const id = document.getElementById("input1_1").value;
    const pwd = document.getElementById("input1_2").value;
    // req url : /ajaxTest1.do?id=idVal&pwd=pwdVal

    // make queryString
    const params = new URLSearchParams({id, pwd}).toString();
    fetch("${contextPath}/ajaxTest1.do?" + params, {method: 'GET'})
      .then(response => response.text()) // response(text data) parsing
      .then(data => {
        console.log(data);
        document.getElementById('result1').textContent = data;
      })
  });
</script>

<hr>

<h3>2. POST요청(파라미터-폼데이터), 문자열 응답</h3>
아이디 : <input type="text" id="input2_1"> <br>
비번 : <input type="text" id="input2_2"> <br>
<button id="btn2">요청</button>
<br>
응답 : <span id="result2">요청2의 결과가 보여지는 영역</span>

<script>
  document.getElementById("btn2").addEventListener("click", (evt) => {
    console.log(evt);
    const id = document.getElementById("input2_1").value;
    const pwd = document.getElementById("input2_2").value;

    const formData = new URLSearchParams();
    formData.append('id', id);
    formData.append('pwd', pwd);

    fetch("${contextPath}/ajaxTest2.do", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: formData
    })
      .then(response => response.text())
      .then(data => {
        console.log(data);
        document.getElementById('result2').textContent = data;
      });
  });
</script>

<hr>

<h3>3. POST요청(파라미터-JSON문자열), 문자열 응답</h3>
아이디 : <input type="text" id="input3_1"> <br>
비번 : <input type="text" id="input3_2"> <br>
<button id="btn3">요청</button>
<br>
응답 : <span id="result3">요청3의 결과가 보여지는 영역</span>

<script>
  document.getElementById("btn3").addEventListener("click", (evt) => {
    console.log(evt);
    const id = document.getElementById("input3_1").value;
    const pwd = document.getElementById("input3_2").value;

    fetch("${contextPath}/ajaxTest3.do", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({id: id, pwd: pwd}) // js 객체 선언 방식으로 선언시, 자동으로 변경해줌
    })
      .then(response => response.text())
      .then(data => {
        console.log(data);
        document.getElementById('result3').textContent = data;
      });
  });
</script>

<hr>

<h3>4. Java 객체(DTO) 응답</h3>
번호 : <input type="number" id="input4">
<button id="btn4">요청</button>
<br>
응답 :
<div id="result4">요청4의 결과가 보여지는 영역</div>

<script>
  document.getElementById('btn4').addEventListener('click', (evt) => {

    const noInput = document.getElementById('input4');
    fetch("${contextPath}/ajaxTest4.do?no=" + noInput.value)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        let r4 = `<ul>
                  <li>\${data.id}</li>
                  <li>\${data.name}</li>
                  <li>\${data.pwd}</li>
                  <li>\${data.age}</li>
              </ul>`;
        document.getElementById('result4').innerHTML = r4;
      })
  });
</script>

<hr>

<%--<h3>5. Java 객체(List) 응답</h3>--%>
<%--<button id="btn5">요청</button>--%>
<%--<br>--%>
<%--응답 :--%>
<%--<table id="result5" border="1">--%>
<%--  <tbody>--%>
<%--  요청5의 결과가 보여지는 영역--%>
<%--  </tbody>--%>
<%--</table>--%>

<%--<script>--%>
<%--  document.getElementById('btn5').addEventListener('click', (evt) => {--%>
<%--    fetch("${contextPath}/ajaxTest5.do")--%>
<%--      .then(response => response.json())--%>
<%--      .then(data => {--%>
<%--        console.log(data);--%>
<%--        var tbodyContent = ''; // tbody에 추가할 내용을 담을 변수--%>
<%--        for (const x of data) {--%>
<%--          console.log(x);--%>
<%--          let tr = `--%>
<%--          <tr>--%>
<%--            <td>${x.id}</td>--%>
<%--            <td>${x.pwd}</td>--%>
<%--            <td>${x.name}</td>--%>
<%--            <td>${x.age}</td>--%>
<%--          </tr>--%>
<%--        `;--%>
<%--          tbodyContent += tr; // 각 데이터를 테이블 행으로 만들어 추가--%>
<%--        }--%>
<%--        const tbody = document.querySelector('#result5 tbody'); // id가 result5인 테이블의 tbody 선택--%>
<%--        if (tbody) {--%>
<%--          tbody.innerHTML = tbodyContent;--%>
<%--        }--%>
<%--        // document.querySelector('#result5').textContent = ''; // 이 줄은 제거--%>
<%--      });--%>
<%--  });--%>
<%--</script>--%>
<h3>5. Java 객체(List) 응답</h3>
<button id="btn5">요청</button>
<br>
응답 :
<table id="result5" border="1">
  <tbody>
  </tbody>
</table>

<script>
  document.getElementById('btn5').addEventListener('click', (evt) => {
    fetch("${contextPath}/ajaxTest5.do")
      .then(response => response.json())
      .then(data => {
        console.log(data);
        var tbodyContent = ''; // tbody에 추가할 내용을 담을 변수
        for (const x of data) {
          console.log(x);
          let tr = `
          <tr>
            <td>\${x.id}</td>
            <td>\${x.pwd}</td>
            <td>\${x.name}</td>
            <td>\${x.age}</td>
          </tr>
        `;
          tbodyContent += tr; // 각 데이터를 테이블 행으로 만들어 추가
        }
        const tbody = document.querySelector('#result5 tbody'); // id가 result5인 테이블의 tbody 선택
        if (tbody) {
          tbody.innerHTML = tbodyContent;
        }
      });
  });
</script>


</body>
</html>