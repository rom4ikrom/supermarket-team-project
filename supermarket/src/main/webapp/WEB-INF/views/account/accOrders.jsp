<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
		
			<div class="col-md-3">
				<%@include file="accountSideBar.jsp" %>
			</div>
			
			<div class="col-md-9">
			
				<div class="text-center">
					<h3>Your Orders</h3>
				</div>
				
				<c:forEach items="${orderDetails}" var="orderDetail">
				
					<div class="row text-center">
						<div class="col-md-4">
							<h5>Order No ${orderDetail.id}</h5>
						</div>
						<div class="col-md-4">
							<h5>Order Date ${orderDetail.orderDate}</h5>
						</div>
						<div class="col-md-4">
							<h5>Order Total &#163; ${orderDetail.orderTotal}</h5>
						</div>
					</div>
					
					
					
						<div class="row">
							<div class="col-md-12">
								<table class="confirm-table">
									<tr>
										<td style="width: 17%;">Name</td>
										<td style="width: 27%;">Variety</td>
										<td style="width: 17%;">Country</td>
										<td style="width: 13%;">Price</td>
										<td style="width: 13%;">Qnty</td>
										<td style="width: 13%;">Total</td>
									</tr>
									
									<c:forEach items="${orderDetail.orderItems}" var="orderItem">
										<tr>
											<td>${orderItem.product.name}</td>
											<td>${orderItem.product.variety}</td>
											<td>${orderItem.product.country}</td>
											<td>${orderItem.buyingPrice}</td>
											<td>${orderItem.productCount}</td>
											<td>&#163; ${orderItem.total}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
							
						</div>
					<hr>
				</c:forEach>
				
			</div>
			
		</div><!-- end of row -->
	</div>
</section>











	
	
	
