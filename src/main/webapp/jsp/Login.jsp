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
    <link rel="icon"  type="image/icon type" href="sources/images/logo-airline.png">
    <title>Airline</title>
</head>

<body>

<c:set var="current_page" value="login" scope="session"/>

<fmt:bundle basename="ui">

    <%--HEADER--%>
    <c:import url="Header.jsp"/>
		<br/>
		<div class="container">
			<div class="row">
				<div class="col-4"></div>
					<div class="col-4 card border-primary">	
						<h3 class="text-center text-primary"><fmt:message key="label.login_form" /></h3>			
						<form id="login_logout_command" class="form" action=""	method="post">
							<div>
								<label class="text text-primary" for="user_name_input">
									<fmt:message key="label.user_nickname" />
								</label><br /> 
								<input type="text"
										class="form-control border-primary" id="user_name_input"
										name="employee_nickname" value="${sessionScope.get('current_session_user').getNickname()}"/><br /> 
								<label class="text text-primary" for="user_password_input">
									<fmt:message key="label.password" />
								</label><br /> 
								<input type="password"
										class="form-control border-primary" id="user_password_input"
										name="employee_password" /><br />
							</div>
							<div>
								<button type="submit" class="btn btn-outline-primary" 
										name="command" value="login_user">
									<fmt:message key="button.login" />						
								</button>
								<button type="submit" class="btn btn-outline-primary" 
										name="command" value="logout_user">
									<fmt:message key="button.logout" />						
								</button>
								<button type="submit" class="btn btn-outline-primary" 
										name="command" value="goto_page_cabinet">
									<fmt:message key="button.user_cabinet" />						
								</button>
								<button class="btn btn-outline-primary" data-dismiss="modal">
									<fmt:message key="button.close" />						
								</button>
							</div>
						</form>
					</div>
					<div class="col-4"></div>
				</div>			
		</div>

    <c:import url="Footer.jsp"/>

</fmt:bundle>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="sources/css/bootstrap.min.js"></script>
<script src="sources/css/bootstrap.bundle.min.js"></script>

</body>

</html>