<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pages - Login</title>
  <jsp:include page="common/config.jsp" />
  <link rel="stylesheet" href="css/login.css">
</head>

<body>
  <c:if test="${check==1 }">
	  <script type="text/javascript">
		  	alert("가입이 정상적으로 완료되었습니다.");
	  </script>
  </c:if>
  <c:if test="${check==0 }">
	  <script type="text/javascript">
	  		alert("가입이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
			history.back(-1);
	  </script>
  </c:if>
  <jsp:include page="common/nologin_top-nav.jsp" />
  <section>
    <h1>로그인</h1>

    <article id="category">
      <ul>
        <li class="selected">회원 로그인</li>
        <li><a href="#">비회원 주문조회</a></li>
      </ul>  
    </article>

    <form action="login.do" name="login" method="post" >
      <div class="id">
        <input type="text" name="id" size="30" placeholder="통합아이디 6~20자" maxlength="20" required>
      </div>
      <div class="pw">
        <input type="password" name="pw" size="45" placeholder="비밀번호 영문, 특수문자, 숫자혼합 8~12자" maxlength="12" required>
      </div>

      <a href="#">
        <div id="save">
          <div class="save"></div>
          <span>아이디 저장</span>
        </div>  
      </a>
  
      <div id="find">
        <span><a href="#">아이디 찾기</a></span> <span class="separator">|</span> <span><a href="#">비밀번호 찾기</a></span>
      </div>

      <button type="submit">로그인</button>
    </form>

    <ul class="login-icons">
      <a href="#"><li class="phone"></li></a>
      <a href="#"><li class="kakao"></li></a>
      <a href="#"><li class="naver"></li></a>
      <a href="#"><li class="facebook"></li></a>
    </ul>

    <div class="sign-up-info">
      <h3>CJ ONE 통합회원이 아니신가요?</h3>
      <p>CJ ONE 통합회원으로 가입하시면 CJ제일제당의 다양한 서비스(COOKIT, CJ THE MARKET, CJ제일제당 홈페이지)를 이용하실 수 있습니다.</p>
      <a href="join.jsp">
        <div class="sign-up">CJ ONE 통합회원 신규가입하기 <div class="arrow">&emsp;</div></div>
      </a>
    </div>
  </section>
  <jsp:include page="common/footer.jsp"/>
</body>
</html>