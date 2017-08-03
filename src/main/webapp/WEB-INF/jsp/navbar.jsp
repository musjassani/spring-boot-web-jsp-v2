<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <spring:url value="/" var="accueilURL"/>
            <a class="navbar-brand ${active == 'accueil' ? 'active' : ''}" href="${accueilURL}"><spring:message code="label.accueil"/></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <spring:url value="/films" var="filmsURL"/>
                <li class="${active == 'films' ? 'active' : ''}"><a href="${filmsURL}"><spring:message code="label.films"/></a></li>

                <spring:url value="/pays" var="paysURL"/>
                <li class="${active == 'pays' ? 'active' : ''}"><a href="${paysURL}"><spring:message code="label.Pays"/></a></li>
            </ul>
        </div>
    </div>
</nav>