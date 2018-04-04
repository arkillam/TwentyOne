<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- Displays error messages.  If more than one string is in the list, uses an unordered list to display. -->

<%@ attribute name="errorMessages" required="false"
	type="java.util.List" description="list of error message strings"%>

<c:if test="${not empty errorMessages}">
	<c:if test="${fn:length(errorMessages) lt 2}">
		<c:forEach items="${errorMessages}" var="msg">
			<p class="errorMessage">${msg}</p>
		</c:forEach>
	</c:if>
	<c:if test="${fn:length(errorMessages) gt 1}">
		<ul>
			<c:forEach items="${errorMessages}" var="msg">
				<li class="errorMessage">${msg}</li>
			</c:forEach>
		</ul>
	</c:if>
</c:if>
