<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.gds.entity.Role"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${uname}</title>
</head>
<body>
	<div>
		<div>
			你的名字：${uname} <a href="ArkNights.jsp">返回首页</a>
		</div>


		<%--role信息块 --%>
		<div>
			<table>
				<tr>
					<td>数字</td>
					<td>角色名</td>
					<td>角色信息</td>
					<td>角色图片</td>
					<td>星星数量</td>
				</tr>
				<%!int i = 1;%>
				<c:forEach items="${urole}" var="userrole">
					<tr>
						<td>
							<%
								out.print(i);
									i = i + 1;
							%>
						</td>
						<td>${userrole.roleName}</td>
						<td>${userrole.roleInformation}</</td>
						<td><a href="${userrole.rolePitcture}">图片</a></td>
						<td>${userrole.roleLevel}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>