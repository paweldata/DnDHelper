<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h2>Create new campaign</h2>
	<div>
		<form:form action="campaign-create" modelAttribute="campaign" method="POST" >			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name"/></td>
					</tr>
								
					<tr>
						<td><input type="submit" value="create"/></td>
					</tr>
				</tbody>
			</table>
	</form:form>
	</div>
	
	<p>
		<a href="${pageContext.request.contextPath}/dungeon-master/main/">Back to main</a>
	</p>
	
</body>
</html>