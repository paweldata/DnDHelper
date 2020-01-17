<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Admin View</h2>
<div>
	<input type="button" value="Monster Manual" onclick="window.location.href='monster_manual'; return false;"/>
	<input type="button" value="Item List" onclick="window.location.href='item_list'; return false;"/>
	<input type="button" value="Database Options" onclick="window.location.href='options'; return false;"/>
<table>

	
	<tr>
		<td><b>Player</b></td>
		<td><b>Dungeon Master</b></td>
	</tr>
<tr>
	<td>
		<table>
				<tr>
					<th>Nick</th>
					<th>Mail</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our characters -->
				<c:forEach var="tempPlayer" items="${playerList}">
					<c:url var="showCharactersListLink" value="/admin/player/character_list">
						<c:param name="playerNick" value="${tempPlayer.nick}"></c:param>
					</c:url>
					<c:url var="deletePlayerLink" value="/admin/player/delete_player">
						<c:param name="playerNick" value="${tempPlayer.nick}"></c:param>
					</c:url>
					<tr>
						<td> ${tempPlayer.nick} </td>
						<td> ${tempPlayer.mail} </td>
						<td> 
							<a href="${showCharactersListLink}">Show Character</a>
							|
							<a href="${deletePlayerLink}" onclick="if(!(confirm('Are you sure you want to delete this player?'))) return false">Delete Player</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
	</td>

	<td>
				<table>
				<tr>
					<th>Nick</th>
					<th>Mail</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our characters -->
				<c:forEach var="tempDM" items="${dungeonMasterList}">
					<c:url var="showCampaignsListLink" value="/admin/dm/campaign_list">
						<c:param name="dmNick" value="${tempDM.nick}"></c:param>
					</c:url>
					<c:url var="deleteDMLink" value="/admin/dm/delete_dm">
						<c:param name="dmNick" value="${tempDM.nick}"></c:param>
					</c:url>
					<tr>
						<td> ${tempDM.nick} </td>
						<td> ${tempDM.mail} </td>
						<td> 
							<a href="${showCampaignsListLink}">Campaigns</a>
							|
							<a href="${deleteDMLink}" onclick="if(!(confirm('Are you sure you want to delete this character?'))) return false">Delete DM</a>
						</td>
					</tr>
				</c:forEach>
				</table>
	</td>

</tr>
</table>
	
</div>
</body>
</html>
