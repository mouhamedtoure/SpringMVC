<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ma première JSP Spring !

	<form:form modelAttribute="compte" action="enregistrerCompte.htm"
		method="post">
		<table>
			<tr>
				<td><form:label path="nom"/>Nom</td>
				<td><form:input path="nom" /></td>
				<td><form:errors path="nom"/></td>
			</tr>

			<tr>

				<td><form:label path="prenom"/>Prénom</td>
				<td><form:input path="prenom" /></td>
				<td><form:errors path="prenom"/></td>

			</tr>
			<tr>
				<td><form:label path="age"/>Age</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age"/></td>

			</tr>
		<tr>
		<td> <form:button name="enregistrer" value="enregistrer"> Enregistrer  </form:button> </td>
		</tr>
			</table>
	</form:form>


</body>
</html>