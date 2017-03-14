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
<title>Editer client</title>
</head>
<body>
	<p class="intro">Modifier les données du client :</p>

	<form action="ServletUpdate" method="POST">

		<div class="field">
			<label for="lastName">Nom : </label> <input id="lastName"
				name="lastName" placeholder="Saisir le nouveau nom" />
		</div>

		<div class="field">
			<label for="firstName">Prénom : </label> <input id="firstName"
				name="firstName" placeholder="Saisir le nouveau prénom" />
		</div>

		<div class="field">
			<label for="email-field">Email : </label> <input id="email-field"
				name="email" type="email" />
		</div>

		<div class="field">
			<label for="adresse">Adresse : </label> 
			<input id="adresse" name="adresse" placeholder="Saisir la nouvelle adresse" />
		</div>

		<input class="field-submit" type="submit" value="Je m'inscris" />
	</form>

</body>
</html>