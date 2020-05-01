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

	<c:set var="current_page" value="select_crew" scope="session" />

	<fmt:bundle basename="ui">
		<%--HEADER--%>
		<c:import url="Header.jsp" />


		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.select_flight" />
					</h3>
				</div>
			</div>



			<%--0--%>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-12 card border-primary">

						<div class="table-wrapper-scroll-y my-custom-scrollbar">

							<table
								class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar">

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

									<tr onclick="flightTabOnClick('${elem.flightID}')">
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

						<%--C--%>
					</div>
				</div>
				<%--B1--%>

				<div class="conteiner">
					<div class="row">
						<div class="col-6">
							<div>
								<input type="hidden" id="selected-flight-id" name="flight_id"
									value="${selected_flight.flightID}" /> <br /> <a
									class="text-primary" onclick="a()"><b><fmt:message
											key="label.selected_flight" />:</b></a>
							</div>
							<div>
								<a class="text-primary"><fmt:message key="label.route" /> -</a>
								<a><em id="selected_departure_airport">${selected_flight.departureAirport.airportCity}</em></a>
								<a> -> </a> <a><em id="selected_destination_airport">${selected_flight.destinationAirport.airportCity}</em></a>
							</div>
							<div>
								<a class="text-primary"><fmt:message key="label.flight_time" />
									-</a> <a><em id="selected_departure_time"><fmt:formatDate
											value="${selected_flight.departureTime}"
											pattern="dd-MM-yyyy HH:mm" /></em></a> <a> ... </a> <a><em
									id="selected_landing_time"><fmt:formatDate
											value="${selected_flight.landingTime}"
											pattern="dd-MM-yyyy HH:mm" /></em></a>
							</div>
							<div>
								<a class="text-primary"><fmt:message key="label.aircraft" />
									- </a> <a><em id="selected_aircraft">${selected_flight.aircraft.aircraftModel.aircraftModelName}
								</em></a> <a class="text-primary"><fmt:message
										key="label.side_number" /> - </a> <a><em
									id="selected_aircraft_side_number">${selected_flight.aircraft.aircraftSideNumber}</em></a>
								<br />
							</div>
						</div>
						<div class="col-6">							
						</div>
					</div>
				</div>

			</div>

			<div class="container">
				<div class="row">
					<div class="col-6">
						<h3 class="text-center text-primary pt-5">
							<fmt:message key="label.all_employee" />
						</h3>
					</div>
					<div class="col-6">
						<h3 class="text-center text-primary pt-5">
							<fmt:message key="label.crew" />
						</h3>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="row">
					<div class="col-6 card border-primary">
						<div class="table-wrapper-scroll-y my-custom-scrollbar">

							<table
								class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar">

								<tr>
									<th><fmt:message key="column.first_name" /></th>
									<th><fmt:message key="column.last_name" /></th>
									<th><fmt:message key="column.crew_role" /></th>
								</tr>

								<c:forEach var="elem" items="${sessionScope.all_employee_list}">

									<tr onclick="addEmployeeToCrew('${elem.id}',
									 '${sessionScope.selected_flight.flightID}',
									 	'${elem.firstName}',
									  	'${elem.lastName}',
									  	'${elem.crewRole.crewRoleName}')">
										<td>${elem.firstName}</td>
										<td>${elem.lastName}</td>
										<td>${elem.crewRole.crewRoleName}</td>
									</tr>

								</c:forEach>

							</table>
						</div>
					</div>
					<div class="col-6 card border-primary">
						<div class="table-wrapper-scroll-y my-custom-scrollbar">

							<table
								class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar">

								<tr>
									<th><fmt:message key="column.first_name" /></th>
									<th><fmt:message key="column.last_name" /></th>
									<th><fmt:message key="column.crew_role" /></th>
								</tr>

								<c:forEach var="elem"
									items="${sessionScope.selected_flight_crew}">

									<tr onclick="removeCrewMember('${elem.id}', 
										'${sessionScope.selected_flight.flightID}',
									 	'${elem.firstName}',
									  	'${elem.lastName}',
									  	'${elem.crewRole.crewRoleName}')">
										<td>${elem.firstName}</td>
										<td>${elem.lastName}</td>
										<td>${elem.crewRole.crewRoleName}</td>
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
	<script>
		function removeCrewMember(employeeID, flightID, name, lastName, role){	
			
			var confirmAnswer = confirm("Are you sure you want to remove\n " 
					+ name + " " + lastName + " " + role + "\n" 
					+ "from the crew of the flight \n"
					+ '${selected_flight.departureAirport.airportCity}'
					+ "-" + '${selected_flight.destinationAirport.airportCity}'
					+ " " + '<fmt:formatDate value="${selected_flight.departureTime}" pattern="dd-MM-yyyy HH:mm" />' 
					+ " ... " + '<fmt:formatDate value="${selected_flight.landingTime}"	pattern="dd-MM-yyyy HH:mm" />' );
			if (confirmAnswer) {
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {									
					refreshWindow(window, this);
				}
			} 								
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=remove_crew_member"
								+ "&employee_id=" + employeeID
								+ "&flight_id=" + flightID);
			}
		}					
	
		function addEmployeeToCrew(employeeID, flightID, name, lastName, role){	
			
			var confirmAnswer = confirm("Are you sure you want to add\n " 
					+ name + " " + lastName + " " + role + "\n" 
					+ "to the crew of the flight \n"
					+ '${selected_flight.departureAirport.airportCity}'
					+ "-" + '${selected_flight.destinationAirport.airportCity}'
					+ " " + '<fmt:formatDate value="${selected_flight.departureTime}" pattern="dd-MM-yyyy HH:mm" />' 
					+ " ... " + '<fmt:formatDate value="${selected_flight.landingTime}"	pattern="dd-MM-yyyy HH:mm" />' );
			if (confirmAnswer) {
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {									
					refreshWindow(window, this);
				}
			} 								
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=add_employee_to_crew"
								+ "&employee_id=" + employeeID
								+ "&flight_id=" + flightID);
		}
		}						
	
		function flightTabOnClick(flightID){						
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {
					refreshWindow(window, this);
				}
			} 								
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=select_flight_by_id&flight_id=" + flightID);
		}	
		
		function refreshWindow(window, request) {
			window.document.open();
			window.document.write(request.response);
			window.document.close();
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