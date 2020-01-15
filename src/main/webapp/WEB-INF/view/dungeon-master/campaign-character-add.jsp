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
			<th>Player</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="character" items="${characters}">
			<c:url var="addCharacter" value="/dungeon-master/campaign/character/add-character">
				<c:param name="characterNick" value="${character.nick}"></c:param>
			</c:url>
			<tr>
				<td> ${character.nick} </td>
				<td> <a href="${AddCharacter}">Add Character</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
</body>
</html>