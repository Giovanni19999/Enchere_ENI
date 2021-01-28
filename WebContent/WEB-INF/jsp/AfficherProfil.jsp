<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil : ${requestScope.user.pseudo}</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/fragments/Navigation.jspf" %>
	
	<h1>profil de ${requestScope.user.pseudo}</h1>
	
	nom : ${requestScope.user.nom}<br>
	prenom : ${requestScope.user.prenom}<br>
	email : ${requestScope.user.email}<br>
	tel : ${requestScope.user.telephone}<br>
	rue : ${requestScope.user.rue}<br>
	code postal :${requestScope.user.codePostal}<br>
	ville : ${requestScope.user.ville}<br>
	
	<form>
 		<input type="button" value="Retour" onclick="history.go(-1)">
	</form>
</body>
</html>