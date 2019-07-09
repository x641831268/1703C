<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function login(){
	$.post(
	"login.do",
	$("form").serialize(),
	function(msg){
		if(msg==1){
				alert("学生登录成功")
				location.href="<%=request.getContextPath()%>/list.do";		
		}else if(msg==2){
			alert("密码错误")
		}else if(msg==0){
			alert("老师登录成功")
			location.href="<%=request.getContextPath()%>/add.jsp";	
		}else{
			alert("用户名不存在")
		}
	},
	"text"
	);
}

</script>
</head>
<body>
<form action="">
姓名：<input type="text" name="uname"><br>
密码：<input type="password" name="upwd"><br>
<input type="button" value="登录" onclick="login()">
</form>
</body>
</html>