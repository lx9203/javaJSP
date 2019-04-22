<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selProduct.jsp</title>
</head>
<%
	request.setCharacterEncoding("UTF-8"); // euc-kr
	String username = request.getParameter("username");
	if (username.equals("")) {
		out.println("<script>alert('로그인을 하세요');");
		out.println("history.go(-1);</script>");
	}
	session.setAttribute("username", username);
%>
<body>
<center>
	<h2>상품선택</h2>
	<hr>
	<%=session.getAttribute("username") %>님이 로그인한 상태입니다.
	<hr>
	<form name = "form1" method = "POST" action = "add.jsp">
		<select name = "product">
			<option>사과
			<option>귤
			<option>파인애플
			<option>자몽
			<option>레몬
			<option>딸기
		</select>
		수량: <input type="text" name="quantity" size="4" value="0">
		<input type="submit" value="추가"/>
	</form>
	<a href = "checkOut.jsp">계산</a>
</center>
</body>
</html>