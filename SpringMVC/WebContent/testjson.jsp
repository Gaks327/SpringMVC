<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	$(document).ready(function(){
		$("#username").blur(function(){
			
			
			/* $.post("test",{username:"admin",password:"123"},function(data) {
				var sel = "<select>"
		    		for (var i = 0; i < data.list.length; i++) {
						sel+="<option>"+data.list[i]+"</option>";						
					}
		    		sel+="</select>";
		    		$("#result").before(sel);
		    	
			}); */
			$.ajax({
				url:"test",				//请求路径
		    	data:{					//传递参数
		    		username:"admin",
		    		password:"123"
		    	},
		    	type:"post",			//请求方式
		    	dataType:"json",		//返回数据格式
		    	success: function(data){//成功返回的数据
		    		var sel = "<select>"
		    		for (var i = 0; i < data.list.length; i++) {
						sel+="<option>"+data.list[i]+"</option>";						
					}
		    		sel+="</select>";
		    		$("#result").before(sel);
		    	}
		     });
		})
	})
	
	</script>
  </head>
  
  <body>
  用户名:	<input type="text" id="username"/>
  		<span id="result"></span>
 
  </body>
</html>
