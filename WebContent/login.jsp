<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css" />
<title>登录</title>
</head>
<body>
	<%
		if (session.getAttribute("login_flag") == "1")
			response.sendRedirect("ArkNights.jsp");
	%>
	<div class="login_bg">
		<div class="login_head">
			<div class="login_icon" align="center">
				<a href="ArkNights.jsp"><img src="img/ark.jpg"></a>
			</div>
		</div>
		<div class="login" align="center">
			<div class="login_main">
				<form action="LoginServlet" method="post">
					登录
					<table>
						<tr>
							<td>username<br>
							<input type="text" name="username"></td>

						</tr>
						<tr>
							<td>password<br>
							<input type="password" name="password"></td>
							<td><a href="signup.jsp">注册</a></td>
							<td><a href="ArkNights.jsp">找回密码</a></td>
						</tr>
						<tr>
							<td><input type="submit" value="登录"></td>
							<td><input type="reset" value="重置"></td>
						</tr>
					</table>
					${msg}
				</form>

			</div>
		</div>
		<!-- <div class="login_foot">
&copy;达达
</div> -->
	</div>
</body>
</html>