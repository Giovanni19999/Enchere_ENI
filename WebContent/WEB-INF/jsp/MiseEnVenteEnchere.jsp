<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mise en vente d'une enchère</title>
</head>
<body>

	<h1>Mise en vente d'une enchère</h1>
	
	<form action="${pageContext.request.contextPath}/enchere/ajouter" method="post">
		<ul>
		<li><input type="text" name="nomenchere" placeholder="Nom de votre enchère" size="45"></li>

		<li>
			<select name="categorie" required="required">
			    <option value="">Veuillez choisir une catégorie</option>
			    <c:forEach items="${sessionScope.Categories}" var="i">
				   <option value="${i}">${i.libeler}</option>
				</c:forEach>
			</select>
		</li>
			<li><input type="number" min="0" step="0.01" name="prixenchere" placeholder="Prix initial de votre enchère" required="required"></li>
			<li><input type="datetime-local" min="${requestScope.dateMaintenant }" name="datedebutenchere" placeholder="Date et heure du lancement de l'enchère" size="45" required="required"></li>
			<li><input type="datetime-local" min="${requestScope.dateMaintenant }" name="datefinenchere" placeholder="Date et heure de fin de l'enchère" size="45" required="required"></li>
			<li><input type="text" name="adresseretraitenchere" placeholder="Adresse ou l'article est vendu" size="45" required="required"></li>
			<li><textarea name="descriptionenchere" placeholder="Description de votre enchère (600 charactères max.)" rows="6" cols="100" autocapitalize="on"></textarea></li>
		</ul>
		
		<input type="submit" name="valider" value="valider">
		<a href="${pageContext.request.contextPath}/retour/encheres"><input type="button" name="Annuler" value="Annuler"></a>
	</form>
	
</body>
</html>