<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="member.*" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	List<BbsDTO> list = (List<BbsDTO>) request.getAttribute("modify");
	//modify = id, memberId, title, date, content, name
	
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>게시물</h3>
	
	<%-- <%= session.getAttribute("memberName") %> 회원님 반갑습니다. --%>
	${ memberName } 회원님 반갑습니다.<br>
	<hr>
	<table border="1" style="border-collapse:collapse;">
	<tr bgcolor="pink"><th>글 번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>액션</th></tr>
	<c:set var="list" value="${requestScope.modify}" />
	<%-- <%
	for (BbsDTO bbs: list) {
	%> --%>
	<c:forEach var="bbs" items="${list }">
		<tr><td>${bbs.id }</td>
		<td><a href="BbsProcServlet?action=view&id=${bbs.id}">${bbs.title}</a></td>
		<td>${bbs.name }</td>
		<td>${bbs.date}</td>
		<td>&nbsp;<button onclick="location.href='BbsProcServlet?action=update&id=${bbs.id}'">수정</button>&nbsp;
			<button onclick="location.href='BbsProcServlet?action=delete&id=${bbs.id}'">삭제</button>&nbsp;</td></tr>
	<%-- <%
	}
	%> --%>
	</c:forEach>
	</table>
	<p>
	<table>
	<tr>
		<td><button onclick="location.href='board.html'">글작성</button></td>
		<td><button onclick="location.href='bbsSearch.jsp'">검색</button></td>
	</tr>
	</table>
	<button onclick="location.href='loginMain.jsp'">돌아가기</button>
	</center>
</body>
</html>