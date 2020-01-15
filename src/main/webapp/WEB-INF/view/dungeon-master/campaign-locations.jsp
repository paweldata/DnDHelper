<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location list</title>
</head>
<body>
<h2>Locations in campaign</h2>

	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/location/create?campaignId=${campaign.id}">Create New Location</a> 

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Secrets</th>
		</tr>
		
		<!-- loop over and print our locations -->
		<c:forEach var="location" items="${locations}">
			<c:url var="editLocation" value="/dungeon-master/campaign/location/edit">
				<c:param name="locationId" value="${location.id}"></c:param>
				<c:param name="campaignId" value="${campaign.id}"></c:param>
			</c:url>
			
			<tr>
				<td> ${location.name} </td>
				<td> ${location.description} </td>
				<td> ${location.secrets} </td>
				<td> <a href="${editLocation}">Edit Location</a></td>
			</tr>
		</c:forEach>	
		
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/campaign?campaignId=${campaign.id}">Back to campaign</a>
	</p>	
</body>
</html>