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

function zhuce(){
	var uname=$("input[name=uname]").val();
	var upwd=$("input[name=upwd]").val();
	var againUpwd=$("input[name=againUpwd]").val();
	var reg=/^\w{6,16}$/;
	if(reg.test(upwd)){
		if(againUpwd==upwd){
			$.post(
				"zhuce.do",
				$("form").serialize(),
				function(msg){
					if(msg>0){
						alert("注册成功")
						location.href="<%=request.getContextPath()%>/login.jsp";
					}
				},
				"text"
			);
		}else{
			alert("第二次与第一次密码不符");
		}
	}else{
		alert("输入的密码不合法")
	}
}

</script>
</head>
<body>
<form action="">
姓名：<input type="text" name="uname"><br>
密码：<input type="password" name="upwd"><br>
确认密码：<input type="password" name="againUpwd"><br>
身份：<select name="utype">
<option value="0">讲师</option>
<option value="1">学生</option>
    </select><br>
<input type="button" value="注册" onclick="zhuce()">
<input type="button" value="已有用户登录" onclick="login()">
</form>
</body>
</html>