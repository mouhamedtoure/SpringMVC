<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Ceci est la page de saisie des adresses.

	
	
	
	<form  action="affichePageAdresse.htm" method="post">

		
           <label for="type">Type<span class="requis">*</span></label>
                <input type="text" id="type" name="type" value="${type}" />

			
</form>

</body>
</html>