<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store</title>
</head>
<body>
	<H3>물건을 선택하세요</H3>
	<hr>
	<form method=post action="account.jsp">
		<table>
			<tr>
				<td><input type="checkbox" name="product" value="1">모자</td>
				<td><input type="checkbox" name="product" value="2">텔레비전</td>
				<td><input type="checkbox" name="product" value="3">신발</td>
			</tr>
			<tr>
				<td>1000원
				<td>200000원
				<td>50000원
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
</body>
</html>