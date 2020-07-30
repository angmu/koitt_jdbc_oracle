<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
	  <title>상품등록</title>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/write.css">
	  <script type="text/javascript" src="js/check.js"></script>
	  <jsp:include page="common/config.jsp" />
	  <script type="text/javascript">
		  $(document).ready(function() {
				$("#newfile1").change(function() {
					$('#file1').val($('#newfile1').val());
				});
				
				$("#newfile2").change(function() {
					$('#file2').val($('#newfile2').val());
				});
				
				$("#newfile3").change(function() {
					$('#file3').val($('#newfile3').val());
				});
		  });
		  
		  function deletecheck(){
		  		var result=confirm("정말로 삭제하시겠습니까?\n 삭제시 복구가 어렵습니다.");
		  		if(result==true){
		  			window.location.href='pdelete.do?pId=${pcon.pId}';
		  		}else{
		  			alert("삭제취소");
		  		}
		    }
	  </script>
	</head>
	<body>
	  <jsp:include page="common/admin_top-nav.jsp" />
	  <section>
	    <h1>상품수정</h1>
	    <hr>
	    <form action="pmodify.do" name="pmodify" method="post"  onsubmit="return writeCheck()" enctype="multipart/form-data">
	      <table>
	        <colgroup>
	          <col width="20%">
	          <col width="30%">
	          <col width="20%">
	          <col width="30%">
	        </colgroup>
	        
	        <tr>
	          <input type="hidden" name="pId" value="${pcon.pId}">
	          <th>상품명  ${pcon.pId} </th>
	          <td>
	            <input type="text" name="pName" id="pName" value="${pcon.pName}">
	          </td>
	          
	          <th>상품가격</th>
	          <td>
	            <input type="text" name="pPrice" id="pPrice" value="${pcon.pPrice}">
	          </td>
	        </tr>
	        
	        <tr>
	          <th>배송비 지정</th>
	          <td>
	            <select name="pDelivery" id="pDelivery">
	            	<option value="${pcon.pDelivery}">${pcon.pDelivery}원</option>
	            	<option value="2500">2,500원</option>
	            	<option value="3000">3,000원</option>
	            	<option value="3500">3,500원</option>
	            </select>
	          </td>
	          
	          <th>카테고리</th>
	          <td>
	            <select name="pCategory" id="pCategory">
	            	<option value="${pcon.pCategory }">${pcon.pCategory }</option>
	            	<option value="신선식품">신선식품</option>
	            	<option value="냉동식품">냉동식품</option>
	            	<option value="즉석식품">즉석식품</option>
	            </select>
	          </td>
	        </tr>
	        
	        <tr>
	          <th>용량</th>
	          <td>
	            <select name="pAmount" id="pAmount">
	            	<option value="${pcon.pAmount}">${pcon.pAmount}인분</option>
	            	<option value="1">1인분</option>
	            	<option value="2">2인분</option>
	            	<option value="3">3인분</option>
	            	<option value="4">4인분</option>
	            	<option value="5">5인분</option>
	            </select>
	          </td>
	          
	          <th>조리시간(분)</th>
	          <td>
	            <input type="text" name="pTime" id="pTime" value="${pcon.pTime}">
	          </td>
	        </tr>
	        
	        <tr>
	        	<th>제품설명</th>
	        	<td colspan="3">
	        		<textarea name="pContent" cols="50" rows="10">${pcon.pContent}</textarea> 
	        </tr>
	        
	        <tr>
	          <th colspan="1">썸네일 파일(크기제한:200*400px)</th>
	          <td colspan="1">
	            <label for="newfile1">파일 선택</label>
	            <input type="file" name="pTitleimg" id="newfile1" class="oldfile">
	            <input type="text" name="newfile1" id="file1" value="${pcon.pTitleimg }" readonly >
	          </td>
	        </tr>
	        
	        <tr>
	          <th colspan="1">본문이미지 파일1</th>
	          <td colspan="1">
	            <label for="newfile2">파일 선택</label>
	            <input type="file" name="pContentimg1" id="newfile2" class="oldfile">
	            <input type="text" name="newfile2" id="file2" value="${pcon.pContentimg1 }" readonly >
	          </td>
	        </tr>
	        
	        <tr>
	          <th colspan="1">본문이미지 파일2</th>
	          <td colspan="1">
	            <label for="newfile3">파일 선택</label>
	            <input type="file" name="pContentimg2" id="newfile3" class="oldfile">
	            <input type="text" name="newfile3" id="file3" value="${pcon.pContentimg2 }" readonly >
	          </td>
	        </tr>
	        
	      </table>
	      <hr>
	      <div class="button-wrapper-plus">
	        <button type="submit" class="write">작성완료</button>
	        <button onclick="deletecheck()" class="write">삭제</button>
	        <button type="reset" onclick="javascript:window.location.href='admin_plist.do'" class="cancel">취소</button>
	      </div>
	    </form>
	  </section>
	</body>
</html>