function id_check(){
	window.open("join_idcheck.jsp","id_check",
	"width=600px,height=400px,resizable=no,scrollbars=no");
}



function all_check(){
	var pw_check=(/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@\#$%<>^&*]).{5,16}$/);
	var name_kor_check=/^[가-힣]{1,}$/;
	var tel_check=/^[0-9]{3,}$/;
	var email_check=/^[0-9a-zA-Z]{1,}$/;
	var email_check2=/^[0-9a-zA-Z]+?\.[a-z]{1,}$/;
	
	if(info_form.id.value==null){
		alert("아이디를 입력해 주세요.");
		info_form.id.focus();
		return false;
	}
	
	if(!(pw_check.test(info_form.pw.value))){
		alert("비밀번호를 다시 입력해 주세요.");
		info_form.pw.value="";
		info_form.pw.focus();
		return false;
	}
	
	if(info_form.pw.value!=info_form.pw_check.value){
		alert("비밀번호가 맞지 않습니다.");
		info_form.stu_pw_check.value="";
		info_form.stu_pw_check.focus();
		return false;
	}
	
	if(!(name_kor_check.test(info_form.name.value))){
		alert("이름을 다시 입력해 주세요.");
		info_form.name.value="";
		info_form.name.focus();
		return false;
	}
	if(info_form.birth.value==""){
		alert("생년월일을 입력해 주세요.");
		return false;
	}
	
	if(!(tel_check.test(info_form.phone_mid.value))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.phone_mid.value="";
		info_form.phone_mid.focus();
		return false;
	}
	if(!(tel_check.test(info_form.phone_tail.value))){
		alert("전화번호를 다시 입력해 주세요.");
		info_form.phone_tail.value="";
		info_form.phone_tail.focus();
		return false;
	}
	if(!(email_check.test(info_form.email_head.value))){
		alert("이메일을 다시 입력해 주세요.");
		info_form.email_head.value="";
		info_form.email_head.focus();
		return false;
	}
	if(!(email_check2.test(info_form.email_tail.value))){
		alert("이메일을 다시 입력해 주세요.");
		info_form.email_tail.value="";
		info_form.email_tail.focus();
		return false;
	}
	
	if(info_form.address.value==""){
		alert("주소를 입력해 주세요.");
		info_form.address.focus();
		return false;
	}
	
	
	return true;
	
	
}

function modify_check(){
	var name_kor_check=/^[가-힣]{1,}$/;
	var tel_check=/^[0-9]{3,}$/;
	var email_check=/^[0-9a-zA-Z]{1,}$/;
	var email_check2=/^[0-9a-zA-Z]+?\.[a-z]{1,}$/;
	
	if(!(name_kor_check.test(modify_form.name.value))){
		alert("이름을 다시 입력해 주세요.");
		modify_form.name.value="";
		modify_form.name.focus();
		return false;
	}
	if(modify_form.birth.value==""){
		alert("생년월일을 입력해 주세요.");
		return false;
	}
	
	if(!(tel_check.test(modify_form.phone_mid.value))){
		alert("전화번호를 다시 입력해 주세요.");
		modify_form.phone_mid.value="";
		modify_form.phone_mid.focus();
		return false;
	}
	if(!(tel_check.test(modify_form.phone_tail.value))){
		alert("전화번호를 다시 입력해 주세요.");
		modify_form.phone_tail.value="";
		modify_form.phone_tail.focus();
		return false;
	}
	if(!(email_check.test(modify_form.email_head.value))){
		alert("이메일을 다시 입력해 주세요.");
		modify_form.email_head.value="";
		modify_form.email_head.focus();
		return false;
	}
	if(!(email_check2.test(modify_form.email_tail.value))){
		alert("이메일을 다시 입력해 주세요.");
		modify_form.email_tail.value="";
		modify_form.email_tail.focus();
		return false;
	}
	
	if(modify_form.address.value==""){
		alert("주소를 입력해 주세요.");
		modify_form.address.focus();
		return false;
	}
	
	
	return true;
}
