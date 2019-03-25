<%@include file="../../shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container" style="margin-top: 10px;">
		<div class="row">
		
			<div class="col-md-6">
				<h3>Select Shipping Address</h3>
				
				<div class="row">
					<c:forEach items="${addresses}" var="address">
						<div class="col-md-12">
							<table class="confirm-table">
								<tr>
									<td>Address Line One</td>
									<td>${address.addressLineOne}</td>
								</tr>
								<tr>
									<td>Address Line Two</td>
									<td>${address.addressLineTwo}</td>
								</tr>
								<tr>
									<td>Town - County</td>
									<td>${address.town} - ${address.county}</td>
								</tr>
								<tr>
									<td>Postcode</td>
									<td>${address.postcode}</td>
								</tr>
								<tr>
									<td>Country</td>
									<td>${address.country}</td>
								</tr>
							</table>
							<div class="text-center confirm-control">
								<a href="${flowExecutionUrl}&_eventId_addressSelection&shippingId=${address.id}"
								class="btn btn-primary">Select</a>
							</div>
							<hr>
						</div>
					</c:forEach>
				</div>
			
			</div><!-- End col-4 -->
			
			<div class="col-md-6">
				
				<h3>Add New Address</h3>
				
				<sf:form
					method="POST"
					class="form-container"
					id="billingFrom"
					modelAttribute="shipping">
					
					<label for="addLineOne">Address Line One <span class="required-red">*</span></label>
              		<sf:errors path="addressLineOne" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="addressLineOne" placeholder="Address Line One" name="addLineOne" />

             		<label for="addLineTwo">Address Line Two <span class="required-red">*</span></label>
              		<sf:errors path="addressLineTwo" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="addressLineTwo" placeholder="Address Line Two" name="addLineTwo" />
              
		            <label for="town">Town <span class="required-red">*</span></label>
		            <sf:errors path="town" cssClass="help-block" element="em"></sf:errors>
		            <sf:input type="text" path="town" placeholder="Town" name="town" />
		            
		            <label for="county">County / State</label>
              		<sf:input type="text" path="county" placeholder="County" name="county" />

              		<label for="postcode">Postcode <span class="required-red">*</span></label>
              		<sf:errors path="postcode" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="postcode" placeholder="Postcode" name="postcode" />
              
              		<label for="country">Country <span class="required-red">*</span></label>
              		<sf:errors path="country" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="country" placeholder="Country" name="country" />
              		
              		<div class="text-center">
              			<button type="submit" name="_eventId_saveAddress" class="btn btn-register btn-width-50">
							<span class="fa fa-plus"></span> Add Address	
						</button>
					</div>
				</sf:form>
				
			</div><!-- End of col-8 -->
			
		</div><!-- End of row -->
	</div>
</section>
<%@include file="../../shared/flows-footer.jsp"%>