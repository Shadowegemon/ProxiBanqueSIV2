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

<title>Accueil ProxiBanque</title>
</head>
<body>

	<div class="container">

		<header class="row">
		<div class="col-md-5">Bienvenue sur l'interface Proxibanque</div>

		<div class="col-md-7">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="ServletLogin" method="post" id="signin"
						class="navbar-form navbar-right" role="form">
						<div class="input-group">
							<span class="input-group-addon">L</span> <input id="email"
								type="text" class="form-control" name="loginuser" value=""
								placeholder="Login">
						</div>
						<div class="input-group">
							<span class="input-group-addon">P</span> <input id="password"
								type="password" class="form-control" name="password" value=""
								placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
			</nav>
		</div>
		</header>


		<div class="row">

			<section class="col-md-10"> <legend>Non connecté</legend> </section>
		</div>
		<footer class="row"> Proxibanque </footer>
	</div>






</body>
</html>