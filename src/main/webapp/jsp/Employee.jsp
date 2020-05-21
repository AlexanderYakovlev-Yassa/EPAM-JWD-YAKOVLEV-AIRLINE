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
	<!-- <script type="text/javascript" src="sources/js/EmployeePageScript.js"></script> -->
	<link rel="icon" href="sources/images/logo-airline.png"
		type="image/icon type" />
	<title>Employee</title>
</head>

<body onload="message()">

	<c:set var="current_page" value="employee" scope="session" />

	<fmt:bundle basename="ui">
		<%--HEADER--%>
		<%@ include file="Header.jsp" %> 
		<%@ include file="ModalWindowStatusOperationMessage.jsp" %>
		
		<div class="container">
			<div class="row">
				<%--0--%>
				<div class="col-12" align="center">

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.personell_management" />
					</h3>
				</div>
			</div>
			<%--0--%>
			<div class="container">
				<div class="row">
					<%--A--%>
					<div class="col-4 card border-primary">
						<%--B1--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.employee_list" />
						</h4>
						<div class="overflow-auto" style="heigth: 200px">
							<%--C--%>

							<ctg:populate-employee-table
								columns="employee_first_name employee_last_name crew_role_name"
								styleClass="table table-hover" />

						</div>
						<%--C--%>
					</div>
					<%--B1--%>

					<div class="col-8 card border-primary">
						<%--B2--%>
						<%--Card employee info--%>
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.employee_info" />
						</h4>

						<form id="manage-employee-form" class="form" action="" method="post">
							<%--Form--%>
							<div class="container">
								<div class="row">
									<%--D--%>
									<div class="col-md-6">
										<%--D1--%>
										<div class="card-body">
											<input type="hidden" name="page" value="employee"/>
                                            

											<div class="form-group">
												<%--login name--%>
												<label for="current-employee-nickname" class="text-primary">
													<fmt:message key="label.user_nickname" />
												</label><br /> <input type="text" name="employee_nickname"
													id="current-employee-nickname"
													class="form-control border-primary" />
											</div>

											<div class="form-group">
												<%--first name--%>
												<label for="current-employee-first-name"
													class="text-primary"> <fmt:message
														key="label.user_first_name" />
												</label><br /> <input type="text" name="employee_first_name"
													id="current-employee-first-name"
													class="form-control border-primary" />
											</div>

											<div class="form-group">
												<%--last name--%>
												<label for="current-employee-last-name" class="text-primary">
													<fmt:message key="label.user_last_name" />
												</label><br /> <input type="text" name="employee_last_name"
													id="current-employee-last-name"
													class="form-control border-primary" />
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
												class="text-primary"> <fmt:message
													key="label.system_role" />
											</label><br />


											<div class="btn-group">
												<button type="button" id="current-employee-system-role-name"
													class="btn btn-outline-primary dropdown-toggle"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false"><fmt:message key="label.not_defined" /></button>
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
													name="system_role_id" />
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
													aria-expanded="false"><fmt:message key="label.not_defined" /></button>
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
													name="crew_role_id" />
											</div>

										</div>
										<div class="form-group">
											<input type="hidden" id="current-employee-id"
													name="employee_id" />
											<label for="employee-password" class="text-primary">
												<fmt:message key="label.password" />
											</label><br /> 
											<input type="password" name="employee_password"
												id="employee-password" class="form-control border-primary" />
										</div>

									</div>


									<%--D2--%>
								</div>
							</div><br/><br/>				
							
							
							<div class="container">
								<div class="row">
									<div class="col-md-12">
										<%--F--%>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="add_employee">
											<fmt:message key="button.add" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="update_employee">
											<fmt:message key="button.update" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="change_password">
											<fmt:message key="button.update_password" />
										</button>
										<button type="submit" class="btn btn-outline-primary"
											name="command" value="delete_employee">
											<fmt:message key="button.delete" />
										</button>
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