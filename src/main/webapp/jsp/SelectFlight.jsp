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
<title>Select Flight</title>
</head>

<body>

	<c:set var="current_page" value="select_flight" scope="session" />

	<fmt:bundle basename="ui">
		<%@ include file="Header.jsp" %> 
		<%@ include file="ModalWindowStatusOperationMessage.jsp" %>

		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.select_flight" />
					</h3>
				</div>
			</div>
			
				<div class="conteiner">
					<div class="row">
						<div class="col-12"><br/>
							<form action="" method="post">
							<a class="text-primary"><fmt:message key="label.time_period" />: </a>
							<input type="text" id="first-date" class="border border-primary" name="first_date" />
							<a class="text-primary"> ... </a>
							<input type="text" id="second-date" class="border border-primary" name="second_date" />							
							<button type="submit" class="btn btn-outline-primary" name="command" value="refresh_flights_list">
								<fmt:message key="button.submit" />
							</button>
							</form><br/>
						</div>
						<script>
							document.getElementById("first-date").setAttribute("value", 
									'<fmt:formatDate value="${sessionScope.first_selected_date}" pattern="dd-MM-yyyy HH:mm" />');
							document.getElementById("second-date").setAttribute("value", 
							'<fmt:formatDate value="${sessionScope.second_selected_date}" pattern="dd-MM-yyyy HH:mm" />');
						</script>
					</div>
				</div>

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
						<div class="col-6"><br/>
							<form action="" method="post">
								<button type="submit" class="btn btn-outline-primary" name="command" value="goto_previous_page">
									<fmt:message key="button.back_to_previous_page" />
								</button>	
							</form>			
						</div>
					</div>
				</div>
			</div>
		</div>

		<c:import url="Footer.jsp" />

	</fmt:bundle>
	<script>
	
	message();
	
		function message() {
			
			var warningMessage = '${sessionScope.warning_message}';
			var successMessage = '${sessionScope.success_message}';
			
			if ((warningMessage == "") && (successMessage == "")) {
				return;
			}
			
			$("#modal-window-status-operation-message").modal('show');
		}
		
		function executeCommand(command, employeeID, flightID){	
			
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {
					refreshWindow(window, this);
				}
			}
						
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=" + command + "&employee_id=" + employeeID + "&flight_id=" + flightID);
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
		
		function backToPreviousPage(previousPage){	
			
			//history.back;
			location.reload;
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