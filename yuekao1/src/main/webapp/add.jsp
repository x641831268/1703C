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

$(function(){
	$.post(
	"findSheng.do",
	function(msg){
		for ( var i in msg) {
			$("select[name=sheng]").append("<option value="+msg[i].aid+" class='sh' >"+msg[i].aname+"</option>");
		}
	},
	"json"
	);
})

function findShi(){
	var shi=$(".sh:selected").val();
	$.post(
			"findShi.do",
			{shi:shi},
			function(msg){
				$("#ss").html("");
				for ( var i in msg) {
					$("select[name=shi]").append("<option value="+msg[i].aid+" class='ss' >"+msg[i].aname+"</option>");
				}
			},
			"json"
			);
}

function findXian(){
	var xian=$(".ss:selected").val();
	$.post(
			"findXian.do",
			{xian:xian},
			function(msg){
				$("#xi").html("");
				for ( var i in msg) {
					$("select[name=xian]").append("<option value="+msg[i].aid+" class='xian' >"+msg[i].aname+"</option>");
				}
			},
			"json"
			);
}

</script>
</head>
<body>
<form action="add.do" method="post" enctype="multipart/form-data">
课程名称：<input type="text" name="cname">&nbsp;&nbsp;
<input type="date" name="startDate">--
<input type="date" name="endDate"><br>
地区：<select name="sheng" onclick="findShi()"><option>==请选择==</option></select>
<select name="shi" id="ss" onclick="findXian()"><option>==请选择==</option></select>
<select name="xian" id="xi"><option>==请选择==</option></select><br>
课程介绍：<textarea name="cdesc"></textarea><br>
特色标签：<input type="text" name="label">
<input type="text" name="label">
<input type="text" name="label"><br>
照片：<input type="file" name="photo"><br>
<input type="submit" value="创建课程">
</form>
</body>
</html>