		<div><br/>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-4 d-flex justify-content-start">
					<img src="sources/images/logo-airline-100.png" class="img-fluid"
						alt="Responsive image" />
				</div>
				<div class="col-8 d-flex justify-content-end">
					
					<div class="btn btn-link" onclick="userNameOnClick()">
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
	
		function userNameOnClick(){						
			let request = new XMLHttpRequest();							
			request.onreadystatechange = function () {								
				if (this.readyState == 4 && this.status == 200) {
					refreshWindow(window, this);
				}
			} 								
			request.open("POST", "", true);
				request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				request.send("command=goto_page_login");
		}	
		
		function refreshWindow(window, request) {
			window.document.open();
			window.document.write(request.response);
			window.document.close();
		}
	</script>