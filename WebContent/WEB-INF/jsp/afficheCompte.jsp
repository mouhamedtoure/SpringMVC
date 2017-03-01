<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage des comptes</title>
</head>
<h1>
	<spring:message code="label.heading1" />
</h1>
<body>
	<table cellspacing="5" cellpadding="10">

		<tr align="left">
			<th><spring:message code="label.nom" /></th>

			<th><spring:message code="label.prenom" /></th>

			<th><spring:message code="label.dateNaissance" /></th>

			<th><spring:message code="label.email" /></th>

			<th><spring:message code="label.listeAdresses" /></th>

		</tr>

		<c:forEach items="${mesComptes}" var="compte">
			<tr align="left">


				<td>${compte.nom}</td>


				<td>${compte.prenom}</td>


				<td>${compte.dateNaissance}</td>


				<td>${compte.email}</td>


				<td><c:forEach items="${compte.listeAdresses}" var="adresse">
				<c:if test="${ not empty adresse}"> ${adresse}  <br>	
				</c:if>
				</c:forEach>
				<td>
			</tr>



		</c:forEach>

	</table>

</body>
</html>