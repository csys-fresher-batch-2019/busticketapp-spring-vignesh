<c:if test="${not empty param.errorMessage}">
<font color="red">${param.errorMessage}</font>
</c:if>
<c:if test="${not empty param.infoMessage}">
<font color="green">${param.infoMessage}</font>
</c:if>