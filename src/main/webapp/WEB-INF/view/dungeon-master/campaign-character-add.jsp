<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Add new character</h2>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Race</th>
			<th>Class</th>
			<th>Player</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="character" items="${characters}">
			<c:url var="addCharacter" value="/dungeon-master/campaign/character/add-character">
				<c:param name="characterId" value="${character.id}"></c:param>
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			<tr>
				<td> ${character.name} </td>
				<td> ${character.race} </td>
				<td> ${character.charClass} </td>
				<td> ${character.player.nick} </td>
				<td> <a href="${addCharacter}">Add Character</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/characters?campaignId=${campaign.id}">Back to characters list</a> 
	
</body>
</html>