<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css"
		rel="stylesheet"
		href="resources/css/style.css">
		
<script>
MyFunction = function(){
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
}
</script>

<style>
.collapsible {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

/* Add a background color to the button if it is clicked on (add the .active class with JS), and when you move the mouse over it (hover) */
.active, .collapsible:hover {
  background-color: #ccc;
}

/* Style the collapsible content. Note: hidden by default */
.content {
  padding: 0 18px;
  display: none;
  overflow: hidden;
  background-color: #f1f1f1;
}
</style>
</head>
<body onload="javascript:MyFunction()">
	<h2>Edit location</h2>
	
	<form:form action="location-edit" modelAttribute="location" method="POST" >			
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
					<td><form:textarea path="description" rows="3" cols="20"/></td>
				</tr>
				<tr>
					<td><label>Secrets:</label></td>
					<td><form:textarea path="secrets" rows="3" cols="20"/></td>
				</tr>		
				<tr>
					<td><input type="submit" value="Save"/></td>
				</tr>
			</tbody>
		</table>
			
	</form:form>
	<c:url var="addMonster" value="add_monster_edit">
			<c:param name="campaignId" value="${campaign.id}"></c:param>
			<c:param name="locationId" value="${location.id}"></c:param>
	</c:url>

	<form:form action="${addMonster}" modelAttribute="monster" method="POST" >
			<tr>
				<th>
					<form:select path="id">
						<form:option value="-1" label="--Please Select"/>
						<form:options items="${monsters}"  itemValue="id" itemLabel="name" type="number"/>
					</form:select>
				</th>
				<th><input type="submit" value="save"/></th>
			</tr>
	</form:form>
				<!-- loop over and print our characters -->
				<c:forEach var="tempMonster" items="${addedMonsters}">
					<c:url var="deleteMonster" value="delete_monster">
						<c:param name="campaignId" value="${campaign.id}"></c:param>
						<c:param name="locationId" value="${location.id}"></c:param>
						<c:param name="monsterId" value="${tempMonster.id}"></c:param>
					</c:url>
				<table>
				<tr>
					<th>Name</th>
					<th>Hitpoints</th>
					<th>Armour Class</th>
					<th>Speed</th>
					<th>Challenge</th>
					<th>STR</th>
					<th>DEX</th>
					<th>CON</th>
					<th>INT</th>
					<th>WIS</th>
					<th>CHA</th>
					<th>Action</th>
				</tr>
					<tr>
						<td> ${tempMonster.name} </td>
						<td> ${tempMonster.hitPoints} </td>
						<td> ${tempMonster.armorClass} </td>
						<td> ${tempMonster.speed} </td>
						<td> ${tempMonster.challenge} </td>
						<td> ${tempMonster.strength} </td>
						<td> ${tempMonster.dexternity} </td>
						<td> ${tempMonster.constitution} </td>
						<td> ${tempMonster.intelligence} </td>
						<td> ${tempMonster.wisdom} </td>
						<td> ${tempMonster.charisma} </td>
						<td><button type="button" class="delete" onclick="window.location.href='${deleteMonster}'; return false;">Delete Monster</button></td>
					</tr>
					</table>
					<table>
					<tr>
						<td>
						<button type="button" class="collapsible">Open Stat Image</button>
						<div class="content">
  							<img alt="Stats image not added." src="data:image/jpeg;base64,${tempMonster.image}" />
						</div>
						</td>
					</tr>
					</table>
				</c:forEach>

	
</body>
</html>