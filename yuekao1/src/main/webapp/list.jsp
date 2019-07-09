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
	$("#ccc").toggle(function(){
		$(".che").attr("checked",true);
	},function(){
		$(".che").attr("checked",false);
	})
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

function show(){
	var cid=$(".che:checked").val();
	location.href="<%=request.getContextPath()%>/show.jsp?cid="+cid;	
}

function del(){
	var ids=$(".che:checked").map(function(){
		return this.value;
	}).get().join();
	var split=ids.split();
	var count=split.length;
	$.post(
	"del.do",
	{ids:ids},
	function(msg){
		alert("成功删除"+count+"条");
		location.href="<%=request.getContextPath()%>/list.do";	
	},
	"text"
	);
}


</script>
</head>
<body>
<form action="list.do" method="post">
  课程名称：<input type="text" name="uname">
  特色标签：<input type="text" name="label"><br>
  地区：<select name="sheng" onclick="findShi()"><option>==请选择==</option></select>
<select name="shi" id="ss" onclick="findXian()"><option>==请选择==</option></select>
<select name="xian" id="xi"> <option>==请选择==</option> </select><br>
    <input type="submit" value="搜索">
</form>
<table>
  <tr>
    <td><input type="checkbox" id="ccc">全选/全不选</td>
    <td>课程名称</td>
    <td>特色标签</td>
    <td>地区</td>
    <td>参与人员姓名</td>
    <td>参与人员身份</td>
    <td>课程介绍</td>
    <td>开始日期</td>
    <td>结束日期</td>
  </tr>
  <c:forEach items="${page }" var="l">
  <tr>
    <td><input type="checkbox" value="${l.cid }" class="che" name="cid"></td>
    <td>${l.cname }</td>
    <td>${l.label }</td>
    <td>${l.asheng.aname },${l.ashi.aname },${l.axian.aname }</td>
    <td>${l.uname }</td>
    <td>
     <c:if test="${l.utype==1 }">学生</c:if>
     <c:if test="${l.utype==0 }">讲师</c:if>
    </td>
    <td>${l.cdesc }</td>
    <td>${l.startDate }</td>
    <td>${l.endDate }</td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="10"> <input type="button" value="查看课程详情" onclick="show()">
<input type="button" value="批量删除" onclick="del()">
</td>
  </tr>
  <tr>
   <td colspan="10">
   ${pageNum }页/共${zong }页
   <a href="list.do?pageNum=1">首页</a>
   <a href="list.do?pageNum=${pageNum==1?pageNum:pageNum-1 }">上一页</a>
   <a href="list.do?pageNum=${pageNum==zong?zong:pageNum+1 }">下一页</a>
   <a href="list.do?pageNum=${zong}">末页</a>
   </td>
  </tr>
</table>

</body>
</html>