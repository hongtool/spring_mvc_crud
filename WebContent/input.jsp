<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${abc != null ? 'UPDATE THE EMPLOYEE' : 'ADD THE EMPLOYEE' }</h3>
	<%-- <form:form action="" method="post"> --%>
	<form:form action="../emp" method="post" modelAttribute="abc">
		<c:if test="${abc.id != null }">
			<input type="hidden" name="_method" value="PUT">
			<form:hidden path="id" />
		</c:if>
		<table>
			<tr>
				<td>NAME</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="mail" /></td>
			</tr>
			<c:if test="${abc.id == null }">
				<tr>
					<td>GENDER</td>
					<td>
						<form:radiobuttons path="gender" items="${requestScope.genders }" />
					</td>
				</tr>
			</c:if>
			<tr>
				<td>DEPARTEMNT</td>
				<td>
					<form:select path="dept.deptId" items="${requestScope.depts }" itemLabel="deptName" itemValue="deptId"></form:select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="${abc != null ? 'UPDATE' : 'ADD' }" /></td>
			</tr>
		</table>
	</form:form>
	<%-- <form action="">
		<table>
			<tr>
				<td>NAME</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><input type="text" name="mail" /></td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td><input type="radio" name="gender" value="0" />MALE <input
					type="radio" name="gender" value="1" />FEMALE</td>
			</tr>
			<tr>
				<td>DEPARTEMNT</td>
				<td><select>

				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="name" /></td>
			</tr>
		</table>
	</form> --%>
</body>
</html>