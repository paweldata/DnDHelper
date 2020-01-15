<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Your Campaign!</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>${campaign.name}</th>
		</tr>
	</table>
	<table>
		<tr>
			<th>
				<form:form action="campaign/characters" modelAttribute="campaign" method="POST">
					<form:input type="hidden" path="id" value="${campaign.id}" />
					<input type="submit" value="Characters" />
				</form:form>
			</th>
			<th>
				<form:form action="campaign/locations" modelAttribute="campaign" method="POST">
					<form:input type="hidden" path="id" value="${campaign.id}" />
					<input type="submit" value="Locations" />
				</form:form>
			</th>
			<th>
				<form:form action="campaign/npc" modelAttribute="campaign" method="POST">
					<form:input type="hidden" path="id" value="${campaign.id}" />
					<input type="submit" value="NPCs" />
				</form:form>
			</th>
		</tr>
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/main">Back to main</a>
	</p>	
</body>
</html>