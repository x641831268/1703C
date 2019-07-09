<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/css.css" >
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
   <td>编号</td>
   <td>用户名</td>
   <td>密码</td>
  </tr>
  <c:forEach items="${list }" var="l">
  <tr>
   <td>${l.uid }</td>
   <td>${l.uname }</td>
   <td>${l.upwd }</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>