<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.localisation}"/>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="sources/css/maket.css">
    <link rel="stylesheet" type="text/css" href="sources/css/bootstrap.min.css">
    <link rel="icon" href="sources/images/logo-airline.png" type="image/icon type">
    <script type="text/javascript" src="sources/js/AllPageScript.js"></script>
    <title>Airline</title>
</head>

<body>

<c:set var="current_page" value="cabinet" scope="session"/>

<fmt:bundle basename="ui">

    <%--HEADER--%>
    <c:import url="Header.jsp"/>
    


    <div align="center">
        <h3 class="text-center text-primary pt-5"><fmt:message key="label.cabinet"/></h3>
        
        
        <div class="col-8 card border-primary">
						<%--B2--%>
						<%--Card employee info--%>

						<form id="add-aircraft-form" class="form" action="" method="post">
							<input type="hidden" name="employee_id"	id="current-employee-id"
							class="form-control border-primary" value="${sessionScope.get("current_session_user").getId()}"/>
							<%--Form--%>
							<div class="container">
								<div class="row">
									<%--D--%>
									<div class="col-md-6">
										<%--D1--%>
										<div class="card-body">

											<div class="form-group">
												<%--login name--%>
												<label for="current-employee-nickname" class="text-primary">
													<fmt:message key="label.user_nickname" />
												</label><br /> 
												<input type="text" name="employee_nickname"	id="current-employee-nickname"
													class="form-control border-primary" value="${sessionScope.get("current_session_user").getNickname()}"/>
											</div>

											<div class="form-group">
												<%--first name--%>
												<label for="current-employee-first-name"
													class="text-primary"> <fmt:message
														key="label.user_first_name" />
												</label><br /> <input type="text" name="employee_first_name"
													id="current-employee-first-name"
													class="form-control border-primary" value="${sessionScope.get("current_session_user").getFirstName()}"/>
											</div>

											<div class="form-group">
												<%--last name--%>
												<label for="current-employee-last-name" class="text-primary">
													<fmt:message key="label.user_last_name" />
												</label><br /> 
												<input type="text" name="employee_last_name"
													id="current-employee-last-name"
													class="form-control border-primary" 
													value="${sessionScope.get("current_session_user").getLastName()}"/>
											</div>
										</div>
									</div>
									<%--D1--%>
									<div class="col-md-6">
										<%--D2--%>
										<br />
										<div class="form-group">
											<%--system role--%>
											<label for="current-employee-system-role-name"
												class="text-primary"> 
												<fmt:message key="label.system_role" />
											</label><br />

											<div class="btn-group">
												<button type="button" id="current-employee-system-role-name"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="true">${sessionScope.get("current_session_user").getSystemRole().getSystemRoleName()}</button>
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_system_role_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick(
															'current-employee-system-role-name', '${elem.systemRoleName}' ,
															'current-employee-system-role-id', '${elem.systemRoleID}')">
															<c:out value="${elem.systemRoleName}">
															</c:out>
														</a>
													</c:forEach>
												</div>
												<input type="hidden" id="current-employee-system-role-id"
													name="system_role_id" value="${sessionScope.get("current_session_user").getSystemRole().getSystemRoleID()}"/>
											</div>

										</div>

										<div class="form-group">
											<%--system role--%>
											<label for="current-employee-crew-role-name"
												class="text-primary"> <fmt:message
													key="label.system_role" />
											</label><br />

											<div class="btn-group">
												<button type="button" id="current-employee-crew-role-name"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false">${sessionScope.get("current_session_user").getCrewRole().getCrewRoleName()}</button>
												<div class="dropdown-menu">
													<c:forEach var="elem"
														items="${sessionScope.all_crew_role_list}">
														<a class="dropdown-item" href="#"
															onclick="dropDownPick(
															'current-employee-crew-role-name', '${elem.crewRoleName}',
															'current-employee-crew-role-id', '${elem.crewRoleID}')">
															<c:out value="${elem.crewRoleName}">
															</c:out>
														</a>
													</c:forEach>
												</div>
												<input type="hidden" id="current-employee-crew-role-id"
													name="crew_role_id" value="${sessionScope.get("current_session_user").getCrewRole().getCrewRoleID()}"/>
											</div>

										</div>
										
										
										
										<div class="form-group">
											<label for="employee-password" class="text-primary">
												<fmt:message key="label.password" />
											</label><br />
											<input type="password" name="employee_password"
												id="employee-password" class="form-control border-primary" />
										</div>
										
									</div>


									<%--D2--%>
								</div>
							</div>
							
							<!-- Status message -->
							<div class="container">
								<div class="row">
									<div class="col-md-12">
									<!-- WARNING MESSAGE -->
									<h3 class="text-center">${sessionScope.success_message}</h3>
									<h3 class="text-danger text-center">${sessionScope.warning_message}</h3>
									</div>
								</div>
							</div>
							
							<%--D--%>
							<div class="container">
								<div class="row">

									<div class="col-md-12">
										<%--F--%>

										<button type="submit" class="btn btn-outline-primary"
											name="command" value="update_employee">
											<fmt:message key="button.update" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="change_password">
											<fmt:message key="button.update_password" />
										</button>								
									</div>
								</div>
							</div>
							<%--F--%>
						</form>
					</div>
        
    </div>

    <c:import url="Footer.jsp"/>

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