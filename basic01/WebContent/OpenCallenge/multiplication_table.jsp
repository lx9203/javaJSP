<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단</title>
</head>
<body>
	<h2>구구단</h2>
	<hr>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightpink">
			<td>X</td>
			<%
				for (int i = 3; i < 10; i = i + 2) {
			%>
			<td><%=i%></td>
			<%
				}
			%>
		</tr>
		<%
			for (int i = 3; i < 10; i = i + 2) {
		%>
		<tr align="center" >
			<td bgcolor="lightpink"><%=i%></td>
			<%
				for (int j = 3; j < 10; j = j + 2) {
			%>
			<td bgcolor="mistyrose"><%=i * j%></td>
			<%
				}
				}
			%>
		</tr>


	</table>
</body>
</html>