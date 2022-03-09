<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="std" items="${StdntDetails}">
		<table>
			<tr>
				<th>Param</th>
				<th>Value</th>
			</tr>
			<tr>
				<td>ID</td>
				<td>${std.id}</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>${std.username}</td>
			</tr>	
			<tr>
				<td>Password</td>
				<td>${std.password}</td>
			</tr>	
			<tr>
				<td>Name</td>
				<td>${std.name}</td>
			</tr>	
			<tr>
				<td>Email</td>
				<td>${std.email}</td>
			</tr>		
		</table>		
	</c:forEach>
</body>
</html>