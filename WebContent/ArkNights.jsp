<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/arknights.css">
<meta charset="UTF-8">
<title>ArkNights</title>
</head>
<body>
	<%--头 --%>
	<div class="login_head">
		<div class="users_information">
			<%
				if (request.getSession(false) == null || session.getAttribute("login_flag") == null) {
			%>

			<div>
				<div align="right">
					<span class="the_span"> <a href="login.jsp">登录</a>
					</span>
				</div>
			</div>
			<%
				} else if (session.getAttribute("login_flag") != null && session.getAttribute("login_flag").equals("1")) {
			%>
			<table>
				<tr>
					<td>${uname}</td>
					<td><a href="ActionServlet?myroom">个人中心</a>
					<td><a href="LoginServlet?action=exit">退出</a></td>
				</tr>
			</table>
			<%
				}
			%>

		</div>
	</div>

	<%--主要的模块 --%>
	<div class="main">
		<div>
			<form action="ActionServlet?draw" method="post">
				<input type="submit" name="draws" value="单抽"> <input
					type="submit" name="draws" value="十连">
			</form>
		</div>
		<div>	
			<%!int i = 1;%>
			<table>
			<tr>
			<td>序号</td>
			<td>名字</td>
			<td>信息</td>
			<td>图片</td>
			</tr>
			<c:forEach items="${drole}" var="drawrole">
				<tr>
					<td>
						<%
							out.print(i);
								i = i + 1;
						%>
					</td>
					<td>${drawrole.roleName}</td>
					<td>${drawrole.roleInformation}</</td>
					<td><a href="${drawrole.rolePitcture}">图片</a></td>
				</tr>
			</c:forEach>
		</table>		
		</div>
	</div>
</body>
</html>