<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="label.heading" />

	</h1>

	<a href="afficheCompte.htm"> <spring:message code="label.href" />
	</a>
	<br>
	<br>
	<form:form modelAttribute="compte" action="affichePageAdresse.htm"
		method="post">


		<table>
			<tr>
				<td><form:label path="nom" /> <spring:message code="label.nom" /></td>

				<td><form:input path="nom" /></td>
				<td><form:errors path="nom" /></td>
			</tr>

			<tr>
				<td><form:label path="prenom" /> <spring:message
						code="label.prenom" /></td>
				<td><form:input path="prenom" /></td>
				<td><form:errors path="prenom" /></td>

			</tr>
			<tr>
				<td><form:label path="dateNaissance" /> <spring:message
						code="label.dateNaissance" /></td>
				<td><form:input path="dateNaissance" /></td>
				<td><form:errors path="dateNaissance" /></td>

			</tr>

			<tr>
				<td><form:label path="email" /> <spring:message
						code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>

			</tr>
			<tr>

				<td colspan="10"><form:button name="enregistrer"
						value="enregistrer">
						<spring:message code="label.button" />
					</form:button></td>
			</tr>
		</table>
		<a href="english.htm"> English</a> | <a href="french.htm"> French</a>
		</form:form>
		<br>
		<form action="rechercherCompteParId.htm" method="post">
			<label>email</label>
			<input name="email" />
			<input type= "submit" name="rechercher" value="Rechercher" /> 
		
			
		</form>
</body>
</html>