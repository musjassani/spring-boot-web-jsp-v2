<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container">
		<%@ include file="message.jsp" %>

		<div class="starter-template">
			<div class="panel panel-default">
				<div class="panel-heading"><spring:message code="label.liste.des.pays"/></div>

				<div class="panel-body">
					<c:forEach items="${pays}" var="p">
						<div>
							${p.nom}
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading"><spring:message code="label.ajouter.un.pays"/></div>
				<div class="panel-body">
					<form action="<spring:url value='/pays'/>" method="post">

						<%--https://stackoverflow.com/questions/34048617/spring-boot-how-to-use-hiddenhttpmethodfilter--%>
						<input type="hidden" name="_method" value="put"/>

						<div class="form-group">
							<spring:message code="label.add.pays.code" var="code_text"/>
							<label for="code">${code_text}</label>
							<input class="form-control" placeholder="${code_text}" name="code" id="code" type="text"/>
						</div>
						<div class="form-group">
							<spring:message code="label.add.pays.langue" var="langue_text"/>
							<label for="langue">${langue_text}</label>
							<input class="form-control" placeholder="${langue_text}" name="langue" id="langue" type="text"/>
						</div>
						<div class="form-group">
							<spring:message code="label.add.pays.Nom" var="nom_text"/>
							<label for="nom">${nom_text}</label>
							<input class="form-control" placeholder="${nom_text}" name="nom" id="nom" type="text"/>
						</div>
						<button type="submit" class="btn btn-default"><spring:message code="label.valider"/></button>
					</form>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<%@ include file="footer.jsp" %>

</body>

</html>
