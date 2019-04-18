<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.*"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" scope="page" class="member.MemberDTO"></jsp:useBean>
<jsp:setProperty name="member" property="*" />
<%
	MemberDAO mDao = new MemberDAO();
	mDao.insertMember(member);
	mDao.close();
	response.sendRedirect("login_main.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입완료</title>
</head>
<body>
	<h2>회원 가입이 완료되었습니다</h2>
	<hr>
</body>
</html>