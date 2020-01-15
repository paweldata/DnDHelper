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
<h2>NPCs in campaign</h2>

	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/npc/create?campaignId=${campaign.id}">Create New NPC</a> 

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Secrets</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="npc" items="${npcs}">
			<c:url var="editNpc" value="/dungeon-master/campaign/npc/edit">
				<c:param name="npcId" value="${npc.id}"></c:param>
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			<tr>
				<td> ${npc.name} </td>
				<td> ${npc.description} </td>
				<td> ${npc.secrets} </td>
				<td> <a href="${editNpc}">Edit NPC</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/campaign?campaignId=${campaign.id}">Back to campaign</a>
	</p>	
</body>
</html>