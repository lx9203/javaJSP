<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<h2>환영합니다. 
	<c:if test="${param.userType == 1 }">
		<span>사용자</span>
	</c:if>
	<c:if test="${param.userType == 2 }">
		<c:choose>
			<c:when test="${param.id == 'root' && param.password == '1234' }">관리자</c:when>
			<c:when test="${param.id == 'root' && param.password != '1234' }"><c:redirect url="login.jsp"></c:redirect></c:when>
		</c:choose>
	</c:if> 
	님</h2>
</body>
</html>