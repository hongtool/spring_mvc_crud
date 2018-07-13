<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.0.min.js"></script>
<script>
	$(function() {
		$('a:first-of-type').click(function() {
			$('form').attr('action',$(this).attr('href')).submit();
			return false;
		});
	});
</script>
</head>
<body>
	<c:if test="${empty requestScope.emps }">
		<h3 align="center">NO EMPLOYEES</h3>
	</c:if>
	<c:if test="${!empty requestScope.emps }">
		<h3 align="center">HTE EMPLOYEES LIST</h3>
		<table width="600px" border="1" align="center">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>MAIL</td>
				<td>GENDER</td>
				<td>DEPTNAME</td>
				<td>DELETE &nbsp&nbsp UPDATE</td>
			</tr>
			<c:forEach items="${requestScope.emps }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.mail }</td>
					<td>${emp.gender == 0 ? "MALE" : "FEMALE" }</td>
					<td>${emp.dept.deptName }</td>
					<td>
						<a href="emp/${emp.id }">DELETE</a>
						<a href="input/${emp.id }">UPDATE</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<!-- GET请求转为POST请求 -->
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
</body>
</html>