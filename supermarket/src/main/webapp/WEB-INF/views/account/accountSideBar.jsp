<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="list-group" style="margin-top: 80px;">

	<security:authorize access="isAuthenticated()">
		<a class="list-group-item" id="accPersonal" href="${contextRoot}/account/personal">Personal</a>
		<a class="list-group-item" id="accAddress" href="${contextRoot}/account/address">Address</a>
	</security:authorize>
	
	<security:authorize access="hasAuthority('USER')">
		<a class="list-group-item" id="accOrders" href="${contextRoot}/account/orders">Orders</a>
	</security:authorize>
</div>