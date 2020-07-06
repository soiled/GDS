<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<%if(request.getSession(false)==null||session.getAttribute("admin")==null){%>
<div align="center">
<form action="AdminServlet" method="post">
<input type="password" name="admin">
<input type="submit" name="login">
</form>
${msg }
<a href="ArkNights.jsp">首页</a>
</div>
<%}else if(session.getAttribute("admin")!=null&&session.getAttribute("admin").equals("1"))
			response.sendRedirect("adminmain.jsp");%>
</body>
</html>