<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
<form:form action="addproduct" method="post" modelAttribute="product">
	<form:hidden path="id"/>
	Enter product Name: <form:input path="name"/><br/>
	Enter product price:<form:input path="price"/><br/>
	<input type="submit">
</form:form>
</body>
</html>