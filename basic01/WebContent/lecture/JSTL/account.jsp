<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이용해 주셔서 감사합니다.</h2>
<hr>
<%
request.setCharacterEncoding("utf-8");
int sum = 0;
int a = 1000;
int b = 200000;
int c = 50000;

String[] product = request.getParameterValues("product");
out.println("당신이 선택한 물품 : ");
for(String p : product){
	int n = Integer.parseInt(p);
	switch(n){
	case 1: 
		out.print("모자 ");
	break;
	case 2: 
		out.print("텔레비전 ");
	break;
	case 3: 
		out.print("신발 ");
	break;
	}
}
out.println("<br>");
out.println("당신이 지불할 금액 : ");
for(String p : product){
	int n = Integer.parseInt(p);
	switch(n){
	case 1: 
		sum += a;
	break;
	case 2: 
		sum += b;
	break;
	case 3:  
		sum += c;
	break;
	}
}
out.println(sum);
%>
</body>
</html>