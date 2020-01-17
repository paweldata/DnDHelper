<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
	<table>
		<tr>
			<th>Characters</th>
			<th>Locations</th>
			<th>Npc</th>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<th>Name</th>
						<th>Level</th>
						<th>Race</th>
						<th>Class</th>
					</tr>
					
					<c:forEach var="tempCharacter" items="${characters}">
						<c:url var="showCharacter" value="/player/campaign/show-character">
							<c:param name="characterShowId" value="${tempCharacter.id}"></c:param>
							<c:param name="campaignId" value="${campaign.id}"></c:param>
							<c:param name="characterId" value="${character.id}"></c:param>
						</c:url>
						<tr>
							<td> ${tempCharacter.name} </td>
							<td> ${tempCharacter.level} </td>
							<td> ${tempCharacter.race} </td>
							<td> ${tempCharacter.charClass} </td>
							<td> <a href="${showCharacter}">Show Character</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>

			<td>
				<table>
					<tr>
						<th>Name</th>
					</tr>
					
					<c:forEach var="location" items="${locations}">
						<c:url var="showLocation" value="/player/campaign/show-location">
							<c:param name="locationId" value="${location.id}"></c:param>
							<c:param name="campaignId" value="${campaign.id}"></c:param>
							<c:param name="characterId" value="${character.id}"></c:param>
						</c:url>
						<tr>
							<td> ${location.name} </td>
							<td> <a href="${showLocation}">Show Location</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
			
			<td>
				<table>
					<tr>
						<th>Name</th>
						<th>Description</th>
					</tr>
					
					<c:forEach var="npc" items="${npcs}">
						<c:url var="showNpc" value="/player/campaign/show-npc">
							<c:param name="npcId" value="${npc.id}"></c:param>
							<c:param name="campaignId" value="${campaign.id}"></c:param>
							<c:param name="characterId" value="${character.id}"></c:param>
						</c:url>
						<tr>
							<td> ${npc.name} </td>
							<td> <a href="${showNpc}">Show Npc</a></td>
						</tr>
					</c:forEach>
				</table>
			</td>
			
		</tr>
	</table>
	
	<a href="${pageContext.request.contextPath}/player/character/show_campaigns?characterId=${character.id}">Back to campaign list</a>
	
</body>
</html>