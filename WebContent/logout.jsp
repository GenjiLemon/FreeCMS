<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/common.js"></script>
<title>注销登录</title>
</head>
<body>
<%
session.invalidate();
%>
<script>
tiaozhuan("注销成功！","${pageContext.request.contextPath }/Main");
</script>
</body>
</html>