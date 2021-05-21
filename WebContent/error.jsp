<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 因为html不能实时刷新，只能改成jsp页面了 -->
<!DOCTYPE html>
<html>
	<head>
	<script type="text/javascript" src="./js/common.js"></script>
        <meta charset="UTF-8">

		<link href='//fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>
        

		<style>
			body {
				margin: 0;
				padding: 0;
				width: 100%;
				height: 100%;
				color: #B0BEC5;
				display: table;
				font-weight: 100;
				font-family: 'Lato';
			}

			.container {
				text-align: center;
				display: table-cell;
				vertical-align: middle;
			}

			.content {
				text-align: center;
				display: inline-block;
			}

			.title {
				font-size: 42px;
				margin-bottom: 40px;
			}
		</style>
		
	</head>
	<body>
		<div class="container">
			<div class="content">
				<div class="title">404 很抱歉，您查看的页面找不到了！</div>
				<script type="text/javascript">
				tiaozhuan("",'<%=request.getContextPath()+"/Main" %>');
				</script>
			</div>
		</div>
	</body>
</html>