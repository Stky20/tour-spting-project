<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>FirstDate</th>
					<th>Amount Of Days</th>
					<th>Place</th>
					<th>Description</th>
				</tr>

				<!-- loop over and print our tour -->
				<c:forEach var="tempTour" items="${tourList}">

					<tr>
						<td>${tempTour.id}</td>
						<td>${tempTour.name}</td>
						<td>${tempTour.firstDateOfTour}</td>
						<td>${tempTour.amountOfDays}</td>
						<td>${tempTour.place}</td>
						<td>${tempTour.description}</td>
					</tr>

				</c:forEach>

			</table>
</body>
</html>