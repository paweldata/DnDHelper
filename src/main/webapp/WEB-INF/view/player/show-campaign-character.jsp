<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<h3>Character info</h3>

	<table>
			<tr>
				<td>Name</td>
				<td>${characterShow.name}</td>
			</tr>
			<tr>
				<td>Level</td>
				<td>${characterShow.level}</td>
			</tr>
			<tr>
				<td>Exp</td>
				<td>${characterShow.exp}</td>
			</tr>
			<tr>
				<td>Race</td>
				<td>${characterShow.race}</td>
			</tr>
			<tr>
				<td>Class</td>
				<td>${characterShow.charClass}</td>
			</tr>
			<tr>
				<td>Allignment</td>
				<td>${characterShow.allignment}</td>
			</tr>
			<tr>
				<td>Armor Class</td>
				<td>${characterShow.armorClass}</td>
			</tr>
			<tr>
				<td>Hit points</td>
				<td>${characterShow.hitPoints}</td>
			</tr>
			<tr>
				<td>Speed</td>
				<td>${characterShow.speed}</td>
			</tr>
			<tr>
				<td>Strength</td>
				<td>${characterShow.strength}</td>
			</tr>
			<tr>
				<td>Dexternity</td>
				<td>${characterShow.dexternity}</td>
			</tr>
			<tr>
				<td>Constitution</td>
				<td>${characterShow.constitution}</td>
			</tr>
			<tr>
				<td>Intelligence</td>
				<td>${characterShow.intelligence}</td>
			</tr>
			<tr>
				<td>Wisdom</td>
				<td>${characterShow.wisdom}</td>
			</tr>
			<tr>
				<td>Charisma</td>
				<td>${characterShow.charisma}</td>
			</tr>
			<tr>
				<td>Background</td>
				<td>${characterShow.background}</td>
			</tr>
		</table>
		
		<a href="${pageContext.request.contextPath}/player/campaign?campaignId=${campaign.id}&characterId=${character.id}">Back to character list</a>
</body>
</html>