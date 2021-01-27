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
				${i.nom} ${i.debut} ${i.fin}<br>
				${i.description}<br>
				</a> </li>
			</c:forEach>
			
		</ul>
</body>
</html>