<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Create new Item</h2>
  <form:form action="save_item" modelAttribute="item" method="POST" >			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input  path="name" required="required"/></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input  path="description" required="required"/></td>
					</tr>		
					<tr>
						<td><input type="submit" value="Save"/></td>
					</tr>
				</tbody>
			</table>
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath}/admin/item_list">Back to Item list</a>
	</p>	
</body>
</html>