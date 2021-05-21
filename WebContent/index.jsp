<%@page import="dao.Essay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <jsp:useBean id="identity" class="bean.Identity" scope="session" />
   
    
<!doctype html>
<html>
<head>

<meta charset="utf-8">
<title>文章列表</title>
<link  rel="stylesheet" href="./css/index.css" type="text/css">	
<script type="text/javascript" >
function edit(pathname,eid){
	var url=pathname+"?type=1&eid="+eid;
	window.location.href = url;
}

function view(pathname,eid){
	var url=pathname+"?eid="+eid;
	window.location.href = url;
}

function del(pathname,eid){
	var cfm=window.confirm("您确定要删除吗？");
	if(cfm){
	var url=pathname+"?type=3&eid="+eid;
	window.location.href=url;
	}
}
</script>
</head>
<body>


<div class="top">
	
	<div>${identity.username}，欢迎您！</div>
	<c:if test="${!identity.isVisitors()}"><div>&nbsp; <a href="logout.jsp">注销登录</a> </div></c:if>
	<c:if test="${identity.isAdmin()}"><div> &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/Admin">进入后台</a></div></c:if> 
	<c:if test="${identity.isVisitors()}"><div> &nbsp;&nbsp;还没有登录？请<a href="${pageContext.request.contextPath}/Login">登录</a></div></c:if> 
</div>	
<div class="title">文章列表</div>
<div class="new" style="text-align: center;margin: 20px;font-size: 30px;">
<c:if test="${!identity.isVisitors()}"><a href="${pageContext.request.contextPath}/Essay?type=2">新建文章</a></c:if>
	
	</div>
	<div class="content">
	<table width="70%" height="800px" border="1" align="center" class="tablebody">
  <tbody>
    <tr>
      <th width="57" scope="col">ID</th>
      <th width="392" scope="col">标题</th>
      <th width="112" scope="col">作者</th>
      <th width="65" scope="col">查看</th>
      <th width="64" scope="col">编辑</th>
      <th width="64" scope="col">删除</th>
    </tr>
  
   <c:forEach items="${essayList}" var="essay">
    <tr>
      <td>${essay.eid}</td>
      <td class="tableword">${essay.title}</td>
      <td class="tableword">${essay.author}</td>
	  <td><button id="button1" onclick="view('${pageContext.request.contextPath}/Essay',${essay.eid})">查看</button></td>	
	  <td> 
	  <c:if test="${identity.canEdit(essay.title)}">  
	  <button id="button2" onclick="edit('${pageContext.request.contextPath}/Essay',${essay.eid})" >编辑</button>  
	   </c:if>
	  </td>	  
	  <td>
	  <c:if test="${identity.canEdit(essay.title)}">  
	  <button id="button3" onclick="del('${pageContext.request.contextPath}/Essay',${essay.eid})">删除</button>
	    </c:if>
    	</td>
	</tr>
   </c:forEach>
 
    
    
  </tbody>
</table>
	</div>
	<%@ include file="footer.html" %>
</body>
</html>
