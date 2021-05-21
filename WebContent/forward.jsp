<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="./js/common.js"></script>
<meta charset="UTF-8">
<title>跳转...</title>
</head>
<body>
<%
String path = request.getContextPath();
String url=(String) request.getAttribute("forwardURL");
//url=(url==null)?url:"/Main";
if(request.getAttribute("forwardURL")==null)url="/Main";
url=path+url;
String tips=(String) request.getAttribute("forwardTips");
%>
<script type="text/javascript">
	tiaozhuan("<%= tips%>","<%=url%>");
</script>
</body>
</html>