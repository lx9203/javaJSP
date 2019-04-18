<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("id"));
	String password = request.getParameter("password");
	
	MemberDAO mDao = new MemberDAO();
	int result = mDao.verifyIDPassword(id, password);
	String errorMessage = null;
	switch (result) {
	case MemberDAO.ID_PASSWORD_MATCH:
		break;
	case MemberDAO.ID_DOES_NOT_EXIST:
		errorMessage = "ID가 없음";
		break;
	case MemberDAO.PASSWORD_IS_WRONG:
		errorMessage = "패스워드가 틀렸음";
		break;
	case MemberDAO.DATABASE_ERROR:
		errorMessage = "DB 오류";
	}
	mDao.close();
%>
<!DOCTYPE html>
<html>
<head>
<title>title</title>
</head>
<body>
	if(result == MemberDAO.ID_PASSWORD_MATCH){
		response.sendRedirect("login_main.jsp");
	} else {
		String url = "login.jsp?error=" + errorMessage;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

//	<jsp:forward page="login.jsp">
//		<jsp:param name="error" value="<%=errorMessage%>" />
//	</jsp:forward>

</body>
</html>