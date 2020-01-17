<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<h2>DungeonMaster</h2>
	<input type="button" value="Monster Manual" onclick="window.location.href='monster_manual'; return false;"/>
	<h2>Your Campaigns List!</h2>
	
  	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/create">Create New Campaign</a> 
  
	<table>
		<tr>
			<th>Name</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="campaign" items="${dungeonMaster.campaigns}">
			<c:url var="showCampaign" value="/dungeon-master/campaign">
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			<tr>
				<td> ${campaign.name} </td>
				<td> <a href="${showCampaign}">Show Campaign</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<input type="button" value="Logout" onclick="window.location.href='logout'; return false;"/>
	
</body>
</html>