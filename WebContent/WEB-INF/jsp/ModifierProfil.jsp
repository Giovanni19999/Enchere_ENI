<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Profil</title>
</head>
<body>
	<h1>Modifier Profil</h1>
	
	<form action="${pageContext.request.contextPath}/profil/modifier" method="post">
		<ul>
			<li>pseudo : 		<input type="text" 	 name="pseudo"	 			value="${sessionScope.utilisateur.pseudo}"	 	placeholder="pseudo"		required="required"><br><br></li>
			<li>nom : 			<input type="text" 	 name="nom"		 			value="${sessionScope.utilisateur.nom}"	 		placeholder="nom"			required="required"><br><br></li>
			<li>prenom : 		<input type="text" 	 name="prenom"	 			value="${sessionScope.utilisateur.prenom}"	 	placeholder="prenom"		required="required"><br><br></li>
			<li>Email : 		<input type="email"  name="email"													 			placeholder="Ancien Email"><br><br></li>
			<li>nouvel Email : 	<input type="email"  name="emailconfirmation"													placeholder="Nouvel Email"><br><br></li>
			<li>N° téléphone : 	<input type="tel" 	 name="tel"		 			value="${sessionScope.utilisateur.telephone}" 	placeholder="N° tel"	  	required="required"><br><br></li>
			<li>Rue :			<input type="text" 	 name="rue" 		 		value="${sessionScope.utilisateur.rue}"			placeholder="Rue"		  	required="required"><br><br></li>
			<li>Ville : 		<input type="text"   name="ville" 				value="${sessionScope.utilisateur.ville}" 		placeholder="Ville"		  	required="required"><br><br></li>
			<li>Code postal : 	<input type="number" name="codepostal" 			value="${sessionScope.utilisateur.codePostal}" 	placeholder="Code postal"	required="required"><br><br></li>
			
			<li>Ancien mot de passe :  <input type="password" name="mdp" 			  placeholder="Ancien mot de passe" required="required"><br><br></li>
			<li>Nouveau mot de passe : <input type="password" name="mdpconfirmation"  placeholder="Nouveau mot de passe"><br><br></li>
			
			<li><input type="submit" name="validermodifprofil" value="Valider Modifications"></li>
			<li><a href="${pageContext.request.contextPath}/profil/afficher"><input type="button" name="annulermodifprofil" value="Annuler"></a></li>
		</ul>
	</form>

</body>
</html>