<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>

	<%@ include file="navbar.jsp" %>

	<div class="container">

	<div class="starter-template">
		<h1>Spring Boot Web JSP Example</h1>
		<h2>Message: <spring:message code="label.welcome.message" /></h2>
	</div>

	</div>
	<!-- /.container -->

	<%@ include file="footer.jsp" %>

</body>

</html>
