<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.title" /></title>
</head>
<body>
	 <h1><spring:message code="label.heading" /></h1>

	<form:form modelAttribute="compte" action="enregistrerCompte.htm"
		method="post">
		<table>
			<tr>
				<td><form:label path="nom" />
					<spring:message code="label.nom" /></td>

				<td><form:input path="nom" /></td>
				<td><form:errors path="nom" /></td>
			</tr>

			<tr>

				<td><form:label path="prenom" /><spring:message code="label.prenom" /></td>
				<td><form:input path="prenom" /></td>
				<td><form:errors path="prenom" /></td>

			</tr>
			<tr>
				<td><form:label path="age" /><spring:message code="label.age" /></td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" /></td>

			</tr>

			<tr>
				<td ><form:label path="email" /><spring:message code="label.email" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>

			</tr>
			<tr>

				<td colspan="10"><form:button name="enregistrer" value="enregistrer"> <spring:message code="label.button" />  </form:button>
				</td>
			</tr>
		</table>

		<a href="english.htm"> English</a> | <a href="french.htm"> French</a>
	</form:form>


</body>
</html>