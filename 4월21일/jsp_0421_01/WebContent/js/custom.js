/**
 * 
 */

function login_check(){
	//유효성 
	//id 대소문자 가능
	//pw 대문자 소문자 특수문자 가능
	
	var id_ch=/^[a-zA-Z]{2,16}$/;
	var pw_ch=/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+|<>?]).{3,16}$/;
	if(login.id.value==""){
		alert('아이디를 입력하세요');
		login.id.focus();
		return false;
	}
	if(!(id_ch.test(login.id.value))){
		alert('아이디가 잘못되었습니다');
		login.id.value="";
		return false;
	}
	if(login.pw.value==""){
		alert('비밀번호를 입력하세요');
		login.pw.focus();
		return false;
	}
//	if(!(pw_ch.test(login.pw.value))){
//		alert('비밀번호가 잘못되었습니다');
//		login.pw.value="";
//		return false;
//	}
	return login.submit();
}


function join_check(){
	var id_ch=/^[a-zA-Z0-9]{3,16}$/;
	var pw_ch=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+|<>?]).{3,16}$/;
	var name_ch=/^[가-힣]*$/;
	if(join.id.value==""){
		alert('아이디를 입력하세요');
		join.id.focus();
		return false;
	}
	if(!(id_ch.test(join.id.value))){
		alert('아이디는 3자리 이상 영문 숫자로만 가능');
		join.id.value="";
		return false;
	}
	if(join.pw.value==""){
		alert('비밀번호를 입력하세요');
		join.pw.focus();
		return false;
	}
	if(!(pw_ch.test(join.pw.value))){
	alert('비밀번호는 영문 숫자 특문 1개이상 들어가야합니다');
	join.pw.value="";
	return false;
	}
	if(join.pw_check.value==""){
		alert('비밀번호확인을 입력하세요');
		join.pw_check.focus();
		return false;
	}
	if(join.pw.value!=join.pw_check.value){
		alert('비밀번호확인과 비밀번호가 일치하지않습니다');
		join.pw_check.value="";
		join.pw_check.focus();
		return false;
	}
	if(join.name.value==""){
		alert('이름를 입력하세요');
		join.name.focus();
		return false;
	}
	if(!(name_ch.test(join.name.value))){
		alert('이름이 잘못되었습니다 국문만 입력가능합니다');
		join.name.value="";
		return false;
	}
	if(join.email.value==""){
		alert('이메일을 입력하세요');
		join.email.focus();
		return false;
	}
	if(join.address.value==""){
		alert('주소를 입력하세요');
		join.address.focus();
		return false;
	}
	
	return join.submit();
}


function update_check(){
	var pw_ch=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+|<>?]).{3,16}$/;
	
	if(update.pw.value==""){
		alert('비밀번호를 입력하세요');
		update.pw.focus();
		return false;
	}
	
	return update.submit();
}

function delete_check(){
	
	var check=confirm("삭제하겠습니까? \n (삭제하시면 데이터 복구가 어렵습니다.)");
	if(check==true){
//		alert("삭제진행");
		location.href='delete.jsp?id='+update.id.value;
	}else{
//	 	수정전으루 바꾸려면 return false로..
		return false;
	}    
	
}