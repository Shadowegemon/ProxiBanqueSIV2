<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
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
						<li><a href="updateClient">Editer client</a></li>
						<li><a href="listAccount.jsp">Liste comptes</a></li>
						<li class="active"><a href="transfert.jsp">Virement</a></li>

						<li>
							<form action="ServletLogout" method="post">
								<input type="submit" value="Logout">
							</form>
						</li>
					</ul>
				</div>
			</div>

			</nav>
			<section class="col-md-10"> <legend>Effectuer un
				virement</legend>
			<div class="panel panel-primary">

				<div class="panel-body">


					<form action="ServletTransfert" method="post"
						class="form-inline">
						<div class="form-group">
							<select id="select" class="form-control"
								onclick="this.form.idHost.value=this.options[this.selectedIndex].value;">
								<option value="">Compte à débiter</option>
								<c:forEach var="c" items="${listCount}">
									<option value="${c.numAccount}">Compte n°
										<c:out value="${c.numAccount}" />, Solde
										<c:out value="${c.sold}" /></option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<select id="select" class="form-control"
								onclick="this.form.idDest.value=this.options[this.selectedIndex].value;">
								<option value="">Compte à créditer</option>
								<c:forEach var="c" items="${listCount}">
									<option value="${c.numAccount}">Compte n°
										<c:out value="${c.numAccount}" />, Solde
										<c:out value="${c.sold}" /></option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<div class="input-group">
								<input type="number" class="form-control"
									style="text-align: right" id="montant" name="montant"
									placeholder="Montant"> <span class="input-group-addon">€</span>
								<span class="input-group-btn">
									<button class="form-control" type="submit">Valider</button>
									<button class="form-control" type="button">Annuler</button>
								</span>
							</div>
						</div>
						<div class="form-group">
							<label for="host">Compte à débiter</label> <input type="text"
								class="form-control" id="idHost" name="idHost"
								readonly>
						</div>
						<div class="form-group">
							<label for="dest">Compte à créditer</label> <input type="text"
								class="form-control" id="idDest" name="idDest"
								readonly>
						</div>
						
					</form>
					
					
						
					
					
				</div>
			</div>

			</section>
		</div>
		<footer class="row"> Proxibanque </footer>
	</div>


</body>
</html>
F
