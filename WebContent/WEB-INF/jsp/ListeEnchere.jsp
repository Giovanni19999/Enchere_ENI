<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste d'enchères</title>
</head>
<body>

	<h1>Recherche</h1>
		<ul>
			<c:forEach items="${requestScope.article}" var="i"> 
			
				 <li><a href="${pageContext.request.contextPath}/afficher/enchere?noArticle=${i.numero}"> 
				${i.nom}<br>
				Début de l'enchère le : ${i.debut.dayOfMonth}/${i.debut.monthValue}/${i.debut.year} à ${i.debut.hour}:${i.debut.minute}<br>
				Fin de l'enchère le : ${i.fin.dayOfMonth}/${i.fin.monthValue}/${i.fin.year} à ${i.fin.hour}:${i.fin.minute}<br><br>
				</a> </li>
			</c:forEach>
			
		</ul>
</body>
</html>