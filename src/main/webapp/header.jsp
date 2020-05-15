<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/" />
<meta charset="UTF-8">
<title>Formation Java EE Web - ENI Service</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/banque.css" />
</head>
<body>
	<h1>Ma Banque</h1>
<c:if test="${not empty pageContext.request.remoteUser}">
	<p>${pageContext.request.remoteUser} <a href="deconnexion">Déconnexion</a></p>
</c:if>
<c:if test="${empty pageContext.request.remoteUser}">
	<a href="connexion">Connexion</a>
</c:if>
	
<!-- 	application.getAttribute("contextPath")
	application.getContextPath() -->