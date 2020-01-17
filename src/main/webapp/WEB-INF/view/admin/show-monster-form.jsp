<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Monster Form</title>
</head>
<body>
<img alt="Stats image not added." src="data:image/jpeg;base64,${statImage}" />
<h2>Monster Form</h2>
  <form:form action="save_monster" modelAttribute="monster" method="POST" enctype="multipart/form-data">			
			<table>
				<tbody>
					<form:hidden  path="id"/>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input  path="name" required="required"/></td>
					</tr>
					<tr>
						<td><label>Hitpoints:</label></td>
							<td><form:input  path="hitPoints" required="required"/></td>
					</tr>
					<tr>
						<td><label>Armor Class:</label></td>
						<td><form:input  path="armorClass" required="required"/></td>
					</tr>
					<tr>
						<td><label>Speed:</label></td>
						<td><form:input  path="speed" required="required"/></td>
					</tr>	
					<tr>
						<td><label>Challenge:</label></td>
						<td><form:input type="number" step="0.01" path="challenge" required="required"/></td>
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
						<td><form:input type="number" path="constitution"/></td>
					</tr>
					<tr>
						<td><label>Intelligence:</label></td>
						<td><form:input type="number" path="intelligence"/></td>
					</tr>
					<tr>
						<td><label>Wisdom:</label></td>
						<td><form:input type="number" path="wisdom"/></td>
					</tr>
					<tr>
						<td><label>Charisma:</label></td>
						<td><form:input type="number" path="charisma"/></td>
					</tr>	
					<tr>
						<td><label>Image:</label></td>
						<td><form:input type="file" path="image"/></td>
					</tr>	
					<tr>
						<td><input type="submit" value="Save"/></td>
					</tr>
				</tbody>
			</table>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/admin/monster_manual">Monster Manual</a>
	</p>	
</body>
</html>