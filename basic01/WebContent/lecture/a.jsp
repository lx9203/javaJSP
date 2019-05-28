<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String gender = request.getParameter("gender");
String[] hobby = request.getParameterValues("hobby");

if(gender.equals("male")){
	gender="남자";
} else {
	gender="여자";
}

out.println("이름 : "+name+"<br>");
out.println("성별 : "+gender+"<br>");
out.println("취미 : ");
for(String h : hobby){
	int n = Integer.parseInt(h);
	switch(n){
	case 1: out.print("노래 ");
	break;
	case 2: out.print("게임 ");
	break;
	case 3: out.print("운동 ");
	break;
	}
}
%>
<h2>감사합니다.</h2>
</body>
</html>