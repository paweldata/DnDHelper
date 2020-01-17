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
<h2>Characters in campaign</h2>

	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/character/add?campaignId=${campaign.id}">Add New Character</a> 

	<table>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Exp</th>
			<th>Race</th>
			<th>Class</th>
			<th>Allignment</th>
			<th>AC</th>
			<th>HP</th>
			<th>Speed</th>
			<th>STR</th>
			<th>DEX</th>
			<th>CON</th>
			<th>INT</th>
			<th>WIS</th>
			<th>CHA</th>
			<th>Background</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="character" items="${characters}">
			<c:url var="deleteCharacter" value="/dungeon-master/campaign/character/delete">
				<c:param name="characterId" value="${character.id}"></c:param>
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			<tr>
				<td> ${character.name} </td>
				<td> ${character.level} </td>
				<td> ${character.exp} </td>
				<td> ${character.race} </td>
				<td> ${character.charClass} </td>
				<td> ${character.allignment} </td>
				<td> ${character.armorClass} </td>
				<td> ${character.hitPoints} </td>
				<td> ${character.speed} </td>
				<td> ${character.strength} </td>
				<td> ${character.dexternity} </td>
				<td> ${character.constitution} </td>
				<td> ${character.intelligence} </td>
				<td> ${character.wisdom} </td>
				<td> ${character.charisma} </td>
				<td> ${character.background} </td>
				
				<td> <a href="${deleteCharacter}" onclick="if(!(confirm('Are you sure you want to delete this character from campaign?'))) return false">Delete Character</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<br></br>
	
	<form action="giveExp" method="get">			
		<table>
			<tbody>
				<input type="hidden" name="campaignId" value="${campaign.id}"/>
				<tr>
					<td><label>Exp:</label></td>
					<td><input type="text" name="exp"/></td>
				</tr>
				<tr>
					<td><label>Max exp:</label></td>
					<td><input type="text" name="maxExp"/></td>
				</tr>		
				<tr>
					<td><input type="submit" value="Add"/></td>
				</tr>
			</tbody>
		</table>
			
	</form>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/campaign?campaignId=${campaign.id}">Back to campaign</a>
	</p>	
</body>
</html>