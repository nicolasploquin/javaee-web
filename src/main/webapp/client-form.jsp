<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

	<h2>Création Client</h2>
	<form method="POST" action="client/form">
		<label for="nom">Nom</label>
		<input type="text" id="nom" name="nom" placeholder="Nom"
			value="${ param.nom }" />
		<br/>
		<label for="prenom">Prénom</label>
		<input type="text" 
			id="prenom" name="prenom" 
			placeholder="Prénom" 
			value="${ param.prenom }" />
		<br/>
		<button type="submit" value="Creer" name="type">
			<i class="material-icons">done</i> Créer
		</button>
	</form>
	
<c:import url="footer.html" />
	