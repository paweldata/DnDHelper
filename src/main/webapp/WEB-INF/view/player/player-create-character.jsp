<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Charcter Creation</title>
</head>
<body>
<h2>New Character Creationn:</h2>
<form:form action="create_character" modelAttribute="character" method="POST" >			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input  path="name" required="required"/></td>
					</tr>
					<tr>
						<td><label>Race:</label></td>
						<td><form:input path="race" required="required"/></td>
					</tr>
					<tr>
						<td><label>Class:</label></td>
						<td><form:input path="charClass" required="required"/></td>
					</tr>
					<tr>
						<td><label>Allignment:</label></td>
						<td><form:select path="allignment">
    						<form:options items="${allignments}" itemValue="shortName" itemLabel="fullName" />
						</form:select></td>
					</tr>	
					<tr>
						<td><label>Level:</label></td>
						<td><form:input type="number" path="level" value="1" required="required"/></td>
					</tr>
					<tr>
						<td><label>Experience:</label></td>
						<td><form:input type="number" path="exp" value="0" required="required"/></td>
					</tr>
					<tr>
						<td><label>Armor Class:</label></td>
						<td><form:input type="number" path="armorClass" required="required"/></td>
					</tr>		
					<tr>
						<td><label>Speed:</label></td>
						<td><form:input type="number" path="speed" required="required"/></td>
					</tr>
					<tr>
						<td><label>Strength:</label></td>
						<td><form:input type="number" path="strength" required="required"/></td>
					</tr>
					<tr>
						<td><label>Dexternity:</label></td>
						<td><form:input type="number" path="dexternity" required="required"/></td>
					</tr>
					<tr>
						<td><label>Constitution:</label></td>
						<td><form:input type="number" path="constitution" required="required"/></td>
					</tr>
					<tr>
						<td><label>Intelligence:</label></td>
						<td><form:input type="number" path="intelligence" required="required"/></td>
					</tr>
					<tr>
						<td><label>Wisdom:</label></td>
						<td><form:input type="number" path="wisdom" required="required"/></td>
					</tr>
					<tr>
						<td><label>Charisma:</label></td>
						<td><form:input type="number" path="charisma" required="required"/></td>
					</tr>	
										
					<tr>
						<td><label>Background:</label></td>
						<td><form:input path="background" required="required"/></td>
					</tr>		
					<tr>
						<td><input type="submit" value="create"/></td>
					</tr>
				</tbody>
			</table>
	</form:form>
	
	<p>
		<a href="${pageContext.request.contextPath}/player/characters/">Back to characters</a>
	</p>
</body>
</html>