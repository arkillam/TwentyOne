<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/TwentyOne.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<title>${smb.title}</title>

<script>
	$(function() {
		// my ".ready()" code (I miss the earlier jQuery's explicit .ready() style ...)
		console.log("DOM is loaded and ready for us to begin work.");
	});
</script>

</head>

<body>
	<p class="pageheader">${smb.title}</p>

	<c:if test="${not empty smb.errorMessages}">
		<c:if test="${fn:length(smb.errorMessages) lt 2}">
			<c:forEach items="${smb.errorMessages}" var="msg">
				<p class="errorMessage">${msg}</p>
			</c:forEach>
		</c:if>
		<c:if test="${fn:length(smb.errorMessages) gt 1}">
			<ul>
				<c:forEach items="${smb.errorMessages}" var="msg">
					<li class="errorMessage">${msg}</li>
				</c:forEach>
			</ul>
		</c:if>
	</c:if>

	<c:if test="${not empty smb.message}">
		<p>${smb.message}</p>
	</c:if>

</body>

</html>
