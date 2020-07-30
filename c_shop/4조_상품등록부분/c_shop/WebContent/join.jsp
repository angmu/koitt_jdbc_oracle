<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link rel="stylesheet" type="text/css" href="css/style_join.css">
	<jsp:include page="common/config.jsp"/>
	<!-- 유효성 검사  -->
	<script type="text/javascript" src="js/custom_join.js"></script>
	<!-- 주소검색 스크립트 -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	    function daumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	              $("#add_num").val(data.zonecode);
	              $("#rail_add").val(data.address);
	              $("#address_etc").val(data.address_etc);
	              $("#detail_add").focus();
	                
	            }
	        }).open();
	    }
	</script>
</head>
	<body>
		<jsp:include page="common/nologin_top-nav.jsp" />
		<!-- 본문시작 -->
		<section>
			<form action="join.do" name="info_form" id="info_form" onsubmit="return all_check()">
				<div id="stu_input_wrap">
					<!-- 제목 -->
					<p>
						회원가입
					</p>
					
					<!-- 고정항목 테이블 -->
					
					<span> 
						<img alt="아이콘" src="img/bg_span.png">
						고정 항목
					</span>
					<table id="primary_info">
						<tr>
							<th>아이디</th>
							<td colspan="3">
								<input type="text" name="id" id="id" >
								<a class="dople" href="#" onclick="id_check()">
									<img alt="체크" src="img/icon_dopel.png">
									중복확인
								</a> 
								<span>
									<img alt="알림" src="img/icon_exclamation.png"> 
									영문 또는 숫자 조합(5~15자리)
								</span>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3">
								<input type="password" name="pw"> 
								<span>
									<img alt="알림" src="img/icon_exclamation.png">
									5~16자리, 영문+숫자+특수문자(~!@\#$%<>^&*)
								</span>
							</td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td colspan="3">
								<input type="password" name="pw_check">
							</td>
						</tr>
						
						<tr>
							<th>이름</th>
							<td class="mini">
								<input type="text" name="name">
							</td>
						</tr>
						<tr>
							<th>성별</th>
							<td class="mini">
								<input type="radio" name="gender" value="남성"checked>
								남 
								<input type="radio" name="gender" value="여성">
								여
							</td>
							<th>생년월일</th>
							<td class="mini">
								<input type="date" name="birth">
							</td>
						</tr>
						<tr>
							<th>휴대폰번호</th>
							<td colspan="3">
								<select name="phone_head" class="info_selec">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
									<option value="070">070</option>
								</select> 
								- 
								<input type="text" maxlength="4" name="phone_mid">
								- 
								<input type="text" maxlength="4" name="phone_tail">
								<input type="radio" name="sms" value="예"> 
								<label for="sms">문자수신 동의</label>
								<input type="radio" name="sms" value="아니오"> 
								<label for="sms">비동의</label>
							</td>
						</tr>
						
					</table>
					<!-- 추가항목 테이블 -->
					<span> 
						<img alt="아이콘" src="img/bg_span.png">
						추가 항목
					</span>
					<table id="detail_info">
						<tr>
							<th>이메일</th>
							<td>
								<input type="text" name="email_head" id="email_head">
								@ 
								<input type="text" name="email_tail" id="email_tail">
								<select onchange="document.getElementById('email_tail').value = this.options[this.selectedIndex].value">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="empal.com">empal.com</option>
									<option value="daum.net">daum.net</option>
								</select> 
								<input type="radio" name="news" id="email_agree" value="예">
								<label for="email_agree">이메일 수신 동의</label>
								<input type="radio" name="news" id="email_agree" value="아니오">
								<label for="email_agree">비동의</label>
								</td>
						</tr>
						<!-- 주소입력부분 -->
						<tr>
							<th>주소</th>
							<td>
							<input type="text" name="add_num" id="add_num" placeholder="우편번호" readonly> 
							<a class="dople" id="add_search" href="#" onclick="daumPostcode()">
								<img alt="체크" src="img/icon_dopel.png">
								주소검색
							</a> <br> 
							<input type="text" name="address" id="rail_add" placeholder="도로명 주소" readonly>
							
							<input type="text" name="normal_add" id="normal_add" placeholder="지번주소" readonly><br>
							
							<input type="text" name="detail_add" id="detail_add" placeholder="상세주소"> 
							
							<input type="text" name="desc_add" id="desc_add" placeholder="참고항목">
							</td>
						</tr>
						
					</table>
					<!-- 아래버튼부분 -->
					<div id="submit">
						<button type="submit">
							저장하기
						</button>
						<button type="button" onclick="javascript:location.href='index.jsp'">
								취소
						</button>
					</div>
				</div>
			</form>
	
		</section>
		<jsp:include page="common/footer.jsp"/>
	</body>
</html>