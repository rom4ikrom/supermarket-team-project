<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
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

<!-- Link Bootstrap Core CSS -->
<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">

<!-- Link Datables jQuery Plugin Style -->	
<link rel="stylesheet" 
		type="text/css" 
		href="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.css"/>

<link rel="stylesheet" href="${css}/main.css">
<link rel="stylesheet" href="${css}/nav.css">

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<title>Fresh Fruits</title>
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
			
			<!-- Loading the login content -->
			<c:if test="${userClickLogin == true}">
				<%@include file="customerLogin.jsp"%>
			</c:if>
			
			<!-- Loading the view products content -->
			<c:if test="${userClickCatalog == true}">
				<%@include file="products.jsp"%>
			</c:if>
			
		</div>



		<%@include file="./shared/footer.jsp" %>
	</div>
	
	<!-- Link Bootstrap Core JS -->
	<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
		crossorigin="anonymous">
		
	<script src="${js}/jquery.js"></script>
	
	<!-- Link Datables jQuery Plugin JS -->
	<script type="text/javascript" 
			src="https://cdn.datatables.net/v/bs4/dt-1.10.18/datatables.min.js">
	</script>
	
	<!-- Loading Custom JS -->
	<script src="${js}/main.js"></script>

</body>
</html>

