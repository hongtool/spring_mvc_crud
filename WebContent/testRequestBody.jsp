<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#testRequestBody').click(function() {
			$.ajax({
				url:'http://localhost:8080/spring_mvc_crud/testRequestBody',
				type:'post',
				contentType:'application/json; charset=UTF-8',
				data:'[{"name":"TOM","age":12},{"name":"JERRY","age":10}]',
				success:function(result) {
					$.each(result, function(index, value) {
						alert(value.name + ',' + value.age);
					});
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<a id="testRequestBody" href="testRequestBody.jsp">Test RequestBody</a>
</body>
</html>