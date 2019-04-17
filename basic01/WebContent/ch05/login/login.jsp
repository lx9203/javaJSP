<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input[type=text] { /* text 창에만 적용 */
	color: red;
}

input:hover, textarea:hover, button:hover { /* 마우스 올라 올 때 */
	background: aliceblue;
}

input[type=text]:focus, input[type=password]:focus { /* 포커스 받을 때 */
	font-size: 120%;
}

label {
	display: block; /* 새 라인에서 시작 */
	padding: 5px;
}

label span {
	display: inline-block;
	width: 90px;
	text-align: right;
	padding: 10px;
}
</style>
</head>
<body bgcolor="LavenderBlush">
	<%
		String error = request.getParameter("error");
		System.out.println(error);
		if (error != null) {
			out.println("<script>alert('" + error + "')</script>");
		}
	%>
	<center>
		<br>
		<h3>Member Login</h3>
		<br>
		<hr>
		<br>
		<form name="loginForm" action=/jspbook/ch05/loginProc.jsp method=post>
			<table bgcolor="LavenderBlush">
				<tr><td ><span>ID : </span></td> 
					<td colspan="3"><input type="text" name="id" size="28"></td></tr>
				<tr><td><span>Password : </span></td> 
					<td colspan="3"><input type="password" name="password" size="28"></td></tr>
				<tr>
					<td><span></span></td>
					<td><label><input type="submit" value="로그인" name="B1"></label></td>
					<td><label><input type="reset" value="다시입력" name="B2"></label></td>
					<td><button onclick="location.href='register.html'">회원가입</button></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>