<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Location info</h3>

	<table>
			<tr>
				<td>Name</td>
				<td>${location.name}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${location.description}</td>
			</tr>
		</table>
		
		<a href="${pageContext.request.contextPath}/player/campaign?campaignId=${campaign.id}&characterId=${character.id}">Back to character list</a>
</body>
</html>