<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
    </head>
    <body>
		 <p> <!-- Si l'utilisateur renseigne un mauvais identifiant / mdp, on affiche un message d'erreur. -->
				<c:if test="${!empty requestScope.erreur}"> erreur : ${requestScope.erreur} </c:if>
		</p>
        <form method="post" action="${pageContext.request.contextPath}/compte/creation">
            <fieldset>
                <h1>Inscription</h1>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>

                <label for="pseudo">Pseudo <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="60" required="required"/>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" required="required"/>
                <br />
                
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20"required="required"/>
                <br />

				<label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" required="required"/>
                <br />

				<label for="prenom">Prénom</label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" required="required"/>
                <br />

				<label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" required="required"/>
                <br />

                <label for="telephone">Téléphone<span class="requis">*</span></label>
                <input type="tel" id="telephone" name="telephone" value="" size="20" maxlength="60" />
                <br />

				<label for="rue">Rue<span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" value="" size="20" maxlength="60" required="required"/>
                <br />
                
                <label for="codepostal">Code Postal <span class="requis">*</span></label>
                <input type="number" id="codepostal" name="codepostal" value="" size="20" maxlength="60" required="required"/>
                <br />
                
                <label for="ville">Ville <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="" size="20" maxlength="60" required="required"/>
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
		 		<input type="button" value="Retour" onclick="history.go(-1)">
				
            </fieldset>
        </form>
    </body>
</html>