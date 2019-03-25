<section>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
		
			<div class="col-md-3">

				<%@include file="accountSideBar.jsp" %>

			</div>
			
			<div class="col-md-9">
			
				<div class="text-center">
					<h3>Personal Details</h3>
				</div>
				
				<form class="form-container">
					
					<label for="fname">First Name</label>
              		<input type="text" value="${user.firstName}" id="fname" disabled/>
              		
              		<label for="lname">Last Name</label>
              		<input type="text" value="${user.lastName}" id="lname" disabled/>
              		
              		<label for="tel">Contact Number</label>
              		<input type="text" value="${user.tel}" id="tel" disabled/>
              		
              		<label for="email">Email</label>
              		<input type="text" value="${user.email}" id="email" disabled/>
					
				</form>
			
			</div>
			
		</div><!-- end of row -->
	</div>
</section>
