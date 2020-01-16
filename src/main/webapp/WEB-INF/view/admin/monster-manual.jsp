<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Monster Manual</h2>
<div>
	<input type="button" value="Create Monster" onclick="window.location.href='monster_manual/create'; return false;"/>
	<table>
				<tr>
					<th>Name</th>
					<th>Hitpoints</th>
					<th>Armour Class</th>
					<th>Speed</th>
					<th>Challenge</th>
					<th>STR</th>
					<th>DEX</th>
					<th>CON</th>
					<th>INT</th>
					<th>WIS</th>
					<th>CHA</th>
					<th>Actions</th>
				</tr>
				
				<!-- loop over and print our characters -->
				<c:forEach var="tempMonster" items="${monsterList}">
					<c:url var="showMonsterLink" value="/admin/monster_manual/show">
						<c:param name="monsterId" value="${tempMonster.id}"></c:param>
					</c:url>
					<c:url var="deleteMonsterLink" value="/admin/monster_manual/delete_monster">
						<c:param name="monsterId" value="${tempMonster.id}"></c:param>
					</c:url>
					<tr>
						<td> ${tempMonster.name} </td>
						<td> ${tempMonster.hitPoints} </td>
						<td> ${tempMonster.armorClass} </td>
						<td> ${tempMonster.speed} </td>
						<td> ${tempMonster.challenge} </td>
						<td> ${tempMonster.strength} </td>
						<td> ${tempMonster.dexternity} </td>
						<td> ${tempMonster.constitution} </td>
						<td> ${tempMonster.intelligence} </td>
						<td> ${tempMonster.wisdom} </td>
						<td> ${tempMonster.charisma} </td>
						<td> 
							<a href="${showMonsterLink}">Show Monster</a>
							|
							<a href="${deleteMonsterLink}" onclick="if(!(confirm('Are you sure you want to delete this monster?'))) return false">Delete Monster</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
			<a href="${pageContext.request.contextPath}/admin/menu">Main View</a>
</div>
</body>
</html>
