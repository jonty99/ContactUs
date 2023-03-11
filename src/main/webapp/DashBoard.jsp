<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("Username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>


	In dashboard page


	<form action="logout" method="post">
		<button type="submit">Logout</button>
	</form>
</body>
</html>