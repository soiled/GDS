<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <script type="text/javascript">setTimeout("window.location.href = 'ArkNights.jsp'", 3000);</script>
-->
<link rel="stylesheet" href="css/signup.css" />
<title>loading</title>
</head>
<body>
<%if (request.getSession(false)==null||session.getAttribute("login_flag")==null){%>
	<div style="height: 169px;">
	<div  align="right" >
	<span  style="background-color: #ffffff">
	<a href="login.jsp">登录</a>	
	</span>	
	</div>
	</div>
	<% }
	if(session.getAttribute("login_flag")!=null&&session.getAttribute("login_flag").equals("1"))	{
	%>	
	3s后跳转
	<script type="text/javascript">setTimeout("window.location.href = 'ArkNights.jsp'", 3000);</script>
	<%}%>
	<div class="sbg"></div>
</body>
</html>