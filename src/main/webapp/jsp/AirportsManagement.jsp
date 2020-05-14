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
	<title>Airports</title>
</head>

<body>

	<c:set var="current_page" value="airport_management" scope="request" />

	<fmt:bundle basename="ui">
		<%--HEADER--%>
		<%@ include file="Header.jsp" %> 

		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.airports_management" />
					</h3>
				</div>
			</div>
			<%--0--%>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-7 card border-primary">
						<%--B1--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.airports" />
						</h4>
						<div class="overflow-auto" style="heigth: 200px">
							<%--C--%>

							<table class="table table-hover">
								<tr>
									<th><fmt:message key="label.airport_city" /></th>
								</tr>
							<c:forEach var="elem" items="${sessionScope.all_airports_list}">								
								
								<tr onclick="airportsTabClick('current-airport-id', '${elem.airportID}',
															'current-airport-city', '${elem.airportCity}')">										
									<td>${elem.airportCity}</td>
								</tr>		
													
							</c:forEach>								
							</table>

						</div>
						<%--C--%>
					</div>
					<%--B1--%>

					<div class="col-5 card border-primary">
						<%--B2--%>
						<%--Card employee info--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.airport_info"/>
						</h4>

						<form id="add-aircraft-form" class="form" action="" method="post">
							<%--Form--%>
							<div class="container">
								<div class="row">
									<%--D--%>
									<div class="col-md-12">
										<%--D1--%>
										<div class="card-body"> 

											<input type="hidden" id="current-airport-id"
													name="airport_id" />
 
 												<div class="form-group">
												<%--aircraft model name--%>
												<label for="current-airport-city" class="text-primary"> 
													<fmt:message key="label.airport_city" />
												</label><br /> 
												<input type="text" name="airport_city"
													id="current-airport-city"
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
											name="command" value="add_airport">
											<fmt:message key="button.add" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="update_airport">
											<fmt:message key="button.update" />
										</button>										
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="delete_airport">
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