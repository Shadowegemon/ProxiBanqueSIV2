<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
 
	<table>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Celphone</th>
		</tr>
		<%-- 		<c:forEach items="${authors}" var="current"> --%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<%-- 		</c:forEach> --%>
	</table>




</body>
</html>