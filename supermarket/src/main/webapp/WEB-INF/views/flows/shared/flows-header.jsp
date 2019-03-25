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
<link rel="stylesheet" type="text/css"
	href="${cssLinked}/bootstrap.css">

<!-- Link DataTables jQuery Plugin Style -->
<link rel="stylesheet" href="${cssLinked}/dataTables.bootstrap4.css">	

<!-- Link Font Awesome Style -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Link Custom Style -->
<link rel="stylesheet" href="${cssCustom}/main.css">
<link rel="stylesheet" href="${cssCustom}/create_account.css">
<link rel="stylesheet" href="${cssCustom}/nav.css">

<script type="text/javascript">

	var menu = '${title}';

	if(window.location.pathname == '/supermarket/register') {
		menu = 'Register';
	} else if(window.location.pathname == '/supermarket/cart/checkout') {
		menu = 'Checkout';
	}
	
	document.title = 'Fresh Fruits - ' + menu;
	
	window.menu = menu;
	window.contextRoot = '${contextRoot}';
</script>

<title>Fresh Fruits - ${title}</title>
</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./flows-navbar.jsp"%>

		<div class="content">