<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<h1>Restaurant Ratings</h1>

	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="items" items="${items}">
				<tr>
					<td>${items.name}</td>
					<td>${items.rating}</td>
					<td>
						<!-- <a href="/products/update?id=${ product.id }" class="btn btn-light btn-sm">Edit</a> -->
						<a href="/restaurant/uprate?id=${ items.id }"
						class="btn btn-light btn-sm">Up Rating</a> <a
						href="/restaurant/downrate?id=${ items.id }"
						class="btn btn-light btn-sm">Down Rating</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>