<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Edit Npc</h2>
	
	<form:form action="npc-edit" modelAttribute="npc" method="POST" >			
		<table>
			<form:hidden path='campaign.id'/>
			<form:hidden path="id" />
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
					<td><input type="submit" value="Save"/></td>
				</tr>
			</tbody>
		</table>
			
	</form:form>
	
</body>
</html>