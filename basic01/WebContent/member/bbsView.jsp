<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, member.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	BbsMember bm = (BbsMember)request.getAttribute("bbsMember");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
<style>
		th { text-align: center; }
		td { padding-left: 5px; }
		.button {
			font-weight: bold; font-size: 9pt;
			border: 1px solid powderblue;
		}
		input[type=submit] {
			width: 5em; height: 2.5em;
			font-weight: bold; font-size: 10pt;
		}
	</style>
</head>
<body>
	<center>
		<h3>게시글 상세보기</h3>
		<hr>
		<c:set var="bm" value="${requestScope.bbsMember}" />
		<table border="1" style="border-collapse:collapse;" width="500">
			<tr bgcolor="pink"><th>항목</th><th>내용</th></tr>
			<tr><td style="text-align:center;">글번호</td><td>${bm.id}</td></tr>
			<tr><td style="text-align:center;">제목</td><td>${bm.title}</td></tr>
			<tr><td style="text-align:center;">글쓴이</td><td>${bm.name}</td></tr>
			<tr><td style="text-align:center;">수정일</td><td>${bm.date}</td></tr>
			<tr height="300"><td style="text-align:center;">내용</td><td>${bm.content}</td></tr>
		</table>
	<br>
	<%-- <%
		String updateUri = "BbsProcServlet?action=update&id=${bm.id}";
		String deleteUri = "BbsProcServlet?action=delete&id=${bm.id}";
	%> --%>
	<button onclick="location.href='BbsProcServlet?action=update&id=${bm.id}'">수정</button>
	<button onclick="location.href='BbsProcServlet?action=delete&id=${bm.id}'">삭제</button>
	<button onclick="location.href='BbsProcServlet?action=bbsJoin'">돌아가기</button>
	<!-- <a href="BbsProcServlet?action=list&page=1">목록으로</a> -->
	</center>
</body>
</html>