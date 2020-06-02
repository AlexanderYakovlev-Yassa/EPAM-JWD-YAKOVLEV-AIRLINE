<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ctg" uri="customtags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<link rel="stylesheet" type="text/css" href="sources/css/bootstrap.min.css" />
	<link rel="icon" href="sources/images/logo-airline.png" type="image/icon type" />
	<script type="text/javascript" src="sources/js/AllPageScript.js"></script>
	<title>Flight Manager</title>
</head>

<body onload="message()">

	<fmt:setLocale value="${sessionScope.localisation}" />
	<c:set var="current_page" value="employee-flights" scope="session" />

	<fmt:bundle basename="ui">
	
		<%@ include file="Header.jsp" %>
		<%@ include file="ModalWindowStatusOperationMessage.jsp" %>
		
					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.flight_schedule_for" />
						${sessionScope.selected_employee.firstName}
						${sessionScope.selected_employee.lastName}
					</h3>		
					
					<div class="container">	
						<div class="row">
							<div class="col-12 card border-primary">
								<h4 class="text-center text-primary pt-5">
									<fmt:message key="label.flight_info"/>
								</h4>
								
									<div class="container">
										<div class="row">									
											<div class="col-md-6">
												<div class="card-body"> 
 													<div class="form-group">
														
														<a class="text-primary"><fmt:message key="label.flight_departure_airport" />:</a>
														<a><em id="current-flight-departure-airport-city"><fmt:message key="label.not_defined" /></em></a>														
														<br/>
														<a class="text-primary"><fmt:message key="label.flight_destination_airport" />:</a>
														<a><em id="current-flight-destination-airport-city"><fmt:message key="label.not_defined" /></em></a>
														<br/>														
														<a class="text-primary"><fmt:message key="label.flight_aircraft" />:</a>
														<a><em id="current-flight-aircraft"><fmt:message key="label.not_defined" /></em></a>
														<br/>														
														<a class="text-primary"><fmt:message key="label.flight_departure_time" />:</a>
														<a><em id="current-flight-departure-time"><fmt:message key="label.not_defined" /></em></a>
														<br/>														
														<a class="text-primary"><fmt:message key="label.flight_landing_time" />:</a>
														<a><em id="current-flight-landing-time"><fmt:message key="label.not_defined" /></em></a>
													</div>
												</div>
											</div>
											<div class="col-md-6">								
																				
											</div>
										</div>
									</div>
							</div>
						</div>
					</div>
					
					<div class="container">
				<div class="row">
					<div class="col-12 card border-primary">
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.flights_list"/>
						</h4>
						<div class="table-wrapper-scroll-y my-custom-scrollbar">
							<table  class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar" 
									cellspacing="0" width="100%">
								<tr>
									<th><fmt:message key="column.flight_departure_airport" /></th>
									<th><fmt:message key="column.flight_destination_airport" /></th>
									<th><fmt:message key="column.flight_departure_time" /></th>
									<th><fmt:message key="column.flight_landing_time" /></th>
									<th><fmt:message key="column.flight_aircraft" /></th>
									<th><fmt:message key="column.flight_aircraft_model" /></th>
								</tr>
								<c:forEach var="elem" items="${sessionScope.flights_for_selected_employee}">								
								
									<tr onclick="selectFlight(
											'current-flight-departure-airport-city', '${elem.departureAirport.airportCity}',
											'current-flight-destination-airport-city', '${elem.destinationAirport.airportCity}',
											'current-flight-departure-time', '<fmt:formatDate value="${elem.departureTime}" pattern="dd-MM-yyyy HH:mm" />',															
											'current-flight-landing-time', '<fmt:formatDate value="${elem.landingTime}" pattern="dd-MM-yyyy HH:mm" />',
											'current-flight-aircraft-id', '${elem.aircraft.aircraftID}',
											'current-flight-aircraft', '${elem.aircraft.aircraftSideNumber} ${elem.aircraft.aircraftModel.aircraftModelName}')">
										<td>${elem.departureAirport.airportCity}</td>	
										<td>${elem.destinationAirport.airportCity}</td>	
										<td><fmt:formatDate value="${elem.departureTime}" pattern="dd-MM-yyyy HH:mm" /></td>
										<td><fmt:formatDate value="${elem.landingTime}" pattern="dd-MM-yyyy HH:mm" /></td>
										<td>${elem.aircraft.aircraftSideNumber}</td>
										<td>${elem.aircraft.aircraftModel.aircraftModelName}</td>
									</tr>															
								</c:forEach>								
							</table>
						</div>
					</div>
				</div>
			</div>					
				
		<%@ include file="Footer.jsp" %>
	</fmt:bundle>
	
	<script>
	
	function selectFlight(e3, v3, e5, v5, e6, v6, e7, v7, e8, v8, e9, v9) {
		
		document.getElementById(e3).innerHTML = v3;
		document.getElementById(e5).innerHTML = v5;
		document.getElementById(e6).innerHTML = v6;
		document.getElementById(e7).innerHTML = v7;
		document.getElementById(e9).innerHTML = v9;
	}
	
	function selectAirport(e1, v1, e2, v2) {

	    document.getElementById(e1).innerHTML = v1;
	    document.getElementById(e2).setAttribute("value", v2);
	}
	
	function selectAircraft(e1, v1, e2, v2) {
		
		document.getElementById(e1).setAttribute("value", v1);
		document.getElementById(e2).innerHTML = v2;
	}
	</script>
	
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