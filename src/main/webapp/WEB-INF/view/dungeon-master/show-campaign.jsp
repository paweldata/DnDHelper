<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character list</title>
</head>
<body>
<h2>Your Campaign!</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>${campaign.name}</th>
		</tr>
	</table>
	<form:form action="campaign/characters" modelAttribute="campaign" method="POST">
		<form:input type="hidden" path="id" value="${campaign.id}" />
		<input type="submit" value="Characters" />
	</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/campaigns">Back to campaigns</a>
	</p>	
</body>
</html>