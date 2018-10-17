<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Books</title>
</head>
<body>
	<c:forEach items="${all}" var="item">
		<table>
			<tr>
				<td>Title</td>
				<td>${item.title}</td>
			</tr>
			<tr>
				<td>Genre</td>
				<td>${item.genre}</td>
			</tr>
			<tr>
				<td>Author</td>
				<td>${item.author}</td>
			</tr>
			<tr>
				<td>Language</td>
				<td>${item.language}</td>
			</tr>
			<tr>
				<td>Edition</td>
				<td>${item.edition}</td>
			</tr>
		</table>
		<br />
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
	<a href="form.mvc">Add a new book</a>
</body>
</html>