<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter</title>
</head>
<body>
	<div align = center>
		<h3>My Simple Twitter!!</h3>
		<a href="loginMain.jsp">회원 목록으로</a>
		<hr>
		<form action ="/jspbook/member/twitServlet" method = "POST">
			${ memberName }
			<%-- @<%= session.getAttribute("memberName") %> --%>
			<input type = "text" name = "msg">
			<input type = "submit" value = "Tweet">
		</form>
		<hr>
		<div align = "left">
			<ul>
	<%-- <c:set var="msg" value="${applicationScope.msgs}" /> --%>
<%
	ArrayList<String> msgs = (ArrayList<String>) application.getAttribute("msgs");
	if (msgs != null){
		for(String msg : msgs){
			out.println("<LI>" + msg + "</LI>");
		}
	}
%>
			</ul>
		</div>
	</div>
</body>
</html>