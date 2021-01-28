<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon profil</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/fragments/Navigation.jspf" %>
	
	<h1>Mon profil</h1>
	
	pseudo : ${sessionScope.utilisateur.pseudo}<br>
	nom : ${sessionScope.utilisateur.nom}<br>
	prenom : ${sessionScope.utilisateur.prenom}<br>
	email : ${sessionScope.utilisateur.email}<br>
	tel : ${sessionScope.utilisateur.telephone}<br>
	rue : ${sessionScope.utilisateur.rue}<br>
	code postal :${sessionScope.utilisateur.codePostal}<br>
	ville : ${sessionScope.utilisateur.ville}<br>
	
	<form action="${pageContext.request.contextPath}/profil/modifier" method="get">
		<input type="submit" name="modifierrencheres" value="Modifier Profil">
	</form>
					
</body>
</html>