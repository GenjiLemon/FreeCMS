<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>文章主页</title>
	<link rel="stylesheet" type="text/css" href="./css/ezindex.css">
	<script type="text/javascript" src="./js/common.js"></script>
	<script>
	function change(pathname,eid,mode){
		var url=pathname+"?eid="+eid+"&auto="+mode;  //auto=pre,next代表需要查询前或者后
		window.location.href = url;
	}
	</script>
</head>

<body>
	<a href="${pageContext.request.contextPath }/Main">返回首页</a>
	<div class="main">
	<div class="title">标题：${requestScope.essay.getTitle() }</div>
	<div class="author">作者：${requestScope.essay.getAuthor() }</div>
	<div class="content">${requestScope.essay.getContent() }</div>
	</div>
	<div class="last">
	<button onclick="change('${pageContext.request.contextPath}/Essay','${requestScope.essay.getEid()}','pre')">上一篇</button>	
	<button onclick="change('${pageContext.request.contextPath}/Essay','${requestScope.essay.getEid()}','next')">下一篇</button>
	</div>

	

<%@ include file="footer.html" %>
</body>
</html>