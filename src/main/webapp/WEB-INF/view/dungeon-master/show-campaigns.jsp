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
<h2>Your Campaigns List!</h2>
  <a href="${pageContext.request.contextPath}/dungeon-master/campaign/create">Create New Campaign</a> 
  
	<table>
		<tr>
			<th>Name</th>
		</tr>
		
		<!-- loop over and print our campaigns -->
		<c:forEach var="campaign" items="${campaignList}">
			<c:url var="showCampaign" value="/dungeon-master/show-campaign">
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			<tr>
				<td> ${campaign.name} </td>
				<td> <a href="${showCampaign}">Show Campaign</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/main">Back to Dungeon Master options</a>
	</p>	
</body>
</html>