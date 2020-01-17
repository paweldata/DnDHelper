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
<h2>Your Campaign List!</h2>

	<table>
		<tr>
			<th>Name</th>
		</tr>

		<c:forEach var="campaign" items="${character.campaigns}">
			<c:url var="showCampaign" value="/player/campaign">
				<c:param name="campaignId" value="${campaign.id}"></c:param>
				<c:param name="characterId" value="${character.id}"></c:param>
			</c:url>
			<tr>
				<td> ${campaign.name} </td>
				<td> <a href="${showCampaign}">Show campaign</a></td>
			</tr>
		</c:forEach>
	
	</table>
		
	<p>
		<a href="${pageContext.request.contextPath}/player/menu">Back to Player options</a>
	</p>	
</body>
</html>