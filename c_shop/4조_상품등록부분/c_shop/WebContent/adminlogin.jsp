<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<c:if test="${admin_id!=null }">
		<script type="text/javascript">
			window.location.href="admin_main.jsp";
		</script>
	</c:if>
	<head>
		<meta charset="UTF-8">
		<link type="stylesheet" >
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/admin_login.css">
	</head>
	<body>
		<form action="admin_login.do?auth=1" name="l_from" method="post">
			<section>
				<h1>admin Login</h1>
				<div>
					<h1><span>CooKit</span> System</h1>
					<div id="login_div">
						<ul>
							<li id="img_div"></li>
							<li id="input_div">
								<label><input type="text" name="admin_id" maxlength="20" placeholder="id" ></label><br>
								<label><input type="password" name="admin_pw" maxlength="20" placeholder="pw"></label><br>
							</li>
							<li id="btn_div">
								<button type="submit">Login</button>
							</li>
						
						</ul>
					</div>
				</div>
			</section>
		</form>
	</body>
</html>