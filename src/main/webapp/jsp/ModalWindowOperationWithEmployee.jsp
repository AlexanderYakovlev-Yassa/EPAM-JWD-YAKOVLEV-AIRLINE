		<div class="modal fade" id="modal-window-operation-with-employee" role="dialog">
			<div class="modal-dialog modal-dialog-centered modal-lg">
				<div class="modal-content">
					<div class="modal-header">
        				<h5 id="title-of-modal-window" class="modal-title text-center text-primary">
        					<fmt:message key="label.operation_with_employee"/>
        				</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
					<div class="modal-body">
					<div class="container">
					<div class="row">
						<div class="col-12">
						<form id="manage-employee-form" class="form" action="" method="post">
							<input type="hidden" name="page" value="employee"/>
							<div class="container">
								<div class="row">								
									<div class="col-md-4">
										<div class="form-group">
											<label for="current-employee-nickname" class="text-primary">
												<fmt:message key="label.user_nickname" />
											</label><br/>
											<input type="text" name="employee_nickname"
													id="current-employee-nickname"
													class="form-control border-primary" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="current-employee-first-name"
													class="text-primary"> 
												<fmt:message key="label.user_first_name" />
											</label><br /> 
											<input type="text" name="employee_first_name"
													id="current-employee-first-name"
													class="form-control border-primary" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="current-employee-last-name" class="text-primary">
												<fmt:message key="label.user_last_name" />
											</label><br /> 
											<input type="text" name="employee_last_name"
													id="current-employee-last-name"
													class="form-control border-primary" />
										</div>
									</div>
									
									<div class="container">
										<div class="row">
											<div class="col-md-4">										
												<div class="form-group">
													<label for="current-employee-system-role-name"
															class="text-primary"> <fmt:message
															key="label.system_role" />
													</label><br />
													<div class="btn-group">
														<button type="button" id="current-employee-system-role-name"
																class="btn btn-outline-primary dropdown-toggle"
																data-toggle="dropdown" aria-haspopup="true"
																aria-expanded="false"><fmt:message key="label.not_defined" />
														</button>
														<div class="dropdown-menu">
															<c:forEach var="elem"
																	items="${sessionScope.all_system_role_list}">
																<a class="dropdown-item" href="#"
																	onclick="dropDownPick(
																	'current-employee-system-role-name', '${elem.systemRoleName}' ,
																	'current-employee-system-role-id', '${elem.systemRoleID}')">
																	<c:out value="${elem.systemRoleName}"></c:out>
																</a>
															</c:forEach>
														</div>
														<input type="hidden" id="current-employee-system-role-id"
															name="system_role_id" />
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for="current-employee-crew-role-name"
															class="text-primary"> 
															<fmt:message key="label.crew_role" />
													</label><br />
													<div class="btn-group">
														<button type="button" id="current-employee-crew-role-name"
																class="btn btn-outline-primary dropdown-toggle"
																data-toggle="dropdown" aria-haspopup="true"
																aria-expanded="false">
															<fmt:message key="label.not_defined" />
														</button>
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
														<input type="hidden" id="current-employee-crew-role-id"	name="crew_role_id" />
													</div>
												</div>
											</div>
											<div class="col-md-4">	
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
										</div>
									</div>							
									<div class="container">
										<div class="row">
											<div class="col-md-12">
												<button type="submit" class="btn btn-outline-primary"
													name="command" value="goto_page_employee_flights_schedule">
													<fmt:message key="button.showw_flights" />
												</button>
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
									</div><br/><br/>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>												
					</div>
					<div class="modal-footer">
						<div id="buttons-of-modal-window" class="float-right">
							<button class="btn btn-outline-primary" data-dismiss="modal">
								<fmt:message key="button.close" />
							</button>							
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script>
		
		function message() {
			var warningMessage = '${sessionScope.warning_message}';
			var successMessage = '${sessionScope.success_message}';
			
			if ((warningMessage == "") && (successMessage == "")) {
				return;
			}
			
			$("#modal-window-status-operation-message").modal('show');
		}
		</script>