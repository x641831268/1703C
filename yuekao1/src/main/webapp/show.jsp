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
	var cid=${param.cid};
	$.post(
	"findbyid.do",
	{cid:cid},
	function(msg){
		 var c=msg.course;
		 $("input[name=cid]").val(c.cid);
		 $("input[name=cname]").val(c.cname);
		 $("input[name=startDate]").val(c.startDate);
		 $("input[name=endDate]").val(c.endDate);
		 $("textarea[name=cdesc]").text(c.cdesc);
		 var label=c.label;
		 var split=label.split(",");
		 $(".la1").val(split[0]);
		 $(".la2").val(split[1]);
		 $(".la3").val(split[2]);
		 $("#im").attr("src","src=showImg.do?path="+c.images);
		 var list=msg.list;
		for ( var i in list) {
			$("select[name=sheng]").append("<option value="+list[i].aid+" class='sh' >"+list[i].aname+"</option>");
		}
		$("option[value="+c.sheng+"]").attr("selected",true);
		findShi(c.shi,c.xian)
	},
	"json"
	);
})

function findShi(shi,xian){
	var shi=$(".sh:selected").val();
	$.post(
			"findShi.do",
			{shi:shi},
			function(msg){
				$("#ss").html("");
				for ( var i in msg) {
					$("select[name=shi]").append("<option value="+msg[i].aid+" class='ss' >"+msg[i].aname+"</option>");
				}
				$("option[value="+shi+"]").attr("selected",true);
				findXian(xian);
			},
			"json"
			);
}

function findXian(xian){
	var xian=$(".ss:selected").val();
	$.post(
			"findXian.do",
			{xian:xian},
			function(msg){
				$("#xi").html("");
				for ( var i in msg) {
					$("select[name=xian]").append("<option value="+msg[i].aid+" class='xian' >"+msg[i].aname+"</option>");
				}
				$("option[value="+xian+"]").attr("selected",true);
			},
			"json"
			);
}

function add(){
	var cid=$("input[name=cid]").val();
	var uid=${user.uid};
	$.post(
	"addCourse.do",
	{cid:cid,uid:uid},
	function(msg){
		if(msg>0){
			alert("加入成功")
			location.href="<%=request.getContextPath()%>/list.do";
		}
	},
	"text"
	);
}

</script>
</head>
<body>
<form action="">
<input type="hidden" name="cid">
课程名称：<input type="text" name="cname">&nbsp;&nbsp;
<input type="date" name="startDate">--
<input type="date" name="endDate"><br>
地区：<select name="sheng" onclick="findShi()"><option>==请选择==</option></select>
<select name="shi" id="ss" onclick="findXian()"><option>==请选择==</option></select>
<select name="xian" id="xi"><option>==请选择==</option></select><br>
课程介绍：<textarea name="cdesc"></textarea><br>
特色标签：<input type="text" name="label" class="la1">
<input type="text" name="label" class="la2">
<input type="text" name="label" class="la3"><br>
照片：<img id="im">
<input type="file" name="photo"><br>
<input type="button" value="加入课程" onclick="add()">
</form>
</body>
</html>