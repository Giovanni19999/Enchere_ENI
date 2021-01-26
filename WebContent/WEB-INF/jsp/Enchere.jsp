<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchere</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/fragments/Navigation.jspf" %>
	<h1>${sessionScope.article.nom}</h1>
	
	pseudo : ${sessionScope.utilisateur.pseudo}<br>
	début de l'enchère le : ${sessionScope.article.debut}<br>
	fin de l'enchère le ${sessionScope.article.fin}<br>
	<form>
<textarea name="description" rows=4 cols=40>${sessionScope.article.description}</textarea>
</form>
	Adresse de retrait : ${sessionScope.article.adresse }<br>
	prix initial : ${sessionScope.article.prixInit}<br>
</body>
</html>