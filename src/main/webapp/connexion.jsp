<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

	<h2>Authentification</h2>
	<form method="post" action="j_security_check">
		<label for="login">Login</label>
		<input type="text" id="login" name="j_username" placeholder="Login" />
		<br/>
		<label for="password">Password</label>
		<input type="password" id="password" name="j_password" placeholder="Password" />
		<br/>
		<button type="submit">Connexion</button>
	</form>
	
<c:import url="footer.html" />
