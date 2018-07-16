<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <form action="testFormat">
		Name:<input type="text" name="name" /><br />
		Emali:<input type="text" name="email" /><br />
		Age:<input type="text" name="age" /><br />
		Salary:<input type="text" name="salary" /><br />
		Birth:<input type="text" name="birth" /><br />
		<input type="submit" value="submit">
	</form> --%>
	<form:form action="testFormat" modelAttribute="user">
		<form:errors path="*"></form:errors><br />
		Name:<form:input type="text" path="name" /><form:errors path="name"></form:errors><br /><br />
		Emali:<form:input type="text" path="email" /><form:errors path="email"></form:errors><br /><br />
		Age:<form:input type="text" path="age" /><form:errors path="age"></form:errors><br /><br />
		Salary:<form:input type="text" path="salary" /><form:errors path="salary"></form:errors><br /><br />
		Birth:<form:input type="text" path="birth" /><form:errors path="birth"></form:errors><br /><br />
		<input type="submit" value="submit">
	</form:form>
</body>
</html>