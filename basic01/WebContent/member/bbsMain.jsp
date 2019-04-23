<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="member.*" %> 
<%
	BbsDAO bDao = new BbsDAO();
	List<BbsDTO> list = bDao.ViewData();
	bDao.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>게시물</h3>
	<hr>
	<table border="1" style="border-collapse:collapse;">
	<tr bgcolor="pink"><th>글 번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>액션</th></tr>
	<%
	for (BbsDTO bbs: list) {
	%>
		<tr><td><%=bbs.getId()%></td>
		<td><%=bbs.getTitle()%></td>
		<td><%=bbs.getName()%></td>
		<td><%=bbs.getDate()%></td>
		<%
			String updateUri = "BbsProcServlet?action=update&id=" + bbs.getId();
			String deleteUri = "BbsProcServlet?action=delete&id=" + bbs.getId();
		%>
		<td>&nbsp;<button onclick="location.href='<%=updateUri%>'">수정</button>&nbsp;
			<button onclick="location.href='<%=deleteUri%>'">삭제</button>&nbsp;</td></tr>
	<%
	}
	%>
	
	</table>
	<button onclick="location.href='board.html'">글작성</button>
	</center>
</body>
</html>