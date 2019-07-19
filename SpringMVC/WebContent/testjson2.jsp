<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#uname").blur(function(){
			$.ajax({
				url:"test111",
				data:{
					username:"admin",
					password:"woqu"
				},
				type:"get",
				dateType:"json",
				success: function(data){
					var sel = "<select>"
					for(var i = 0;i< data.list.length; i++){
						sel+="<option>"+data.list[i]+"</option>";
					}
					sel+="</select>";
					$("#age").before(sel);
					
				}
			})
		})
	})
	
	
	
</script>
</head>
<body>
	<span>得到所有用户</span>
	<br />
	<div id="content"></div>

	<br /> 用户名:
	<input type="text" id="uname" name="stuname" />
	<br /> 年龄:
	<input type="text" name="age" id="age" />
	<br />
	<input type="button" value="新增" />
</body>
</html>
































