<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>${success}</div>
<c:if test="${success == true}">
    <div class="alert alert-success">
        <strong>Opération réalisée avec succes!</strong> Indicates a successful or positive action.
    </div>
</c:if>
<c:if test="${success == false}">
    <div class="alert alert-danger">
        <strong>les erreurs suivantes se sont produites</strong> ${error}.
    </div>
</c:if>