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
<h2>Your Characters List!</h2>
  <form:form action="save_character" modelAttribute="character" method="POST" >			
			<table>
				<tbody>
					<form:hidden path="id" />
					<tr>
						<td><label>Name:</label></td>
						<td><form:input  path="name" required="required"/></td>
					</tr>
					<tr>
						<td><label>Race:</label></td>
						<td>
							<form:select path="race">
    							<form:options items="${races}" itemValue="race" itemLabel="race" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label>Class:</label></td>
						<td>
							<form:select path="charClass">
    							<form:options items="${classes}" itemValue="dndClass" itemLabel="dndClass" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label>Allignment:</label></td>
						<td>
							<form:select path="allignment">
    							<form:options items="${allignments}" itemValue="shortName" itemLabel="fullName" />
							</form:select>
						</td>
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
						<td><form:textarea rows="5" cols="25" path="background" required="required"/></td>
					</tr>		
					<tr>
						<td><input type="submit" value="Save"/></td>
					</tr>
					
					
					
				</tbody>
			</table>
	</form:form>
	
	<c:url var="add_item" value="add_item_to_character">
			<c:param name="characterId" value="${character.id}"></c:param>
	</c:url>

	<form:form action="${add_item}" modelAttribute="item" method="POST" >
			<tr>
				<th>
					<form:select path="name">
						<form:option value="-1" label="--Please Select"/>
						<form:options items="${items}"  itemValue="name" itemLabel="name" type="number"/>
					</form:select>
				</th>
				<th><input type="submit" value="save"/></th>
			</tr>
	</form:form>
	
	<c:forEach var="item" items="${characterItems}">
		<c:url var="deleteItem" value="delete_item">
			<c:param name="itemName" value="${item.name}"></c:param>
			<c:param name="characterId" value="${character.id}"></c:param>
		</c:url>
		<table>
			<tr>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<tr>
				<td> ${item.name} </td>
				<td> ${item.description} </td>
				<td><button type="button" class="delete" onclick="window.location.href='${deleteItem}'; return false;">Delete Item</button></td>
			</tr>
		</table>
	</c:forEach>
	
	<p>
		<a href="${pageContext.request.contextPath}/player/menu">Back to Player options</a>
	</p>	
</body>
</html>
