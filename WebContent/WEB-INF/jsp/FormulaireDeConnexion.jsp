<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

	<p> <!-- Si l'utilisateur renseigne un mauvais identifiant / mdp, on affiche un message d'erreur. -->
		<c:if test="${!empty requestScope.erreur}"> erreur : ${requestScope.erreur} </c:if>
	</p>
	
	<form action="${pageContext.request.contextPath}/connexion/utilisateur" method="post">
		<ul>
			<li>Pseudo ou Email <input type="text" value="${requestScope.user}" name="identifiant" placeholder="Pseudo ou Email"><br><br></li>
			<li>Mot de passe <input type="password" name="mdp" placeholder="Mot de passe"><br><br></li>
			
			<li><input type="submit" value="Se connecter"></li>
		</ul>
		<label for="resterconnecter">Enregistrer mon identifiant</label>
		<input type="checkbox" name="resterconnecter" value="resterconnecter" <c:if test="${!empty requestScope.user}">checked="checked" </c:if>>
	</form>
	<a href="${pageContext.request.contextPath}/compte/creation">Créer un compte</a>
</body>
</html>