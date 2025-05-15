-- tbl_user data
insert into tbl_user
values(null, 'admin01', '1234', '관리자', 'admin@kangbroo.com', 'F', '010-1111-2222', '서울시 강남구 역삼동', null, '20220101', '20220101', 'A');
insert into tbl_user
values(null, 'user01', 'pass01', '홍길동', 'user01@kangbroo.com', 'M', '010-3333-4444', '서울시 양천구 목동', null, '20220201', '20220201', 'U');
insert into tbl_user
values(null, 'user02', 'pass02', '김말똥', 'user02@kangbroo.com', 'F', '010-5555-6666', '서울시 강서구 마곡', null, '20220301', '20220301', 'U');
insert into tbl_user
values(null, 'user03', 'pass03', '강**', null, null, null, null, null, '20220401', '20220501', 'R');

-- tbl_board data
insert into tbl_board
values(null, 'HTML5', 3, '새로운 웹 표준기술로 모든 디바이스 장치와 브라우저에서 동일하게 작동되는 웹 페이지를 만들기 위한 기술을 제공합니다.', default, '20220723', '20220723', default);
insert into tbl_board
values(null, 'CSS3', 2, '웹 페이지를 꾸미기 위한 스타일시트로 HTML5 버전에 맞추어 속성들이 업그레이드 되었습니다.', default, '20220730', '20220730', default);
insert into tbl_board
values(null, 'JavaScript 란', 3, '웹 표준 2.0 에서 새로 추가된 강력한 API 들을 제공합니다.', default, '20220803', '20220803', default);
insert into tbl_board
values(null, 'jQuery 란', 1, '자바스크립트 오픈 소스 라이브러리의 하나로 html 요소들을 css 선택자를 이용하여 쉽게 선택할 수 있는 기능들을 제공합니다.', default, '20220807', '20220807', default);
insert into tbl_board
values(null, 'Servlet 이란', 1, '서버에서 구동되는 웹 규약이 적용된 Java EE 모듈이 제공하는 서비스 처리용 클래스입니다.', default, '20220901', '20220901', default);
insert into tbl_board
values(null, 'JSP란', 3, 'Java Server Page 를 말합니다.', default, '20220921', '20220921', default);
insert into tbl_board
values(null, 'JSP Elements 들', 1, 'Derective(지시자) 태그, Decleation(선언) 태그, Scriptlet 태그, Expression 태그가 있습니다.', default, '20221014', '20221014', default);
insert into tbl_board
values(null, 'AJAX 란', 1, 'Asynchronos Javascript And Xml 의 줄임말로 서버의 서블릿과 직접 통신하는 자바스크립트 기술입니다.', default, '20221108', '20221108', default);
insert into tbl_board
values(null, '필터(Filter) 란', 3, '클라이언트 요청한 서비스가 서블릿으로 전달되기 전에 먼저 구동되는 클래스입니다.', default, '20221109', '20221109', default);
insert into tbl_board
values(null, '래퍼(Wrapper) 란', 2, '필터가 낚아챈 요청에 대한 데이터 처리를 담당하는 클래스입니다.', default, '20221110', '20221110', default);
insert into tbl_board
values(null, 'MVC Model1 패턴', 3, '웹 애플리케이션 설계 방식 중 JSP 파일이 뷰와 컨트롤러 두가지 다를 처리하는 방식입니다.', default, '20221118', '20221118', default);
insert into tbl_board
values(null, 'MVC Model2 패턴이란', 2, 'MVC Model1 패턴에서 뷰와 컨트롤러의 역할을 분리하는 방식입니다..', default, '20221207', '20221207', default);
insert into tbl_board
values(null, 'MyBatis Framework 란', 2, '영속성 프레임워크로 JDBC를 활용한 CRUD를 보다 편하게 구현할 수 있습니다.', default, '20230501', '20230501', default);
insert into tbl_board
values(null, 'Spring Framework의 특징', 2, 'IoC(제어역전), DI(의존성 주입), AOP(관점지향프로그래밍) 등이 있습니다.', default, '20240214', '20240214', default);
insert into tbl_board
values(null, '관리자 게시글', 1, '저희 사이트를 이용해 주셔서 감사합니다.',  default, '20240615', '20240615', default);

-- tbl_reply data
insert into tbl_reply
values(null, '첫번째 댓글입니다.', 1, 1, '20240712', default);
insert into tbl_reply
values(null, '두번째 댓글입니다.', 2, 13, '20240714', default);
insert into tbl_reply
values(null, '세번째 댓글입니다.', 3, 13, '20240812', default);
insert into tbl_reply
values(null, '네번째 댓글입니다.', 4, 13, '20250412', default);

commit;
