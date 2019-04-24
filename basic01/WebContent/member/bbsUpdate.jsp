<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
		label {
			display : block; /* 새 라인에서 시작 */
			padding : 5px;
		}
		label span {
			display : inline-block;
			width : 90px;
			text-align : right;
			padding : 10px;
		}
</style>
</head>
<body>
<%
	//request.setCharacterEncoding("UTF-8");
	BbsDTO modify = (BbsDTO) request.getAttribute("modify");
%>
	<h3>작성 글 수정</h3>
	<hr>
	<form name="updateForm" action="BbsProcServlet?action=execute" method=post>
		<input type="hidden" id="id" name="id" value="<%=modify.getId()%>">
		<label><span>아이디:</span><%=modify.getMemberId()%></label>
		<label><span>작성자:</span><%=modify.getName()%></label>
		<label><span>제목:</span>
			<input type="text" name="title" value="<%=modify.getTitle()%>" size="30"></label>
		<label><span>내용:</span>
			<textarea name="content" value="<%=modify.getContent()%>" style="height:250px; width:400px"></textarea></label>	
			<br>
		<span></span><input type="submit" value="수정" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2">
	</form>
			<button onclick="location.href='bbsMain.jsp'">수정 취소</button>
</body>
</html>