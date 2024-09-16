<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Test servlet
		<c:out value="${model.message}" />
	</h1>
	<form method="post" action="file.upload" enctype="multipart/form-data">
		<input type="file" name="file" />
		 <button type="submit" >Enviar</button>
	</form>
</body>
</html>