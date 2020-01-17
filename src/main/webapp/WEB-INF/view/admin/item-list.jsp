<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<h3>Item list</h3>
	
	<a href="${pageContext.request.contextPath}/admin/item/create_item">Create New Item</a>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
		</tr>
			<c:forEach var="item" items="${items}">
				<c:url var="editItem" value="/admin/item/show_item">
					<c:param name="itemName" value="${item.name}"></c:param>
				</c:url>
				<c:url var="deleteItem" value="/admin/item/delete_item">
					<c:param name="itemName" value="${item.name}"></c:param>
				</c:url>
				<tr>
					<td> ${item.name} </td>
					<td> ${item.description} </td>
					<td> <a href="${editItem}">show item</a></td>
					<td> <a href="${deleteItem}"  onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">delete item</a></td>
				</tr>
			</c:forEach>
	</table>
	
	<a href="${pageContext.request.contextPath}/admin/menu">Back to menu</a>
	
</body>
</html>