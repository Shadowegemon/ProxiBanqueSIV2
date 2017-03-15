
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
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<title>Accueil Conseiller</title>
</head>
<body>

	<div class="container">

		<header class="row">
		<div class="col-md-5">Interface Proxibanque</div>

		<div class="col-md-7"></div>
		</header>

		<div class="row">
			<nav class="col-md-2">
			<div class="sidebar-nav">
				<div class="well" style="width: 160px; padding: 8px 0;">
					<ul class="nav nav-list">

						<li class="nav-header">Menu conseiller</li>
						<li class="active"><a href="advisorHome.jsp">Liste
								clients</a></li>
							<li><a href="updateClient.jsp">Editer Client</a></li>
						
						
						<li><a href="#">Liste comptes</a></li>

						<li><a href="transfert.jsp">Virement</a></li>
						<li>
							<form action="ServletLogout" method="post">
								<input type="submit" value="Logout">
							</form>
						</li>
					</ul>
				</div>
			</div>
			</nav>

			<section class="col-md-10"> <legend>Liste de vos
				clients</legend>
				
				
			<div class="row">


				<c:if test="${not empty list}">
					<table>
						<tr>
							<th>Last Name</th>
							<th>First Name</th>
							<th>Cellphone</th>
						</tr>
						<c:forEach var="current" items="${list}">
							<tr>
								<td><c:out value="${current.lastName}"></c:out></td>
								<td><c:out value="${current.firstName}"></c:out></td>
								<td><c:out value="${current.cellphone}"></c:out></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty list}">
					<p>Vous n'avez pas de client</p>
				</c:if>






			</div>
			</section>
		</div>
		<footer class="row"> Proxibanque </footer>
	</div>













</body>
</html>