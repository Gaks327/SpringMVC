<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

//标准的返回数据的格式
	/* {
		"message":"操作成功失败",
		"code":"状态码 2,3,4",
		"data":"返回数据"
	} */
	var v = {
		"message":"success",
		"code":200,
		"users":[
			{"id":"1","name":"张三"},
			{"id":"2","name":"张三1"},
			{"id":"3","name":"张三2"},
			{"id":"4","name":"张三3"}
		]
	}

	alert(v.message)
	alert(v.code);
	alert(v.users[0].id); 
</script>
</head>
<body>
	<a href="bbb?username=admin">aaaa</a>
	<a href="b2?username=admin&pass=1">aaaa2</a>
	<a href="b3?username=admin&pass=1">aaaa3</a>
	<a href="b4?">aaaa4</a>
	<a href="b5?username=admin&pass=1">aaaa5</a>
	<a href="b6?username=admin&pass=1">aaaa6</a>
	<a href="b7?username=admin">aaaa7</a>
	<a href="b8?username=admin&pass=13888">aaaa8</a>
	<a href="b9?username=admin&pass=341413413">aaaa9</a>
	<a href="b0?username=admin&pass=1">aaaa0</a><br>
	
	<a href="b000?username=admin">aaaa000</a><br>
	
	<a href="b?aa=admin&v=123">a</a><br>
	
	<a href="testrest/12/25/15">a</a><br>
	
	<a href="bbb3?username=admin&pass=1">bbb3</a>
	
	<form action="from" method="post">
		<input type="checkbox" value="1" name="n"/>
		<input type="checkbox" value="2" name="n"/>
		<input type="checkbox" value="3" name="n"/>
		<input type="checkbox" value="4" name="n"/>
		<input type="checkbox" value="5" name="n"/>
		<input type="submit" value="提交"/>
	</form>
	<form action="from111" method="post">
		<input type="checkbox" value="1" name="n"/>
		<input type="checkbox" value="2" name="n"/>
		<input type="checkbox" value="3" name="n"/>
		<input type="checkbox" value="4" name="n"/>
		<input type="checkbox" value="5" name="n"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>