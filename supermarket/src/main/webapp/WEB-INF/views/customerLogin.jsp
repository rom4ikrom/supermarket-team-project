<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="cssCustom" value="/resources/css/custom" />
<spring:url var="cssLinked" value="/resources/css/linked" />

<spring:url var="jsCustom" value="/resources/js" />
<spring:url var="jsLinked" value="/resources/js/linked" />

<spring:url var="imgIcons" value="/resources/img/icons" />

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

					<!-- when credentials are wrong -->

					<c:if test="${not empty message}">

						<div class="row">

							<div class="offset-md-3 col-md-6">

								<div class="alert alert-danger" style="margin-top: 5px;">${message}</div>

							</div>
						</div>

					</c:if>

					<!-- when user logout -->

					<c:if test="${not empty logout}">

						<div class="row">

							<div class="offset-md-3 col-md-6">

								<div class="alert alert-success" style="margin-top: 5px;">${logout}</div>

							</div>
						</div>

					</c:if>

					<div class="row">
						<div class="offset-md-3 col-md-6">
							<form class="form-container" action="${contextRoot}/login"
									method="POST">

								<div class="row">
									<div class="col-md-12">


										<h3>Sign In</h3>

										<label for="username">Email</label> <input type="text"
											name="username" placeholder="Email" /> <label for="password">Password</label>
										<input type="text" name="password" placeholder="Password" />
										
										
										<%-- <p class="admin-login">
											<a href="${contextRoot}/admin/login">Admin or Staff
												Member? Login here!</a>
										</p> --%>

										<div class="row">
											<div class="col-md-6">
												<input type="submit" class="btn login" value="Login"/>
												<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
											</div>
											<div class="col-md-6">
												<button type="reset" class="btn cancel"
													onclick="closeForm()">Clear</button>
											</div>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<a href="${contextRoot}/register" class="btn register">Create
											Account</a>
									</div>
								</div>

							</form>
						</div>
					</div>
				</div>
			</section>

		</div>

		<%@include file="./shared/footer.jsp"%>
	</div>
	
	<!-- jQuery core JavaScript -->
	<script src="${jsLinked}/jquery.js"></script>
	
	<!-- jQuery Validate JavaScript -->
	<script src="${jsLinked}/jquery.validate.js"></script>

	<!-- Link Bootstrap Core JS -->
	<script src="${jsLinked}/bootstrap.bundle.js"></script>

	<!-- Loading Custom JS -->
	<script src="${jsCustom}/main.js"></script>

</body>
</html>