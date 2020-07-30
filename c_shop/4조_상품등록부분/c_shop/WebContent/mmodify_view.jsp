<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
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
		<c:if test="${check==1 }">
		  	<script type="text/javascript">
		  		alert("저장이 정상적으로 완료되었습니다.");
		  	</script>
		 </c:if>
		 <c:if test="${check==0 }">
		  	<script type="text/javascript">
		  		alert("저장이 정상적으로 이루어지지 않았습니다. 다시 시도해 주세요.");
				history.back(-1);
		  	</script>
		 </c:if>
	</head>
	<body>
		<jsp:include page="common/top-nav.jsp"/>
		<section>
			<form action="mmodify.do" name="modify_form" id="modify_form" onsubmit="return modify_check()">
				<div id="stu_input_wrap">
					<!-- 제목 -->
					<p>
						회원정보수정
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
								<input type="text" name="id" id="id" value=${dto.id } readonly>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3">
								<input type="text" name="pw" id="pw" value=${dto.pw } readonly> 
								<span>
									<img alt="알림" src="img/icon_exclamation.png">
									5~16자리, 영문+숫자+특수문자(~!@\#$%<>^&*)
								</span>
							</td>
						</tr>
						
						
						<tr>
							<th>이름(한글)</th>
							<td class="mini">
								<input type="text" name="name" name="name" value=${dto.name }>
							</td>
							<th>이름(영문)</th>
							<td class="mini">
								<input type="text" name="stu_engName">
							</td>
						</tr>
						<tr>
							<th>성별</th>
							<td class="mini">
								<c:if test="${dto.gender=='남성'}">
									<input type="radio" name="gender" value="남성" id="man" checked>
									<label for="man">남</label> 
									<input type="radio" name="gender" value="여성" id="woman">
									<label for="woman">여</label>
								</c:if>
								<c:if test="${dto.gender=='여성'}">
									<input type="radio" name="gender" value="남성" >
									남 
									<input type="radio" name="gender" value="여성" checked>
									여
								</c:if>
							</td>
							<th>생년월일</th>
							<td class="mini">
								<input type="date" name="birth" value=${dto.birth }>
							</td>
						</tr>
						<tr>
							<th>휴대폰번호</th>
							<td colspan="3">
								
								
								<select name="phone_head" class="info_selec">
										<option value=${dto.getPhone_head() }> ${dto.phone_head }</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
										<option value="070">070</option>
								</select> 
								- 
								<input type="text" maxlength="4" name="phone_mid" value=${dto.phone_mid }>
								- 
								<input type="text" maxlength="4" name="phone_tail" value=${dto.phone_tail }>
								<c:if test="${dto.sms=='예'}">
									<input type="radio" name="sms" value="예" id="sms_submit" checked> 
									<label for="sms_submit">문자수신 동의</label>
									<input type="radio" name="sms" value="아니오" id="sms_nosubmit"> 
									<label for="sms_nosubmit">비동의</label>
								</c:if>
								<c:if test="${dto.sms=='아니오'}">
									<input type="radio" name="sms" value="예" id="sms_submit" > 
									<label for="sms_submit">문자수신 동의</label>
									<input type="radio" name="sms" value="아니오" id="sms_nosubmit" checked> 
									<label for="sms_nosubmit">비동의</label>
								</c:if>
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
								<input type="text" name="email_head" id="email_head" value=${dto.email_head }>
								@ 
								<input type="text" name="email_tail" id="email_tail" value=${dto.email_tail }>
								<select onchange="document.getElementById('email_tail').value = this.options[this.selectedIndex].value">
									<option value="">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="empal.com">empal.com</option>
									<option value="daum.net">daum.net</option>
								</select>
								<c:if test="${dto.news=='예' }"> 
									<input type="radio" name="news" id="email_agree" value="예" checked>
									<label for="email_agree">이메일 수신 동의</label>
									<input type="radio" name="news" id="email_agree" value="아니오">
									<label for="email_agree">비동의</label>
								</c:if>
								<c:if test="${dto.news=='아니오' }"> 
									<input type="radio" name="news" id="email_agree" value="예" >
									<label for="email_agree">이메일 수신 동의</label>
									<input type="radio" name="news" id="email_agree" value="아니오" checked>
									<label for="email_agree">비동의</label>
								</c:if>
								</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
							<input type="text" name="add_num" id="add_num"> 
							<a class="dople" id="add_search" href="#" onclick="daumPostcode()">
								<img alt="체크" src="img/icon_dopel.png">
								우편번호
							</a> <br> 
							<input type="text" name="address" id="rail_add" placeholder="도로명 주소" value="${dto.address}">
							
							<input type="text" name="normal_add" id="normal_add" placeholder="지번주소"><br>
							
							<input type="text" name="detail_add" id="detail_add" placeholder="상세주소"> 
							
							<input type="text" name="desc_add" id="desc_add" placeholder="참고항목">
							</td>
						</tr>
						
					</table>
				<!-- 아래버튼부분 -->
					<div id="submit">
						<button type="submit">
							<img alt="" src="">저장하기
						</button>
						<button type="reset" onclick="javascript:location.href='index.jsp'">
							<img alt="" src="">취소
						</button>
					</div>
				</div>
			</form>
	
		</section>
		<jsp:include page="common/footer.jsp"/>
	</body>
</html>