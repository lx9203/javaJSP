<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
고전방식
<br>
<%
int num1 = (Integer)request.getAttribute("num1");
int num2 = (Integer)request.getAttribute("num2");
%>
<%=num1 %> + <%=num2 %> = <%= num1 + num2 %>
<br>
<br>
EL 방식
<br>
${num1 }+${num2 }=${add}
</body>
</html>