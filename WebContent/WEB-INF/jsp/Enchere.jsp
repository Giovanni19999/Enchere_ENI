<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<FORM ACTION="${pageContext.request.contextPath}/profil/afficher?profil=${requestScope.vendeurNum}" METHOD="post" NAME="myForm">
	</FORM>
	
	<h1>${requestScope.article.nom}</h1>
	<p>Vendeur : <a href="javascript:document.forms['myForm'].submit();">${requestScope.vendeurPseudo}</a></p>
	<p>Début de l'enchère le : ${requestScope.article.debut}</p>
	<p>Fin de l'enchère le : ${requestScope.article.fin}</p>
	<p>Description : ${requestScope.article.description}</p>
	
	<!-- On affiche l'adresse du vendeur -->
	Adresse de retrait :<br> 
	${requestScope.vendeurRue}<br>
	${requestScope.vendeurCodePostal} ${requestScope.vendeurVille}<br>
	
	<p>Prix initial : ${requestScope.article.prixIni}</p>
	<!-- Pour le moment on affiche le prix initial car on ne peux pas encore enchérire -->
	<p>Prix de l'enchère actuelle : ${requestScope.article.prixIni}</p> 
	
	<!-- Si on est le vendeur alors on affiche le boutton modifier enchère -->
	<c:if test="${requestScope.vendeurPseudo == sessionScope.utilisateur.pseudo}">
		<form action="${pageContext.request.contextPath}/modifier/enchere?numArticle=${requestScope.article.numero}" method="get">
			<input type="submit" name="Modifier" value="Modifier l'enchère">
		</form>
	</c:if>
	
	<!-- Si on est pas le vendeur, on affiche le bouton encherire -->
	<c:if test="${requestScope.vendeurPseudo != sessionScope.utilisateur.pseudo}">
		<input type="button" name="Encherire" value="Encherire">
		<input type="number" name="prix" placeholder="Montant de votre enchère">
	</c:if>