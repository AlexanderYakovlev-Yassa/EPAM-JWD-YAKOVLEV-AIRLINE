		<div class="modal fade" id="modal-window-status-operation-message" role="dialog">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
        				<h5 id="title-of-modal-window" class="modal-title text-center text-primary">
        					<fmt:message key="modal.operation_message"/>
        				</h5>
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
					<div class="modal-body">
							<div id="message-of-remove-modal-window">								
								<h5>${sessionScope.warning_message}</h5>
								<h5>${sessionScope.success_message}</h5>
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