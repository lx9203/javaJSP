<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="member" value="<%=new com.saeyan.javabean.MemberBeans()%>">
</c:set>
<c:set target="${member}" property="name" value="이병일"></c:set>
<c:set target="${member}" property="userId" >lbi5320</c:set>
\${member} = ${member }<br>
</body>
</html>