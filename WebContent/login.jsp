<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="bean.Identity" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/log.css">
<script type="text/javascript" src="./js/common.js"></script>
<body>

<a href="index.jsp">返回首页</a>
	<div class="main">
	<div class="title">登录</div>
		<hr>
		<br>
		<br>
	<form action="${pageContext.request.contextPath}/Login" method="post" accept-charset="UTF-8">
		<div class="formrow">
			<div class="rowtitle">用户名：</div>
			<div class="rowinput">
				<input type="text" name="username" required="required"/>
			</div>
		</div>
		<div class="formrow">
		<div class="rowtitle">密码：</div>
			<div class="rowinput">
				<input type="password" name="password" required="required"/>
			</div>
		</div>
		<div class="formbuton">
		<button type="submit" >提交</button>
		<button type="reset" >重置</button>
		</div>
		<div class="formlast">
		<a href="${pageContext.request.contextPath}/Logon">还没有注册？立即注册</a>
		</div>
		
	</form>
	
	
	</div>
	
	<%@ include file="footer.html" %>
</body>
</html>
