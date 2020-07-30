/**
 * 
 */


//로그인 확인
function login_ch(){
	if(login.id.value==""){
		alert('아이디를 입력하세요');
		login.id.focus();
		return false;
	}
	if(login.pw.value==""){
		alert('비밀번호를 입력하세요');
		login.pw.focus();
		return false;
	}
	
	return login.submit();
}