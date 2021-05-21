<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户编辑</title>
	
	<style>
		.row{
			margin: 10px;
			
		}
	
	</style>
</head>

<body>
<c:if test="${requestScope.type == 1}">
<h1>用户编辑</h1>
<form action="${pageContext.request.contextPath}/Admin?type=1" method="post" accept-charset="UTF-8">
<div class="row"><label>用户ID：</label><input type="text" name="uid" value="${requestScope.user.uid }" readonly="readonly"></div>
<div class="row"><label>用户名：</label><input type="text" name="username" value="${requestScope.user.username }"></div>
	<div class="row"><label>&nbsp;&nbsp;&nbsp;密码：</label><input type="password" name="password" value="${requestScope.user.password }"></div>
	
</c:if>


<c:if test="${requestScope.type == 2}">
<h1>新增用户</h1>
<form action="${pageContext.request.contextPath}/Admin?type=2" method="post">
<div class="row"><label>用户名：</label><input type="text" name="username" value=""></div>
	<div class="row"><label>&nbsp;&nbsp;&nbsp;密码：</label><input type="password" name="password" value=""></div>
	
	
</c:if>

<c:if test="${ identity.isRoot()}">
	<div class="row"><label>用户身份：</label>
	<select name="status">
	<option value="1">用户</option>
	<option value="2">管理员</option>
	</select>
	</div></c:if>
	<c:if test="${identity.status==2}">
	<input type="hidden" name="status" value="1"></input> 
	</c:if>
	<div class="row"><button type="submit" style="margin-left: 50px;">提交</button>
	<button type="reset" style="margin-left: 50px;">重置</button></div>
</form>
	
	
</body>
</html>
