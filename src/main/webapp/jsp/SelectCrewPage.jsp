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
	
		<%@ include file="Header.jsp" %> 
		<%@ include file="ModalWindowStatusOperationMessage.jsp" %>
		
 		<div class="modal fade" id="modal-window-add-member-to-crew" role="dialog">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
        				<h5 id="title-of-modal-window" class="modal-title text-center text-primary">
        					<fmt:message key="modal.adding_member_to_the_crew"/>
        				</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
					<div class="modal-body">
							<div id="message-of-add-modal-window">
								<a class="text-primary"><fmt:message key="modal.adding_member" /></a><br/>
								<a><em id="adding-employee-first-name"></em></a>
								<a> </a>
								<a><em id="adding-employee-last-name"></em></a>
								<a> </a>
								<a><em id="adding-employee-crew-role"></em></a><br/>
								<a class="text-primary"><fmt:message key="modal.to_the_crew" /></a><br/>
								<a><em>
									${selected_flight.departureAirport.airportCity} --> ${selected_flight.destinationAirport.airportCity}
								</em></a><br/>
								<a><em>
								<fmt:formatDate value="${selected_flight.departureTime}" pattern="dd-MM-yyyy HH:mm" /> ... 
								<fmt:formatDate value="${selected_flight.landingTime}" pattern="dd-MM-yyyy HH:mm" />
								</em></a><br/>
							</div>													
					</div>
					<div class="modal-footer">
						<div id="buttons-of-modal-window" class="float-right">
								<button id="add_button" class="btn btn-outline-primary">
									<fmt:message key="button.add" />					
								</button>
								<button class="btn btn-outline-primary" data-dismiss="modal">
									<fmt:message key="button.close" />
								</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="modal fade" id="modal-window-remove-member-from-crew" role="dialog">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
        				<h5 id="title-of-modal-window" class="modal-title text-center text-primary">
        					<fmt:message key="modal.removing_member_from_the_crew"/>
        				</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
					<div class="modal-body">
							<div id="message-of-remove-modal-window">
								<a class="text-primary"><fmt:message key="modal.remove_member" /></a><br/>
								<a><em id="removing-employee-first-name"></em></a>
								<a> </a>
								<a><em id="removing-employee-last-name"></em></a>
								<a> </a>
								<a><em id="removing-employee-crew-role"></em></a><br/>
								<a class="text-primary"><fmt:message key="modal.from_the_crew" /></a><br/>
								<a><em>
									${selected_flight.departureAirport.airportCity} --> ${selected_flight.destinationAirport.airportCity}
								</em></a><br/>
								<a><em>
								<fmt:formatDate value="${selected_flight.departureTime}" pattern="dd-MM-yyyy HH:mm" /> ... 
								<fmt:formatDate value="${selected_flight.landingTime}" pattern="dd-MM-yyyy HH:mm" />
								</em></a><br/>
							</div>													
					</div>
					<div class="modal-footer">
						<div id="buttons-of-modal-window" class="float-right">
								<button id="remove-button" class="btn btn-outline-primary">
									<fmt:message key="button.remove_member" />
								</button>
								<button class="btn btn-outline-primary" data-dismiss="modal">
									<fmt:message key="button.close" />
								</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
 			<div class="row">
				
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.crew_selection" />
					</h3>
				</div>
			</div>

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
							<button type="submit" class="btn btn-outline-primary" name="command" value="goto_page_select_flight"">
								<fmt:message key="button.select_flight" />
							</button>
							</form>					
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
									items="${sessionScope.selected_flight_crew.crewMembersList}">

									<tr onclick="removeEmployeeFromCrew('${elem.id}',
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
	
	message();
	
		function message() {
			
			var warningMessage = '${sessionScope.warning_message}';
			var successMessage = '${sessionScope.success_message}';
			
			if ((warningMessage == "") && (successMessage == "")) {
				return;
			}
			
			$("#modal-window-status-operation-message").modal('show');
		}
	
		 function addEmployeeToCrew(employeeID, firstName, lastName, crewRole){
			
			document.getElementById('adding-employee-first-name').innerHTML = firstName;
			document.getElementById('adding-employee-last-name').innerHTML = lastName;
			document.getElementById('adding-employee-crew-role').innerHTML = crewRole;
			
			$("#modal-window-add-member-to-crew").modal('show');

			$('#add_button').on('click', function() {
					executeCommand('add_employee_to_crew', employeeID, '${selected_flight.flightID}');
				  	$('#modal-window-add-member-to-crew').modal('hide');
			});
		} 
		
		function removeEmployeeFromCrew(employeeID, firstName, lastName, crewRole){
			
			document.getElementById('removing-employee-first-name').innerHTML = firstName;
			document.getElementById('removing-employee-last-name').innerHTML = lastName;
			document.getElementById('removing-employee-crew-role').innerHTML = crewRole;
			
			$("#modal-window-remove-member-from-crew").modal('show');
			
			$('#remove-button').on('click', function() {
					executeCommand('remove_crew_member', employeeID, '${selected_flight.flightID}');
				  	$('#modal-window-remove-member-from-crew').modal('hide');
			});
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
		
		function selectFlight(){						
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {
					refreshWindow(window, this);
				}
			} 								
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=goto_page_select_flight&previous_page=select_crew");
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