<%@include file="../../shared/flows-header.jsp" %>
<section>
	<div class="container">
	
		<div class="alert alert-success">
			<h3 class="text-center">Your Order is Confirmed!</h3>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<h2>Invoice</h2>
			</div>
			<div class="col-md-6 text-right">
				<h2>Order # ${orderDetail.id}</h2>
			</div> 
		</div>
				
		<div class="row">
			<div class="col-md-6">
				<address>
					Billed To: ${orderDetail.user.firstName}
					${orderDetail.user.lastName}<br>
					${orderDetail.billing.addressLineOne}<br>
					${orderDetail.billing.addressLineTwo}<br>
					${orderDetail.billing.town} - ${orderDetail.billing.postcode}<br>
					${orderDetail.billing.county} - ${orderDetail.billing.country}<br>
				</address>
			</div>
			<div class="col-md-6 text-right">
				<address>
					Shipped To: ${orderDetail.user.firstName}
					${orderDetail.user.lastName}<br>
					${orderDetail.shipping.addressLineOne}<br>
					${orderDetail.shipping.addressLineTwo}<br>
					${orderDetail.shipping.town} - ${orderDetail.shipping.postcode}<br>
					${orderDetail.shipping.county} - ${orderDetail.shipping.country}<br>
				</address>
			</div>
		</div>

		<div class="row">

			<div class="col-md-6">
				<p>Payment Method:</p>
				<span>Card Payment</span> <br>
				<p>${orderDetail.user.email}</p>
			</div>

			<div class="col-md-6 text-right">
				<p>Order Date:</p>
				<p>${orderDetail.orderDate}</p>
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<a href="${contextRoot}/show/all/products" class="btn btn-warning">Continue Shopping</a>
			</div>
		</div>
	</div>
</section>
<%@include file="../../shared/flows-footer.jsp"%>