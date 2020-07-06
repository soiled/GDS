<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css"/>
<title>注册</title>
</head>
<body>
<%if(session.getAttribute("login_flag")=="1") response.sendRedirect("ArkNights.jsp"); %>
<div class="login_head">
<div class="login_icon" align="right">
<a href="ArkNights.jsp">首页</a>
</div>
</div>
<div align="center" class="sbg">
<form action="SignupServlet" method="post" >
注册 
<table>
	<tr>
		<td> username<br><input type="text" name="username"></td>
	</tr>
	<tr>
		<td> password<br><input type="password" name="password"></td>
		<td><a href="login.jsp">登录</a></td>
	</tr>
	<tr>
		<td><input type="submit" value="注册" ></td>
		<td><input type="reset" value="重置" ></td>
	</tr>
</table>
${msg}
</form>
</div>
</body>
</html>