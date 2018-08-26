<%-- <%@page import="com.vuln.webapp.db.User"%> --%>
<%-- <%@ page language="java" contentType="text/html; charset=US-ASCII" --%>
<%--     pageEncoding="US-ASCII"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII"> -->
<!-- <title>Home Page</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- <%User user = (User) session.getAttribute("User"); %> --%>
<%-- <h3>Hi <%=user.getName() %></h3> --%>
<%-- <strong>Your Email</strong>: <%=user.getEmail() %><br> --%>
<%-- <strong>Your Country</strong>: <%=user.getCountry() %><br> --%>
<!-- <br> -->
<!-- <form action="Logout" method="post"> -->
<!-- <input type="submit" value="Logout" > -->
<!-- </form> -->
<!-- </body> -->
<!-- </html> -->
<%@page import="com.vuln.webapp.db.User"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Hybrid Security Solutions Inc.</h1>
	</div>
	<h3>
		Hi
		<%
		User user = (User) session.getAttribute("User");
		Cookie[] cookies = request.getCookies();
		String sessionId = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if (cookie.getName().equals("JSESSIONID")) {
					sessionId = cookie.getValue();
					//break;
				}
			}
		}
	%>
		<%=user%>, Login successful. Your Session ID=<%=sessionId%></h3>
	<br>
	<br>
	<a href="CheckoutPage.jsp">Checkout Page</a>
	<br>
	<a href="file.html">File Download and Upload</a>
	<br>
	<a href="blog.html">My Blog</a>
	<form action="Logout" method="post">
		<input type="submit" value="Logout">
	</form>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
