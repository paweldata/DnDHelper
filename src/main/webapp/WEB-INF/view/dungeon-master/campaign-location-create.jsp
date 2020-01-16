<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Add new location</h2>
	
	<form:form action="location-create" modelAttribute="location" method="POST" >			
		<table>
			<form:hidden path="campaign.id"/>
			<tbody>
				<tr>
					<td><label>Name:</label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><label>Description:</label></td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td><label>Secrets:</label></td>
					<td><form:input path="secrets"/></td>
				</tr>		
				<tr>
					<td><input type="submit" value="create"/></td>
				</tr>
			</tbody>
		</table>
			
	</form:form>
	
	<a href="${pageContext.request.contextPath}/dungeon-master/campaign/locations?campaignId=${campaign.id}">Back to locations list</a> 
	
</body>
</html>