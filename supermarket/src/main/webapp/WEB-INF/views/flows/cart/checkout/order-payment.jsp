<%@include file="../../shared/flows-header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<section>
	<div class="container" style="margin-top: 10px;">
		<div class="row">
			
			<div class="col-md-6">
				<div class="text-center">
					<h3>Products</h3>
				</div>
				<div class="row">

					<c:forEach items="${checkoutModel.cartLines}" var="cartLine">
					
						<div class="col-md-12">
							<table class="product-payment-table">
								<thead>
									<tr>
										<td style="width: 25%;">Name</td>
										<td style="width: 31%;">Variety</td>
										<td style="width: 16%;">Qnty kg</td>
										<td style="width: 12%;">Price</td>
										<td style="width: 16%;">Total</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>${cartLine.product.name}</td>
										<td>${cartLine.product.variety}</td>
										<td>${cartLine.productCount}</td>
										<td>&#163; ${cartLine.buyingPrice}</td>
										<td>&#163; ${cartLine.total}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</c:forEach>
					
				</div>
			</div>
			
			<div class="col-md-6">
			
				<div class="text-center">
					<h3>Payment</h3>
				</div>
				
				<h5>Choose Payment Method</h5>
				
				<c:forEach items="${listPaymentDetails}" var="paymentDetail">
					<div class="payment-details">
						<div class="row">
							<div class="col-md-5 my-auto text-center">
								<p>${paymentDetail.cardNumber}</p>
							</div>
							<div class="col-md-4 my-auto text-center">
								<p>${paymentDetail.cardName}</p>
							</div>
							<div class="col-md-3 my-auto text-center">
								<!-- Action Button -->
								<a href="${flowExecutionUrl}&_eventId_payChosen" class="btn btn-primary">Choose</a>
							</div>
						</div>
						
						
					</div>
				</c:forEach>
				
				<h5>Add New Payment Details</h5>
				
				<sf:form class="form-container"
							method="POST"
							id="addPaymentDetails"
							modelAttribute="paymentDetails">
				
					<label for="cardNumber">Card Number <span class="required-red">*</span></label>
					<sf:errors path="cardNumber" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="cardNumber" placeholder="Valid Card Number" id="cardNumber" />
              		
              		<label for="cardName">Name On Card <span class="required-red">*</span></label>
              		<sf:errors path="cardName" cssClass="help-block" element="em"></sf:errors>
              		<sf:input type="text" path="cardName" placeholder="Name On Card" id="cardName" />
              		
              		<div class="row">
              			<div class="col-md-7">
              				
              				<label for="expMonth" style="width:100%;">Expiry Date <span class="required-red">*</span></label>
              					
              				<input type="text" placeholder="MM" id="expMonth" style="width:40%; margin-right:20px;"/>
              						
              				<input type="text" placeholder="YY" id="expYear" style="width:40%;"/>
              						
              			</div>
              			<div class="col-md-5">
              				<label for="cvv">CVV <span class="required-red">*</span></label>
              				<sf:input type="text" path="cvv" placeholder="CVV" id="cvv" />
              			</div>
              		</div>
              		
              		<div class="text-center">
              			<div class="checkout-total">Checkout Total &#163; ${checkoutModel.checkoutTotal}</div>
              		</div>
              		
              		<a class="btn btn-register" href="${flowExecutionUrl}&_eventId_pay">Pay</a>
              		
				</sf:form>
				
			</div>
			
		</div><!-- end of row -->
	</div>
</section>
<%@include file="../../shared/flows-footer.jsp"%>
<script src="${jsCustom}/cardPaymentValidation.js"></script>