<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ctg" uri="customtags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<fmt:setLocale value="${sessionScope.localisation}" />

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" type="text/css"
	href="sources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="sources/css/main.css" />
<script type="text/javascript" src="sources/js/AllPageScript.js"></script>
<link rel="icon" href="sources/images/logo-airline.png"
	type="image/icon type" />
<title>Select Crew</title>
</head>

<body>

	<c:set var="current_page" value="flight_schedule" scope="session" />

	<fmt:bundle basename="ui">
	
		<c:import url="Header.jsp" />
		
		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.flight_schedule" />
					</h3>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-12 card border-primary">

						<div>

							<table
								class="table table-hover table-striped table-bordered table-sm">

								<col width="90" />
								<col width="90" />
								<col width="70" />
								<col width="70" />
								<col width="100" />

								<tr>
									<th><fmt:message key="column.flight_departure_airport" /></th>
									<th><fmt:message key="column.flight_destination_airport" /></th>
									<th><fmt:message key="column.flight_departure_time" /></th>
									<th><fmt:message key="column.flight_landing_time" /></th>
									<th><fmt:message key="column.flight_aircraft" /></th>
								</tr>

								<c:forEach var="elem" items="${sessionScope.all_flights_list}">

									<tr>
										<td>${elem.departureAirport.airportCity}</td>
										<td>${elem.destinationAirport.airportCity}</td>
										<td><fmt:formatDate value="${elem.departureTime}"
												pattern="dd-MM-yyyy HH:mm" /></td>
										<td><fmt:formatDate value="${elem.landingTime}"
												pattern="dd-MM-yyyy HH:mm" /></td>
										<td>${elem.aircraft.aircraftModel.aircraftModelName}</td>
									</tr>

								</c:forEach>

							</table>
						</div>
					</div>
				</div>
			</div>	
		</div>

		<c:import url="Footer.jsp" />

	</fmt:bundle>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>

</html>