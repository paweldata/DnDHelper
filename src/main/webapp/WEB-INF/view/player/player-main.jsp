<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>WElcome to Player Page!!</h2>
<div>
	 <a href="${pageContext.request.contextPath}/player/character/create_character">Create New Character</a> 
	<table>
				<tr>
					<th>Name</th>
					<th>Race</th>
					<th>Class</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our characters -->
				<c:forEach var="tempCharacter" items="${characterList}">
					<c:url var="showCharacterLink" value="/player/character/show_character">
						<c:param name="characterId" value="${tempCharacter.id}"></c:param>
					</c:url>
					<c:url var="showCampaignsLink" value="/player/character/show_campaigns">
						<c:param name="characterId" value="${tempCharacter.id}"></c:param>
					</c:url>
					<c:url var="deleteCharacterLink" value="/player/character/delete_character">
						<c:param name="characterId" value="${tempCharacter.id}"></c:param>
					</c:url>
					<tr>
						<td> ${tempCharacter.name} </td>
						<td> ${tempCharacter.race} </td>
						<td> ${tempCharacter.charClass} </td>
						<td> 
							<a href="${showCharacterLink}">Show Character</a>
							|
							<a href="${showCampaignsLink}">Campaigns</a>
							|
							<a href="${deleteCharacterLink}" onclick="if(!(confirm('Are you sure you want to delete this character?'))) return false">Delete Character</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
</div>
</body>
</html>
