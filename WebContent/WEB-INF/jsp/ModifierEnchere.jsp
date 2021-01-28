<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification de votre enchère</title>
</head>
<body>

	<h1>Modification de votre enchère</h1>
	
	<form action="${pageContext.request.contextPath}/retour/encheres?numArticle=${requestScope.article.numero}" method="post">
		<ul>
			<li><input type="text" name="nomenchere" placeholder="Nom de votre enchère" size="45" required="required" value=" ${requestScope.article.nom}"></li>
	
			<li>
				<select name="categorie" required="required">
				    <option value="">Toutes les catégories</option>
				    <c:forEach items="${sessionScope.Categories}" var="i">
					   <option value="${i}">${i.libeler}</option>
					</c:forEach>
				</select>
			</li>
			
			<li><input type="number" name="prixInit" placeholder="Prix initial de votre enchère" value="${requestScope.article.prixIni}" required="required"></li>
			<li><input type="datetime" name="datedebutenchere" placeholder="Date et heure du lancement de l'enchère" size="45" value="${requestScope.debut}" required="required"></li>
			<li><input type="datetime" name="datefinenchere" placeholder="Date et heure de fin de l'enchère" size="45" value="${requestScope.fin}" required="required"></li>
			
			<li><input type="text" name="descriptionenchere" placeholder="Description de votre enchère (600 charactères max.)" maxlength="600" size="45" autocapitalize="on" value="${requestScope.article.description}" required="required"></li>
		</ul>
		
		<input type="submit" name="valider" value="Valider modifications">
		
		
		
	</form>
	<a href="${pageContext.request.contextPath}/afficher/enchere?numArticle=${requestScope.article.numero}"><input type="button" name="annuler" value="Annuler modifications"></a>
</body>
</html>