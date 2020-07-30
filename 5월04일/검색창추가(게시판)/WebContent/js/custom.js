/**
 * 
 */

function check(){
	if(agree.f_agree.value!='agree'){
		alert('필수 이용약관 미동의하였습니다');
		agree.f_agree.focus();
		return false;
	}
	if(agree.s_agree.value!='agree'){
		alert('필수 이용약관 미동의하였습니다');
		agree.f_agree.focus();
		return false;
	}
	if(agree.t_agree.value!='agree'){
		alert('필수 이용약관 미동의하였습니다');
		agree.f_agree.focus();
		return false;
	}
	return agree.submit();
}