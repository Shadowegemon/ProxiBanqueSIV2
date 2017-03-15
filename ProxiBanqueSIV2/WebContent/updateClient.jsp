<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	media="screen" />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Editer client</title>
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
						<li><a href="advisorHome.jsp">Liste clients</a></li>
						<li class="active"><a href="updateClient">Editer client</a></li>
						<li><a href="listAccount.jsp">Liste comptes</a></li>
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

			<section class="col-md-10"> <legend>Editer un
				client</legend>


			<div class="row">
				<form action="ServletUpdateClient" method="post">
					<div class="col-md-6">
						<div class="form-group">
							<label for="firstname">Selectionner un client</label> <select
								id="select" class="form-control"
								onclick="this.form.idClient.value=this.options[this.selectedIndex].value;">
								<c:forEach var="p" items="${list}">
									<option value="${p.id}">

										<c:out value="${p.lastName},${p.firstName}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="idClient">ID Client</label> <input type="text"
								class="form-control" id="idClient" name="idClient"
								readonly>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="firstname">Firstname</label> <input type="text"
								class="form-control" id="firstname" name="firstName"
								placeholder="LastName" >
						</div>
						<div class="form-group">
							<label for="lastname">LastName</label> <input type="text"
								class="form-control" id="lastname" name="lastName"
								placeholder="LastName" >
						</div>
						<div class="form-group">
							<label for="lastname">Email</label> <input type="email"
								class="form-control" id="email" name="email" placeholder="email"
								>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="AddressLine1">Address </label> <input type="text"
								class="form-control" id="address" name="address"
								placeholder="Address" >
						</div>
						<div class="form-group">
							<label for="zip">Zip / Postal Code</label> <input type="text"
								class="form-control" id="zip" name="zip"
								placeholder="Zip ore Postal Code" >
						</div>
						<div class="form-group">
							<label for="city">City / Town</label> <input type="text"
								class="form-control" id="city" name="city" placeholder="city"
								>
						</div>
					</div>
					
					<div class="form-group">
						<button class="form-control" type="submit">Valider</button>
					</div>

				</form>
			</div>
			</section>
		</div>
		<footer class="row"> Proxibanque </footer>
	</div>

</body>
</html>