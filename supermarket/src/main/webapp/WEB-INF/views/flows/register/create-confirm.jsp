<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<section>
	<div class="container">
		<div class="row">
		
			<div class="col-md-6">
			<div class="user-info">
				<h3>Personal Information</h3>
				<table class="confirm-table">
					<tr>
						<td>First Name:</td>
						<td>${registerModel.user.firstName}</td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td>${registerModel.user.lastName}</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td>${registerModel.user.email}</td>
					</tr>
					<tr>
						<td>Contact Number: </td>
						<td>${registerModel.user.tel}</td>
					</tr>
					<tr>
						<td>Password Hint:</td>
						<td>${registerModel.user.hint}</td>
					</tr>
				</table>
				
			</div>
			</div>
			
			<div class="col-md-6">
			<div class="user-info">
			<h3>Address Information</h3>
				<table class="confirm-table">
					<tr>
						<td>Address Line One:</td>
						<td>${registerModel.billing.addressLineOne}</td>
					</tr>
					<tr>
						<td>Address Line Two:</td>
						<td>${registerModel.billing.addressLineTwo}</td>
					</tr>
					<tr>
						<td>Town</td>
						<td>${registerModel.billing.town}</td>
					</tr>
					<tr>
						<td>County / State:</td>
						<td>${registerModel.billing.county}</td>
					</tr>
					<tr>
						<td>Postcode</td>
						<td>${registerModel.billing.postcode}</td>
					</tr>
					<tr>
						<td>Country</td>
						<td>${registerModel.billing.country}</td>
					</tr>
				</table>
				
			</div>
			</div>
		
		</div><!-- End of row -->
		
		<div class="row confirm-control">
			<div class="col-md-4 text-center">
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
			</div>
			<div class="col-md-4 text-center">
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary" id="confirm">Confirm</a>
			</div>
			<div class="col-md-4 text-center">
				<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
			</div>
		</div>
		
	</div>
</section>

<%@include file="../shared/flows-footer.jsp"%>