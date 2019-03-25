<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container">
		<div class="row">
		
			<div class="col-md-2">
				<div class="list-group">
					<a class="list-group-item" href="${contextRoot}/account/personal">Personal</a>
					<a class="list-group-item" href="${contextRoot}/account/address">Address</a>
					<a class="list-group-item" href="${contextRoot}/account/orders">Orders</a>
				</div>
			</div>
			
			<div class="col-lg-10">
				
				<%-- 
				<!-- Loading the home content -->
				<c:if test="${userClickAccPersonal == true}">
					<%@include file="./account/accPersonal.jsp"%>
				</c:if>
				
				<!-- Loading the home content -->
				<c:if test="${userClickAccAddress == true}">
					<%@include file="./account/accAddress.jsp"%>
				</c:if>
				
				<!-- Loading the home content -->
				<c:if test="${userClickAccOrders == true}">
					<%@include file="./account/accOrders.jsp"%>
				</c:if>
				--%>
				
			</div>
		</div><!-- End of row -->
	</div>
</section>