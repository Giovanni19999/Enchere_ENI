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
	<h1>in${requestScope.article.nom}</h1>
	
	pseudo : ${sessionScope.utilisateur.pseudo}<br>
	début de l'enchère le : ${requestScope.article.debut}<br>
	fin de l'enchère le ${requestScope.article.fin}<br>
	<form>
<textarea name="description" rows=4 cols=40>${requestScope.article.description}</textarea>
</form>
	Adresse de retrait : ${requestScope.article.adresse }<br>
	prix initial : ${requestScope.article.prixInit}<br>
</body>
</html>