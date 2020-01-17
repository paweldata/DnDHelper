<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Create DungeonMaster account</h2>
<div>
	<form:form action="create_account" modelAttribute="dungeon_master" method="POST" >			
			<table>
				<tbody>
					<tr>
						<td><label>Login:</label></td>
						<td><form:input path="nick"/></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password"/></td>
					</tr>
					<tr>
						<td><label>Mail:</label></td>
						<td><form:input type="email" path="mail"/></td>
					</tr>					
					<tr>
						<td><input type="submit" value="create"/></td>
					</tr>
				</tbody>
			</table>
	</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}">Back to logging options</a>
	</p>
</div>
</body>
</html>
