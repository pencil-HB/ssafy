<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvc.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u = (User) session.getAttribute("user");
		if(u == null){
	%>
	<a href="loginForm">로그인</a>			
	<%} else {%>
	<%= u.getId() %>님, 환영합니다!
	<a href="logout">로그아웃</a>
	<% } %>
</body>
</html>	