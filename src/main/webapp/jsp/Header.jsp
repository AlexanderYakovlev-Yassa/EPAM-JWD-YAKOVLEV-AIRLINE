		<div><br/>
		</div>
		
		<div class="modal fade" id="modal-window-login-logout" role="dialog">
			<div class="modal-dialog modal-dialog-centered">

				<!-- Modal content-->
				<div class="modal-content">

					<div class="modal-body">
						<form id="login_logout_command" class="form" action=""
							method="post">
							<div>
								<label class="text text-primary" for="user_name_input">
									<fmt:message key="label.user_nickname" />
								</label><br /> 
								<input type="text"
									class="form-control border-primary" id="user_name_input"
									name="employee_nickname" value="${sessionScope.get("current_session_user").getNickname()}"/><br /> 
								<label class="text text-primary" for="user_password_input">
								<fmt:message key="label.password" />
								</label><br /> 
								<input type="password"
									class="form-control border-primary" id="user_password_input"
									name="employee_password" /><br />
							</div>
							<div>
								<button type="submit" class="btn btn-outline-primary" 
								name="command" value="login_user"><fmt:message key="button.login" />						
								</button>
								<button type="submit" class="btn btn-outline-primary" 
								name="command" value="logout_user"><fmt:message key="button.logout" />						
								</button>
								<button type="submit" class="btn btn-outline-primary" 
								name="command" value="goto_page_cabinet"><fmt:message key="button.user_cabinet" />						
								</button>
								<button class="btn btn-outline-primary" data-dismiss="modal"><fmt:message key="button.close" />						
								</button>
							</div>
						</form>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>		
		
		<div class="container">
			<div class="row">
				<div class="col-4 d-flex justify-content-start">
					<img src="sources/images/logo-airline-100.png" class="img-fluid"
						alt="Responsive image" />
				</div>
				<div class="col-8 d-flex justify-content-end">
					
					<!-- <div class="btn btn-link" onclick="userNameOnClick()"> -->
					<div class="btn btn-link" onclick="showModalWindowLogin()">
						${sessionScope.current_session_user.getFirstName()}
						${sessionScope.current_session_user.getLastName()}
					</div>
					<form action="" method="post">
						<input type="hidden" name="command" value="set_language" /> <input
							type="hidden" name="page" value="${sessionScope.current_page}" />
						<button class="btn btn-outline-primary" type="submit"
							name="language" value="ru"><fmt:message key="label.ru" /></button>
						<button class="btn btn-outline-primary" type="submit"
							name="language" value="en"><fmt:message key="label.eng" /></button>
					</form>
				</div>
			</div>
		</div>
		
		
		<div class="container">
			<div class="row">
				<div class="col-12 pb-2">
					<form action="" method="post">
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="home">
							<fmt:message key="button.home" />
						</button>	
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="goto_page_flight_schedule">
							<fmt:message key="button.flight_schedule" />
						</button>					
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="manage_employees">
							<fmt:message key="button.personnel" />
						</button>
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="goto_page_aircraft_management">
							<fmt:message key="button.aircrafts" />
						</button>
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="goto_page_airports_management">
							<fmt:message key="label.airports" />
						</button>
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="goto_page_flights_management">
							<fmt:message key="button.flights" />
						</button>
						<button class="btn btn-outline-primary" type="submit"
							name="command" value="goto_page_select_crew">
							<fmt:message key="button.crews" />
						</button>
					</form>
				</div>
			</div>
		</div>
	
	<script>					
	
		function showModalWindowLogin() {
			$("#modal-window-login-logout").modal('show');
		}
	</script>