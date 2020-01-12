<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Login as a Player, DungeonMaster or Admin!</h2>
<div>
	<form:form action="login_validate" modelAttribute="player" method="POST" >			
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
						<td><input type="submit" value="login"/></td>
					</tr>
				</tbody>
			</table>
		
		</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}">Back to logging options</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/player/create">Create Account</a>
	</p>
</div>
</body>
</html>
