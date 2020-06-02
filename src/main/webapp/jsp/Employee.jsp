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
	<link rel="stylesheet" type="text/css" href="sources/css/bootstrap.min.css" />
	<script type="text/javascript" src="sources/js/AllPageScript.js"></script>
	<link rel="icon" href="sources/images/logo-airline.png"
		type="image/icon type" />
	<title>Employee</title>
</head>

<body onload="message()">

	<c:set var="current_page" value="employee" scope="session" />

	<fmt:bundle basename="ui">
		<%@ include file="Header.jsp" %> 
		<%@ include file="ModalWindowStatusOperationMessage.jsp" %>
		<%@ include file="ModalWindowOperationWithEmployee.jsp" %>			

					<h3 class="text-center text-primary pt-5">
						<fmt:message key="label.personell_management" />
					</h3>				

			<div class="container">
				<div class="row">
					
					<div class="col-12 card border-primary">
						<h4 class="text-center text-primary pt-5">
							<fmt:message key="label.employee_list" />
						</h4>
						
						<div class="table-wrapper-scroll-y my-custom-scrollbar">

							<table
								class="table table-hover table-striped table-bordered table-sm my-custom-scrollbar">

								<tr>
									<th><fmt:message key="column.first_name" /></th>
									<th><fmt:message key="column.last_name" /></th>
									<th><fmt:message key="column.crew_role" /></th>
								</tr>

								<c:forEach var="elem" items="${sessionScope.all_employee_list}">

									<tr onclick="showModalOperationWithEmployee('${elem.id}',
										'${elem.nickname}',
									 	'${elem.firstName}',
									  	'${elem.lastName}',
									  	'${elem.systemRole.systemRoleID}',
									  	'${elem.systemRole.systemRoleName}',
									  	'${elem.crewRole.crewRoleID}',
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
		function showModalOperationWithEmployee(id, nickname, firstName, lastName, systemRoleID, systemRoleName, crewRoleID, crewRoleName) {			
			
			document.getElementById("current-employee-id").setAttribute("value", id);
			document.getElementById("current-employee-nickname").setAttribute("value", nickname);
			document.getElementById("current-employee-first-name").setAttribute("value", firstName);
			document.getElementById("current-employee-last-name").setAttribute("value", lastName);
			document.getElementById("current-employee-system-role-name").innerHTML = systemRoleName;
		    document.getElementById("current-employee-system-role-id").setAttribute("value", systemRoleID);
		    document.getElementById("current-employee-crew-role-name").innerHTML = crewRoleName;
		    document.getElementById("current-employee-crew-role-id").setAttribute("value", crewRoleID);
		    
			$("#modal-window-operation-with-employee").modal('show');
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