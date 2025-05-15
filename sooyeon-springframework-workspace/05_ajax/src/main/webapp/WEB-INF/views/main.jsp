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
  document.getElementById("btn1").addEventListener('click', (evt) => {
    const id = document.getElementById('input1_1').value;
    const pwd = document.getElementById('input1_2').value;

    // 쿼리스트링제작
    const params = new URLSearchParams({
      id: id,
      pwd: pwd
    }).toString();

    // get방식으로 url요청
    fetch('${contextPath}/ajaxTest1.do?' + params, {method: 'GET'})
      .then(response => response.text())
      .then(data => {
        document.getElementById('result1').textContent = data;
      });
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
  document.getElementById('btn2').addEventListener('click', (evt) => {
    const id = document.getElementById('input2_1').value;
    const pwd = document.getElementById('input2_2').value;

    const formData = new URLSearchParams();
    formData.append('id', id);
    formData.append('pwd', pwd);

    fetch('${contextPath}/ajaxTest2.do', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-form-urlencoded'
      },
      body: formData
    })
      .then(response => response.text())
      .then(date => {
        document.getElementById('result2').textContent = date;
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
  document.getElementById('btn3').addEventListener('click', (evt) => {
    const id = document.getElementById('input3_1').value;
    const pwd = document.getElementById('input3_2').value;

    fetch('${contextPath}/ajaxTest3.do', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify({
        id: id,
        pwd: pwd
      })
    })
      .then(response => response.text())
      .then(date => {
        document.getElementById('result3').textContent = date;
      })
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
    const noInput = document.getElementById('input4');  //value로 값을 안꺼내고 input객체를 담음

    fetch('${contextPath}/ajaxTest4.do?no=' + noInput.value)
      .then(response => response.json())
      .then(data => {
        document.getElementById('result4').innerHTML =
          `<ul>
            <li>아이디: \${data.id}<li>
            <li>비번: \${data.pwd}<li>
            <li>이름: \${data.name}<li>
            <li>나이: \${data.age}<li>
          <ul>`;
        noInput.value = "";
      });
  });
</script>


<hr>
<h3>5. Java 객체(List) 응답</h3>
<button id="btn5">요청</button>
<br>
응답 :
<table id="result5" border="1">
  <tbody>
  요청5의 결과가 보여지는 영역
  </tbody>
</table>

<script>
  document.getElementById('btn5').addEventListener('click', (evt) => {
    fetch('${contextPath}/ajaxTest5.do')
      .then(response => response.json())
      .then(data => {
        let tableContent = `
          <tr>
            <th>아이디</th>
            <th>비번</th>
            <th>이름</th>
            <th>나이</th>
          </tr>
        `;
        data.forEach(user => {
          tableContent += `
                          <tr>
                            <td>\${user.id}</td>
                            <td>\${user.pwd}</td>
                            <td>\${user.name}</td>
                            <td>\${user.age}</td>
                          </tr>
                        `;
        });
        document.getElementById('result5').innerHTML = tableContent;
      })
  });
</script>


</body>
</html>