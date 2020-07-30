/**
 * 
 */

function login_check(){
	//유효성 
	//id 대소문자 가능
	//pw 대문자 소문자 특수문자 가능
	
	var id_ch=/^[a-zA-Z]{2,16}$/;
	var pw_ch=/^(?=.[a-zA-Z])(?=.[!@#$%^&*()_+|<>?])*$/;
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