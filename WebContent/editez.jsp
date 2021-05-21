<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>文章编辑</title>
	<link rel="stylesheet" type="text/css" href="./css/editez.css">
	<script type="text/javascript" src="./js/common.js"></script>
	
</head>
<body>

	<a href="index.jsp">返回首页</a>
		<div class="main">
	<div style="font-size: 60px;
	text-align: center;
	font-family: 黑体;
	margin-top:20px;
	margin-bottom: 20px;" class="headword" >文章编辑</div>
	
	<form action="${pageContext.request.contextPath }/Essay?type=${requestScope.type}" method="post" accept-charset="UTF-8">
	
	<c:if test="${requestScope.type eq 1 }">
	<div class="title">
	<input type="text" required="required" name="title" value="${requestScope.essay.getTitle()}"/>
		</div>
	<div class="author" >作者:<input type="text" required="required" name="author" value="${identity.username}" readonly="readonly"/></div>
		<textarea name="content" class="content" name="content" required="required">${requestScope.essay.getContent()}</textarea>
		<input type="hidden" name="eid" value="${requestScope.essay.getEid()}"/>
	</c:if>
	
	<c:if test="${requestScope.type eq 2 }">
	<div class="title">
	<input type="text" required="required" name="title" value=""/>
		</div>
	<div class="author" >作者:<input type="text" required="required" name="author" value="${identity.username}" readonly="readonly"/></div>
		<textarea name="content" class="content" name="content" required="required"></textarea>
	</c:if>
	
	<button type="submit">保存提交</button>
	</form>
	</div>
	
</body>
</html>