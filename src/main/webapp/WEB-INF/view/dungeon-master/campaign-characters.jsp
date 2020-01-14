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

	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/character/add">Add New Character</a> 

	<table>
		<tr>
			<th>Name</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="character" items="${characterList}">
			<c:url var="showCharacter" value="/dungeon-master/show-character">
				<c:param name="characterNick" value="${character.nick}"></c:param>
			</c:url>
			<tr>
				<td> ${character.nick} </td>
				<td> <a href="${showCharacter}">Show Character</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/show-campaign?campaignId=${campaign.id}">Back to campaign</a>
	</p>	
</body>
</html>