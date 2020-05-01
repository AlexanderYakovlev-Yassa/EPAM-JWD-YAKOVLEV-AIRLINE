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
	<link rel="stylesheet" type="text/css" href="sources/css/main.css" />
	<link rel="stylesheet" type="text/css"
		href="sources/css/bootstrap.min.css" />
	<script type="text/javascript" src="sources/js/AllPageScript.js"></script>
	<link rel="icon" href="sources/images/logo-airline.png"
		type="image/icon type" />
	<title>Flight Manager</title>
</head>

<body>

	<c:set var="current_page" value="flights_management" scope="session" />

	<fmt:bundle basename="ui">
		<%--HEADER--%>
		<c:import url="Header.jsp" />


		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.flight_management" />
					</h3>
				</div>
			</div>
			<%--0--%>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-12 card border-primary">
					
						<div class="table-wrapper-scroll-y my-custom-scrollbar">
							<%--C--%>

							<table  class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar" 
							cellspacing="0" width="100%">
								<tr>
									<th><fmt:message key="column.flight_departure_airport" /></th>
									<th><fmt:message key="column.flight_destination_airport" /></th>
									<th><fmt:message key="column.flight_departure_time" /></th>
									<th><fmt:message key="column.flight_landing_time" /></th>
									<th><fmt:message key="column.flight_aircraft" /></th>
								</tr>
							<c:forEach var="elem" items="${sessionScope.all_flights_list}">								
								
								<tr onclick="flightsTabClick('current-flight-id', '${elem.flightID}',
															'current-flight-departure-airport-id', '${elem.departureAirport.airportID}',
															'current-flight-departure-airport-city', '${elem.departureAirport.airportCity}',
															'current-flight-destination-airport-id', '${elem.destinationAirport.airportID}',
															'current-flight-destination-airport-city', '${elem.destinationAirport.airportCity}',
															'current-flight-departure-time', '<fmt:formatDate value="${elem.departureTime}" pattern="dd-MM-yyyy HH:mm" />',															
															'current-flight-landing-time', '<fmt:formatDate value="${elem.landingTime}" pattern="dd-MM-yyyy HH:mm" />',
															'current-flight-aircraft-id', '${elem.aircraft.aircraftID}',
															'current-flight-aircraft', '${elem.aircraft.aircraftSideNumber}',
															'${elem.aircraft.aircraftModel.aircraftModelName}'
															)">
									<td>${elem.departureAirport.airportCity}</td>	
									<td>${elem.destinationAirport.airportCity}</td>	
									<td><fmt:formatDate value="${elem.departureTime}" pattern="dd-MM-yyyy HH:mm" /></td>
									<td><fmt:formatDate value="${elem.landingTime}" pattern="dd-MM-yyyy HH:mm" /></td>
									<td>${elem.aircraft.aircraftModel.aircraftModelName}</td>
								</tr>		
													
							</c:forEach>								
							</table>

						</div>
						<%--C--%>
					</div>
					<%--B1--%>
				<div class="container">	
				<div class="row">
					<div class="col-12 card border-primary">
						<%--B2--%>
						<%--Card employee info--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.flight_info"/>
						</h4>

						<form id="add-aircraft-form" class="form" action="" method="post">
							<%--Form--%>
							<div class="container">
								<div class="row">
									<%--D--%>
									<div class="col-md-6">
										<%--D1--%>
										<div class="card-body">
 
 											<div class="form-group">
											<%--departure airport--%>
											<label for="current-flight-departure-airport-city" class="text-primary"> 
												<fmt:message key="label.flight_departure_airport" />
											</label><br />

											<div class="btn-group">
												<button type="button" id="current-flight-departure-airport-city"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<fmt:message key="label.not_defined" />
												</button>
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_airports_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick(
															'current-flight-departure-airport-city', '${elem.airportCity}' ,
															'current-flight-departure-airport-id', '${elem.airportID}')">
															<c:out value="${elem.airportCity}"></c:out>
														</a>
													</c:forEach>
												</div>												
											</div><br/>
											
											<%--destination airport--%>
											<label for="current-flight-destination-airport-city" class="text-primary"> 
												<fmt:message key="label.flight_destination_airport" />
											</label><br />

											<div class="btn-group">
												<button type="button" id="current-flight-destination-airport-city"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<fmt:message key="label.not_defined" />
												</button>
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_airports_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick(
															'current-flight-destination-airport-city', '${elem.airportCity}' ,
															'current-flight-destination-airport-id', '${elem.airportID}')">
															<c:out value="${elem.airportCity}"></c:out>
														</a>
													</c:forEach>
												</div>												
											</div>
											<div>
												<button type="submit" id="goto-airport-page"
													class="btn btn-outline-primary"
													name="command" value="goto_page_airports_management">
													Airport management
												</button>
											</div>
											<br/>
											<label for="current-flight-aircraft" class="text-primary"> 
												<fmt:message key="label.flight_aircraft" />
											</label><br />
											<div class="btn-group">
												<button type="button" id="current-flight-aircraft"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<fmt:message key="label.not_defined" />
												</button>												
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_aircrafts_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick(
															'current-flight-aircraft-id', '${elem.aircraftID}' ,
															'current-flight-aircraft-sideNumber', '${elem.aircraftSideNumber}',
															'current-flight-aircraft-model-name', '${elem.aircraftModel.aircraftModelName}'
															)">
															<c:out value="${elem.aircraftSideNumber}"></c:out>
															<c:out value="${elem.aircraftModel.aircraftModelName}"></c:out>
														</a>
													</c:forEach>
												</div>												
											</div>

										</div>
											<input type="hidden" id="current-flight-id"
													name="flight_id" />
											<input type="hidden" id="current-flight-departure-airport-id"
													name="flight_departure_airport_id" />
											<input type="hidden" id="current-flight-destination-airport-id"
													name="flight_destination_airport_id" />
											<input type="hidden" id="current-flight-aircraft-id"
													name="flight_aircraft_id" />
										</div>
									</div>
								<div class="col-md-6">
								
									<div class="form-group">
										<%--aircraft model name--%>
										<br/>
										<label for="current-flight-departure-time" class="text-primary"> 
												<fmt:message key="label.flight_departure_time" />
										</label><br /> 
										<input type="text" name="flight_departure_time"
												id="current-flight-departure-time"
												class="form-control border-primary" />
									</div>
								
									<div class="form-group">
										<%--aircraft model name--%>
										
										<label for="current-flight-landing-time" class="text-primary"> 
												<fmt:message key="label.flight_landing_time" />
										</label><br /> 
										<input type="text" name="flight_landing_time"
												id="current-flight-landing-time"
												class="form-control border-primary" />
									</div>
								
								</div>


									<%--D2--%>
								</div>
							</div>
							<%--D--%>
							<div class="container">
							<div class="row">
									<div class="col-md-12">
									<!-- WARNING MESSAGE -->
									<h3 class="text-center">${sessionScope.success_message}</h3>
									<h3 class="text-danger text-center">${sessionScope.warning_message}</h3>									

									</div>
							</div>
							<div class="container">
								<div class="row">

									<div class="col-md-12">
										<%--F--%>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="add_flight">
											<fmt:message key="button.add" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="update_flight">
											<fmt:message key="button.update" />
										</button>										
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="delete_flight">
											<fmt:message key="button.delete" />
										</button>										
										
									</div>
								</div>
							</div>
							</div>
							<%--F--%>
						</form>
					</div>
					</div>
					</div>
					<%--B2--%>
				</div>
			</div>
			<%--A--%>
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