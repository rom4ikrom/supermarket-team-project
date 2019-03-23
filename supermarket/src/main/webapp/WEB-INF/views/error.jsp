<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="cssCustom" value="/resources/css/custom" />
<spring:url var="cssLinked" value="/resources/css/linked" />

<spring:url var="imgIcons" value="/resources/img/icons" />

<spring:url var="jsCustom" value="/resources/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- Link Bootstrap Core CSS -->
<link rel="stylesheet" type="text/css"
	href="${cssLinked}/bootstrap.css">

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
		<div class="navigation clearfix">
			<div class="container">
				<!-- Main navigation bar -->
				<nav>
					<ul class="menu">
						<li><a id="home" href="${contextRoot}/home">Home</a></li>
					</ul>
				</nav>
			</div>
		</div>

		<!-- Side navigation, which is appeared when the size of screen
				is less then 771px -->
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a id="mobHome" href="${contextRoot}/home">Home</a>
		</div>

		<!-- Button to open side nav -->
		<div class="container">
			<div class="sidenav_button">
				<span onclick="openNav()">&#9776;</span>
			</div>
		</div>


		<div class="content">

			<section>
				<div class="container">
					
					<div class="row">
						<div class="col-md-12">
							
							<div class="jumbotron">
								
								<h1>${errorTitle}</h1>
								
								<blockquote style="word-wrap: break-word">
									${errorDescription}
								</blockquote>
								
							</div>
							
						</div>
					</div>
					
				</div>
			</section>

		</div>

		<%@include file="./shared/footer.jsp"%>
	</div>

<script src="${jsCustom}/main.js"></script>

</body>

</html>