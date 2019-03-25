<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
		
			<div class="col-md-3">
				<%@include file="accountSideBar.jsp" %>
			</div>
			
			<div class="col-md-9">
			
				<div class="text-center">
					<h4>Billing Address</h4>
				</div>
				
				<form class="form-container">
					<div class="row">
						
						<div class="col-md-6">
	
			              <label for="addLineOne">Address Line One</label>
			              <input type="text" placeholder="Address Line One" 
			              		id="addLineOne" value="${billing.addressLineOne}" disabled/>
			
			              <label for="addLineTwo">Address Line Two</label>
			              <input type="text" placeholder="Address Line Two" 
			              		id="addLineTwo" value="${billing.addressLineTwo}" disabled/>
			              
			              <label for="town">Town</label>
			              <input type="text" placeholder="Town" 
			              		id="town" value="${billing.town}" disabled/>
	                         
	            		</div>
	            
	            		<div class="col-md-6">
	            
			              <label for="county">County / State</label>
			              <input type="text" placeholder="County" 
			              		id="county" value="${billing.county}" disabled/>
			
			              <label for="postcode">Postcode</label>
			              <input type="text" placeholder="Postcode" 
			              	id="postcode" value="${billing.postcode}" disabled/>
			              
			              <label for="country">Country</label>
			              <input type="text" placeholder="Country" 
			              	id="country" value="${billing.country}" disabled/>
	              
	            		</div>
						
					</div>
					<!-- ADD CONTROLS -->
				</form>
				
				<c:if test="${not empty listShipping}">
					<c:forEach items="${listShipping}" var="shipping">
						<div class="text-center">
							<h4>Shipping Addresses</h4>
						</div>
						<form class="form-container">
							<div class="row">
								<div class="col-md-6">
	
					              <label for="addLineOne">Address Line One</label>
					              <input type="text" placeholder="Address Line One" 
					              		id="addLineOne" value="${shipping.addressLineOne}" disabled/>
					
					              <label for="addLineTwo">Address Line Two</label>
					              <input type="text" placeholder="Address Line Two" 
					              		id="addLineTwo" value="${shipping.addressLineTwo}" disabled/>
					              
					              <label for="town">Town</label>
					              <input type="text" placeholder="Town" 
					              		id="town" value="${shipping.town}" disabled/>
	                         
	            				</div>
	            
	            				<div class="col-md-6">
	            
					              <label for="county">County / State</label>
					              <input type="text" placeholder="County" 
					              		id="county" value="${shipping.county}" disabled/>
					
					              <label for="postcode">Postcode</label>
					              <input type="text" placeholder="Postcode" 
					              	id="postcode" value="${shipping.postcode}" disabled/>
					              
					              <label for="country">Country</label>
					              <input type="text" placeholder="Country" 
					              	id="country" value="${shipping.country}" disabled/>
	              
	            				</div>
							</div>
							<!-- ADD CONTROLS -->
						</form>
					</c:forEach>
				</c:if>
			</div>
			
		</div><!-- end of row -->
	</div>
</section>