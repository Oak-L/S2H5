<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

div {
	float: left;
}
</style>
</head>
<body>
	<h1>S2H4</h1>
	<h1>欢迎用户：${user.username }</h1>
	<hr>
	<div style="float: left; border: 5px solid red; width: 150px; margin: 50px;">
		<ul>
			<li><a href="${pageContext.request.contextPath }/index.jsp">主页</a></li>
			<li><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
			<li><a href="${pageContext.request.contextPath }/customer_toAdd">添加</a></li>
			<li><a href="${pageContext.request.contextPath }/customer_list">查询</a></li>
			<li><a href="${pageContext.request.contextPath }/logout.jsp">退出</a></li>
		</ul>
	</div>
	<div style="border: 5px solid red; margin: 50px;">
		<table>
			<tr>
				<th>欢迎？${user.username }</th>
			</tr>
		</table>
	</div>
</body>
</html>