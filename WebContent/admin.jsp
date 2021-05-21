<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<link href="./css/admin.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	function edit(pathname,uid){
		var url=pathname+"?type=1&uid="+uid;  //type1是编辑,3是删除
		window.location.href=url;
	}
	function del(pathname,uid,username){
		var cfm=window.confirm("您确定要删除用户  “"+username+"” 吗");
		if(cfm){
			var url=pathname+"?uid="+uid+"&type=3";
			window.location.href=url;
		}
		
	}
	
	</script>
	</head>

<body>
   
<a href="${pageContext.request.contextPath}/Main">返回首页</a>
<div class="title">用户列表</div>
	<div class="new" style="text-align: center;margin: 20px;font-size: 30px;">
	<a href="${pageContext.request.contextPath}/Admin?type=2">添加用户</a>
	</div>
<table width="200" border="1" class="content">
      <tbody>
 
         <tr>
          <th width="15%" scope="col">ID</th>
          <th width="28%" scope="col">用户名</th>
          <th width="26%" scope="col">密码</th>
          <th width="16%" scope="col">编辑</th>
          <th width="15%" scope="col">删除</th>
        </tr>
              
         <c:forEach items="${userList}" var="user">
       <tr>
          <td>${user.getUid() }</td>
          <td>${user.getUsername() }</td>
          <td>${user.getPassword() }</td>
          <td>
			<button type="button" onclick="edit('${pageContext.request.contextPath}/Admin',${user.getUid()})">编辑</button>
			</td>
          <td>
			<button type="button" onclick="del('${pageContext.request.contextPath}/Admin',${user.getUid() },'${user.getUsername() }')">删除 </button>
			</td>
        </tr>
        </c:forEach>		
        		
        
       
        
       
      </tbody>
</table>
	
</body>
</html>