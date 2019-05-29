<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="main.jsp">
		<table>
			<tr>
				<td>아이디 :</td>
				<td colspan="3"><input type=text name=id></td>
				
			</tr>
			<tr>
				<td>암호 : </td>
				<td colspan="3"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>타입 :</td>
				<td><label><input type="radio" name="userType"	value="1" checked="checked">사용자</label></td>
				<td><label><input type="radio" name="userType"	value="2">관리자</label></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
</body>
</html>