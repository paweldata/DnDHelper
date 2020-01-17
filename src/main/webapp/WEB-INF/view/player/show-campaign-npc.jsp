<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Npc info</h3>

	<table>
			<tr>
				<td>Name</td>
				<td>${npc.name}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${npc.description}</td>
			</tr>
		</table>
		
		<a href="${pageContext.request.contextPath}/player/campaign?campaignId=${campaign.id}&characterId=${character.id}">Back to character list</a>
</body>
</html>