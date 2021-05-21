<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
	<script type="text/javascript">
	function check(){
		var psw=document.getElementsByName("password")[0].value;
		var agapsw=document.getElementsByName("aginpassword")[0].value;
		
		if(psw==agapsw){
			return true;
		}
		else{
			alert("两次输入密码不一致");
			return false;
		}
	}
	
	</script>
</head>
<link rel="stylesheet" type="text/css" href="./css/log.css">
<body>
<a href="${pageContext.request.contextPath }/Main">返回首页</a>
	<div class="main">
	<div class="title">注册</div>
		<hr>
		<br>
		<br>
	<form action="${pageContext.request.contextPath}/Logon" method="post" name="logon" accept-charset="UTF-8">
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
		<div class="formrow">
		<div class="rowtitle">确认密码：</div>
			<div class="rowinput">
				<input type="password" name="aginpassword" required="required" />
			</div>
		</div>
		<div class="formbuton">
		<button type="submit" onclick="return check()">提交</button>
		<button type="reset" >重置</button>
		</div>
		<div class="formlast">
		<a href="${pageContext.request.contextPath}/Login">已有帐号？立即登录</a>
		</div>
		
	</form>
	
	
	</div>
	<%@ include file="footer.html" %>
</body>
</html>