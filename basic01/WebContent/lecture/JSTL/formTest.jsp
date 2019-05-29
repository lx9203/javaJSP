<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설 문 조 사</title>
</head>
<body>
<h2>설 문 조 사</h2>
<form method=post action="a.jsp">
	<table>
			<tr>
				<td>이름 : </td><td colspan=3><input type=text name=name></td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td><label><input type = "radio" name = "gender" value = "male" checked = "checked"> 남자</label></td>
			    <td><label><input type = "radio" name = "gender" value = "female"> 여자</label></td>
			    <td></td>
			</tr>
			<tr>
				<td>좋아하는것 : </td>
				<td><input type = "checkbox" name = "hobby" value="1">노래</td>
				<td><input type = "checkbox" name = "hobby" value="2">게임</td>
				<td><input type = "checkbox" name = "hobby" value="3">운동</td>
			</tr>
			<tr>
				<td colspan=4><input type="submit" value="제출" ></td>
			</tr>
	</table>
</form>

</body>
</html>