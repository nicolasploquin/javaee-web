<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<c:url value="rechercher" var="urlRechercher" />
<c:url value="client-form.jsp" var="urlClientForm" />

	<h2>Rechercher</h2>
	<form method="post" action="${urlRechercher}">
		<label for="nom">Nom</label>
		<input type="text" id="nom" name="nom" placeholder="Nom" />
		<button type="submit" value="Client" name="type" >Client</button>
		<br/>
		<label for="numero">Numero</label>
		<input type="text" id="numero" name="numero" placeholder="Numero" />
		<button type="submit" value="Compte" name="type">Compte</button>
		<br/>
	</form>
<div>
		<a href="${urlClientForm}">Nouveau client</a>
</div>	


<h2>Liste des clients</h2>
<div class="liste clients">
<c:forEach items="${applicationScope.dao.readClients()}" var="client" >

<c:url value="rechercher" var="urlRechercherClient">
	<c:param name="nom" value="${client.nom}" />
</c:url>

<a href="${urlRechercherClient}" >
	${client.prenom} ${client.nom}
	<i class="material-icons">list_alt</i> 
</a>

</c:forEach>
</div>

<c:if test="${empty sessionScope.client}">
</c:if>


<c:if test="${not empty sessionScope.client}">

	<a href="#"><i class="material-icons">create</i></a>
	<h2>
	${sessionScope.client.prenom} ${sessionScope.client.nom}
	</h2>
	
	<div class="liste comptes">
		<table>
			<tbody>
<c:forEach items="${sessionScope.client.comptes}" var="compte">
				<tr>
					<td>${compte.numero}</td>
					<td>${compte.solde}</td>
					<td><a href="#">???</a></td>
				</tr>
</c:forEach>			
			</tbody>
		</table>
	</div>

</c:if>


<!--	
	<div class="liste comptes">
		<table>
			<tbody>
				<tr>
					<td>00000001</td>
					<td>705,00 €</td>
					<td><a href="rechercher?type=Compte&amp;numero=00000001">
						<img alt="détails" src="img/info_26.png">
					</a></td>
				</tr>
			</tbody>
		</table>
	</div>	
 -->	

<!--
	<div class="liste operations">
		<table>
			<thead><tr><th>Date</th><th>Libellé</th><th>Montant</th></tr></thead>
			<tbody>
				<tr><td>03/05/2011</td><td>Salaire Renault</td><td>1&nbsp;300,00 €</td></tr>
			</tbody>
		</table>
	</div>
 -->
<c:import url="footer.html" />
