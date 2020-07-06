<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<%
		if (request.getSession(false) == null || session.getAttribute("admin") == null) {
			response.sendRedirect("admin.jsp");
		}
	%>
	<table>

	</table>
</body>
</html>