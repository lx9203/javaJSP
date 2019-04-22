<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	String msg = request.getParameter("msg");
	Object username = session.getAttribute("user");
	if (username == null) {
		out.println("<script>alert('로그인을 하세요')</script>");
		response.sendRedirect("twitter_login.jsp");
	}
	
	ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
	
	if(msgs == null) {
		msgs = new ArrayList<String>();
		application.setAttribute("msgs",msgs);
	}
	msgs.add(username + " :: " + msg + " , " + new java.util.Date());
	application.log(msg + "추가됨");
	response.sendRedirect("twitter_list.jsp");
%>