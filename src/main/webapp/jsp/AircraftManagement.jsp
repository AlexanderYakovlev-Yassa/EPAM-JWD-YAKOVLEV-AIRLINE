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
	<link rel="stylesheet" type="text/css" href="sources/css/maket.css" />
	<link rel="stylesheet" type="text/css"
		href="sources/css/bootstrap.min.css" />
	<script type="text/javascript" src="sources/js/AllPageScript.js"></script>
	<link rel="icon" href="sources/images/logo-airline.png"
		type="image/icon type" />
	<title>Employee</title>
</head>

<body>

	<c:set var="current_page" value="aircraft_management" scope="request" />

	<fmt:bundle basename="ui">
		<%--HEADER--%>
		<c:import url="Header.jsp" />


		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.aircraft_management" />
					</h3>
				</div>
			</div>
			<%--0--%>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-8 card border-primary">
						<%--B1--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.aircrafts" />
						</h4>
						<div class="overflow-auto" style="heigth: 200px">
							<%--C--%>

							<table class="table table-hover">
								<tr>
									<th><fmt:message key="label.aircraft_model_name" /></th>
									<th><fmt:message key="label.aircraft_capacity" /></th>
									<th><fmt:message key="label.aircraft_side_number" /></th>
								</tr>
							<c:forEach var="elem" items="${sessionScope.all_aircrafts_list}">								
								
								<tr onclick="airlineTabClick('current-aircraft-id', '${elem.aircraftID}',
															'current-aircraft-side-number', '${elem.aircraftSideNumber}',
															'current-aircraft-model-id', '${elem.aircraftModel.aircraftModelID}',
															'current-aircraft-model-name', '${elem.aircraftModel.aircraftModelName}',
															'current-aircraft-model-capacity', '${elem.aircraftModel.aircraftModelCapacity}'
															)">
									<td>${elem.aircraftModel.aircraftModelName}</td>	
									<td>${elem.aircraftModel.aircraftModelCapacity}</td>		
									<td>${elem.aircraftSideNumber}</td>				
								</tr>		
													
							</c:forEach>								
							</table>

						</div>
						<%--C--%>
					</div>
					<%--B1--%>

					<div class="col-4 card border-primary">
						<%--B2--%>
						<%--Card employee info--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.aircraft_info"/>
						</h4>

						<form id="add-aircraft-form" class="form" action="" method="post">
							<%--Form--%>
							<div class="container">
								<div class="row">
									<%--D--%>
									<div class="col-md-12">
										<%--D1--%>
										<div class="card-body">
 
 											<div class="form-group">
											<%--aircraft model name--%>
											<label for="aircraft-model-name" class="text-primary"> 
												<fmt:message key="label.aircraft_model_name" />
											</label><br />

											<div class="btn-group">
												<button type="button" id="current-aircraft-model-name"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">
													<fmt:message key="label.not_defined" />
												</button>
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_aircraft_models_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick3(
															'current-aircraft-model-name', '${elem.aircraftModelName}' ,
															'current-aircraft-model-id', '${elem.aircraftModelID}',
															'current-aircraft-model-capacity', '${elem.aircraftModelCapacity}')">
															<c:out value="${elem.aircraftModelName}"></c:out>
														</a>
													</c:forEach>
												</div>												
											</div>

										</div>
											<input type="hidden" id="current-aircraft-id"
													name="aircraft_id" />
											<input type="hidden" id="current-aircraft-model-id"
													name="aircraft_model_id" />
 
											<div class="form-group">
												<%--aircraft capacity--%>
												<label for="current-aircraft-model-capacity" class="text-primary"> 
													<fmt:message key="label.aircraft_capacity" />
												</label><br /> <input type="text" name="aircraft_capacity"
													id="current-aircraft-model-capacity"
													class="form-control border-primary" />
											</div>
											
											<button type="submit" class="btn btn-outline-primary"
												name="command" value="GOTO_PAGE_AIRCRAFT_MODELS_MANAGEMENT">
													<fmt:message key="button.airline_model_management" />
											</button>

											<div class="form-group">
												<%--aircraft side number--%>
												<label for="aircraft-side-number" class="text-primary">
													<fmt:message key="label.aircraft_side_number" />
												</label><br /> 
												<input type="text" name="aircraft_side_number"
													id="current-aircraft-side-number"
													class="form-control border-primary" />
											</div>
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
											name="command" value="add_aircraft">
											<fmt:message key="button.add" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="update_aircraft">
											<fmt:message key="button.update" />
										</button>										
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="delete_aircraft">
											<fmt:message key="button.delete" />
										</button>										
										
									</div>
								</div>
							</div>
							</div>
							<%--F--%>
						</form>
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