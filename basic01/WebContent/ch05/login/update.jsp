<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 수정</title>
<style>
input[type=text] { /* text 창에만 적용 */
	color: red;
}
input:hover, textarea:hover, button:hover { /* 마우스 올라 올 때 */
	background: aliceblue;
}
input[type=text]:focus, input[type=password]:focus { /* 포커스 받을 때 */
	font-size: 100%;
}
label span {
	align : center;
	display: inline-block;
	width: 90px;
	text-align: right;
	padding: 10px;
}
</style>
</head>
<body>
<%
	MemberDTO member = (MemberDTO) request.getAttribute("member");
%>
	<h3>회원 수정</h3>
	<hr>
	<form name="registerForm"
		action=/jspbook/ch05/login/updateMemberServlet method=post>
			<input type="hidden" id="id" name="id" value="<%=member.getId()%>">
			<label><span>아이디 : </span><%=member.getId() %></label>
			<label><span>이름 : </span><input type="text" value="<%=member.getName()%>" name="name" size="10"></label>
			<label><span>생일 : </span><input type="text" value="<%=member.getBirthday()%>" name="birthday" size="10"></label>
			<label>	<span>주소 : </span><input type="text" value="<%=member.getAddress()%>" name="address" size="20"></label>
			<label><span></span>
				<input type="submit" value="회원수정" name="B1">&nbsp;&nbsp; 
				<input type="reset" value="재작성" name="B2">
			</label>
	</form>
</body>
</html>