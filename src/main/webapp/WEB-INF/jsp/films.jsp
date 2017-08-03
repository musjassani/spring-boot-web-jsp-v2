<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.css" />


	<%--<spring:url value="/css/main.css" var="springCss" />--%>
	<%--<link href="${springCss}" rel="stylesheet" />--%>

	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />


</head>
<body>

	<%@include file="navbar.jsp"%>

	<div class="container">
		<%@ include file="message.jsp" %>

		<div class="starter-template">

			<div class="panel panel-default">
				<div class="panel-heading"><spring:message code="label.liste.des.film"/></div>

				<div class="panel-body">
					<c:forEach items="${films}" var="film">
						<div>
							${film.titre}
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading"><spring:message code="label.ajouter.un.film"/></div>
				<div class="panel-body">
					<form action="<spring:url value='/films'/>" method="post">

						<%--https://stackoverflow.com/questions/34048617/spring-boot-how-to-use-hiddenhttpmethodfilter--%>
						<input type="hidden" name="_method" value="put"/>

						<div class="form-group">
							<spring:message code="label.add.film.annee" var="annee_text"/>
							<label for="annee">${annee_text}</label>
							<input class="form-control" placeholder="${annee_text}" name="annee" id="annee" type="text"/>
						</div>
						<div class="form-group">
							<spring:message code="label.add.film.titre" var="titre_text"/>
							<label for="titre">${titre_text}</label>
							<input class="form-control" placeholder="${titre_text}" name="titre" id="titre" type="text"/>
						</div>
						<div class="form-group">
							<label for="codePays"><spring:message code="label.add.filme.Pays"/> </label>
							<select name="codePays" id="codePays">
								<option value="">-</option>
								<c:forEach items="${pays}" var="p">
									<div>
										<option value="${p.code}">${p.nom}</option>
									</div>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-default"><spring:message code="label.valider"/></button>
					</form>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<%@include file="footer.jsp"%>

</body>

</html>
