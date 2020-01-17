<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Add new location</h2>
	
	<form:form action="location-create" modelAttribute="location" method="POST" >			
		<table>
			<form:hidden path="campaign.id"/>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><label>Description:</label></td>
					<td><form:textarea path="description" rows="3" cols="20"/></td>
				</tr>
				<tr>
					<td><label>Secrets:</label></td>
					<td><form:textarea path="secrets" rows="3" cols="20"/></td>
				</tr>		
				<tr>
					<td><input type="submit" value="create"/></td>
				</tr>
			</tbody>
		</table>	
	</form:form>
	<c:url var="addMonster" value="add_monster">
			<c:param name="campaignId" value="${campaign.id}"></c:param>
			<c:param name="locationId" value="${location.id}"></c:param>
	</c:url>
	<form:form action="${addMonster}" modelAttribute="monster" method="POST" >
			<tr>
				<th>
					<form:select path="id">
						<form:option value="-1" label="--Please Select"/>
						<form:options items="${monsters}"  itemValue="id" itemLabel="name" type="number"/>
					</form:select>
				</th>
				<th><input type="submit" value="save"/></th>
			</tr>
	</form:form>
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
				</tr>
				
				<!-- loop over and print our characters -->
				<c:forEach var="tempMonster" items="${addedMonsters}">
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
					</tr>
				</c:forEach>
						
			</table>
	
	
	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/locations?campaignId=${campaign.id}">Back to locations list</a> 
	
</body>
</html>