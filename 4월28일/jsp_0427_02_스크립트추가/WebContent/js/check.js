/**
 * 
 */
function modify_check(){
	
	if(modify.BTitle.value==""){
		alert('제목을 입력하세오');
		modify.BTitle.focus();
		return false;
	}
	if(modify.BName.value==""){
		alert('이름을 입력하세오');
		modify.BName.focus();
		return false;
	}
	if(modify.BContent.value==""){
		alert('내용을 입력하세오');
		modify.BContent.focus();
		return false;
	}
	return modify.submit();
}


function reply_check(){
	
	if(reply.BTitle.value==""){
		alert('제목을 입력하세오');
		reply.BTitle.focus();
		return false;
	}
	if(reply.BName.value==""){
		alert('이름을 입력하세오');
		reply.BName.focus();
		return false;
	}
	if(reply.BContent.value==""){
		alert('내용을 입력하세오');
		reply.BContent.focus();
		return false;
	}
	return reply.submit();
}



function insert_check(){
	
	if(write.bTitle.value==""){
		alert('제목을 입력하세오');
		write.bTitle.focus();
		return false;
	}
	if(write.bName.value==""){
		alert('이름을 입력하세오');
		write.bName.focus();
		return false;
	}
	if(write.bContent.value==""){
		alert('내용을 입력하세오');
		write.bContent.focus();
		return false;
	}
	return write.submit();
}

function delete_check(bId){
		
		var result=confirm(bId+"데이터를 삭제하시겟습니까?");
		if(result==true){
			alert("삭제합니다");
			window.location.href='delete.do?bId='+bId;
		}else{
			alert("삭제 취소");
		}
}