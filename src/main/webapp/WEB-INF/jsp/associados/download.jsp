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
	<h1>Todos associados matriculados</h1>


	<table border="1" style="width: 100%; text-align: center;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Data Matricula</th>
				<th>Type</th>
				<th>Foto</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="o" items="${model.associados}">
				<tr>
					<td><c:out value="${o.id}"/></td>
					<td><c:out value="${o.nome}"/></td>
					<td><c:out value="${o.dtMatricula}"/></td>
					<td><c:out value="${o.type}"/></td>
					<td><img title="Foto perfil image" width="80"
						src="<c:url value="controller?invoke=DownloadImages"/>"></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>