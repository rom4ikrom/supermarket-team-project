<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="cssCustom" value="/resources/css/custom" />
<spring:url var="cssLinked" value="/resources/css/linked" />

<spring:url var="jsCustom" value="/resources/js" />
<spring:url var="jsLinked" value="/resources/js/linked" />

<spring:url var="imgHeaders" value="/resources/img/headers" />
<spring:url var="imgIcons" value="/resources/img/icons" />
<spring:url var="imgProducts" value="/resources/img/products" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- add csrf tokens later -->
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<!-- Link Bootstrap Core CSS -->
<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"> -->
	
<link rel="stylesheet" type="text/css"
	href="${cssLinked}/bootstrap.css">

<!-- Link DataTables jQuery Plugin Style -->
<!-- <link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css" /> -->
<link rel="stylesheet" href="${cssLinked}/dataTables.bootstrap4.css">	

<!-- Link Font Awesome Style -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Link Custom Style -->
<link rel="stylesheet" href="${cssCustom}/main.css">
<link rel="stylesheet" href="${cssCustom}/nav.css">

<script type="text/javascript">

	var menu = '${title}';
	menu = menu.replace(/\s/g, "");
	
	window.menu = menu;
	window.contextRoot = '${contextRoot}';
</script>

<title>Fresh Fruits - ${title}</title>
</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Loading the about us content -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Loading the view products content -->
			<c:if
				test="${userClickAllProducts == true || userClickRegionProducts == true}">
				<%@include file="products.jsp"%>
			</c:if>

			<!-- Loading the view single product content -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Loading the view manage product content -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			<!-- Loading the view basket content -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
			
			<!-- Loading the view basket content -->
			<c:if test="${userClickAccPersonal == true}">
				<%@include file="account.jsp"%>
			</c:if>

		</div>



		<%@include file="./shared/footer.jsp"%>
	</div>
	
	<!-- jQuery core JavaScript -->
	<script src="${jsLinked}/jquery.js"></script>

	<!-- Link Bootstrap Core JS -->
	
	<!-- <link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous"> -->
		
	<script src="${jsLinked}/bootstrap.bundle.js"></script>

	

	<!-- Link Datables jQuery Plugin JS -->
	
	<!-- <script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js">
	</script> -->
	
	<script src="${jsLinked}/jquery.dataTables.js"></script>
	<script src="${jsLinked}/dataTables.bootstrap4.js"></script>
	
	<!-- Bootbox js -->
	<script src="${jsLinked}/bootbox.min.js"></script>

	<!-- Loading Custom JS -->
	<script src="${jsCustom}/main.js"></script>

</body>
</html>

