
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	media="screen" />

<title>Accueil Conseiller</title>
</head>
<body>
	Espace Conseiller
	<p>Bonjour ${user.login},vous êtes connecté</p>

	<c:if test="${not empty list}">
		<table>
			<tr>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Celphone</th>
			</tr>
			<c:forEach var="current" items="${list}">
				<tr>
					<td><c:out value="${current.lastName}"></c:out></td>
					<td><c:out value="${current.firstName}"></c:out></td>
					<td><c:out value="${current.celphone}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty list}">
		<p>Vous n'avez pas de client</p>
	</c:if>


</body>
</html>